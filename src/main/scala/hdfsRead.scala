import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.commons.io.IOUtils

import java.net.URI


object hdfsRead {
  def main(args: Array[String]): Unit = {
    val hdfs = FileSystem.get(new URI("hdfs://localhost:8020/"), new Configuration())
    val path = new Path("/geeks/employees.csv")
    val stream = hdfs.open(path)
    val out = IOUtils.toString(stream, "UTF-8")
    //val data = new Array[Byte](1024)
    //val mapFile: Unit = stream.readFully(data)
    println(out)
  }
}