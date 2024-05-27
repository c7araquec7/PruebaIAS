package dominio.services

import scala.concurrent.{Future, ExecutionContext}
import slick.jdbc.MySQLProfile.api._

class ProductoServices(db: Database)(implicit ec: ExecutionContext) {

  def crearProducto(nombre: String, descripcion: String, precio: Double, Stock: Int): Future[Int] =
    db.run(ProductsTable += (0, nombre, descripcion, precio, Stock))

  /*def getProducto(id: Int): Future[Option[(Int, String, String, Double, Int)]] =
    db.run(ProductsTable.filter(_.id === id).result.headOption)

  def actualizarProducto(id: Int, nombre: String, descripcion: String, precio: Double, Stock: Int): Future[Int] =
    db.run(ProductsTable.filter(_.id === id).update((id, nombre, descripcion, precio, Stock)))

  def deleteProducto(id: Int): Future[Int] =
    db.run(ProductsTable.filter(_.id === id).delete)

  def listarProdutos: Future[Seq[(Int, String, String, Double, Int)]] =
    db.run(ProductsTable.result)*/

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
