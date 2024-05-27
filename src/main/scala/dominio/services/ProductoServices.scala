package dominio.services

import scala.concurrent.{Future, ExecutionContext}
import slick.jdbc.MySQLProfile.api._

class ProductoServices(db: Database)(implicit ec: ExecutionContext) {

  def crearProducto(nombre: String, descripcion: String, precio: Double, Stock: Int): Future[Int] =
    db.run(ProductsTable += (0, nombre, descripcion, precio, Stock))
}

class ProductoTable(tag: Tag) extends Table[(Long,String,String,Double,Int)](tag,"Productos") {
  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def nombre = column[String]("nombre")
  def descripcion = column[String]("descripcion")
  def precio = column[Double]("precio")
  def Stock = column[Int]("cantidad_en_stock")

  def * = (id, nombre, descripcion, precio,Stock)
}
object ProductsTable extends TableQuery(new ProductoTable(_))
