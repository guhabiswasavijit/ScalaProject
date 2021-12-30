import org.apache.spark.{SparkConf, SparkContext}

import java.sql.PreparedStatement

object sparkHdfsRead {
  def main(args: Array[String]) = {
    val conf:SparkConf = new SparkConf().setAppName("WordCount").setMaster("local")
    val sc = new SparkContext(conf)
    val input = sc.textFile("hdfs://localhost:8020/geeks/employees.csv")
    val mapFile = input.flatMap(lines => lines.split("\n"))
    mapFile.foreach(line  => {
      var data = line.split(",")
      for ( m1 <-data )
      {
        println(m1 )
      }
      var emp = new Employee(data(0),data(1),data(2),data(3),data(4),data(5),data(6),data(7))
      emp.set_CommisionPct(data.lift(8).getOrElse(null))
      emp.set_ManagerId(data.lift(9).getOrElse(null))
      emp.set_DepartmentId(data.lift(10).getOrElse(null))
      println(emp)
      SqlUtils.usingConnection(db="TUTORIALS"){
        conn => {
          conn.setAutoCommit(false)
          val sqlString = "INSERT INTO employee ( EMPLOYEE_ID, FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?)"
          val pStmt = conn.prepareStatement(sqlString)
          pStmt.setString(1,emp.get_EmployeeId())
          pStmt.setString(2,emp.get_FirstName())
          pStmt.setString(3,emp.get_LastName())
          pStmt.setString(4,emp.get_Email())
          pStmt.setString(5,emp.get_PhoneNumber())
          pStmt.setString(6,emp.get_HireDate())
          pStmt.setString(7,emp.get_JobId())
          pStmt.setString(8,emp.get_Salary())
          pStmt.setString(9,emp.get_CommisionPct())
          pStmt.setString(10,emp.get_ManagerId())
          pStmt.setString(11,emp.get_DepartmentId())
          pStmt.executeUpdate();
          conn.commit()
        }
      }

    }
    )

  }

}
