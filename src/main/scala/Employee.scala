
class Employee(employeeID: String,firstName: String,lastName: String,email: String,phoneNumber: String,
               hireDate: String,jobId: String,salary: String) {
  var commisionPct : String = "";
  var managerId : String = "";
  var departmentId : String = "";

  def set_CommisionPct(i_commisionPct: String){
    this.commisionPct = i_commisionPct
  }
  def get_CommisionPct(): String ={
    return commisionPct
  }
  def set_ManagerId(i_managerId: String){
    this.managerId = i_managerId
  }
  def get_ManagerId() : String={
    return managerId
  }
  def set_DepartmentId(i_departmentId: String){
    this.departmentId = i_departmentId
  }
  def get_DepartmentId() : String={
    return this.departmentId
  }
  def get_EmployeeId() : String ={
    return this.employeeID
  }
  def get_FirstName() : String ={
    return this.firstName
  }
  def get_LastName() : String ={
    return this.lastName
  }
  def get_Email() : String ={
    return this.email
  }
  def get_PhoneNumber() : String={
    return this.phoneNumber
  }
  def get_HireDate() : String={
    return this.hireDate
  }
  def get_JobId() : String={
    return this.jobId
  }
  def get_Salary() : String={
    return this.salary
  }
  override def toString = s"Employee()"
}


