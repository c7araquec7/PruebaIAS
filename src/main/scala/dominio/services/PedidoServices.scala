package dominio.services

import scala.concurrent.{Future, ExecutionContext}
import slick.jdbc.MySQLProfile.api._

class PedidoServices(db: Database)(implicit ec: ExecutionContext) {

  def crearPedido(productoId: Long, quantityOrdered: Int, orderDate: String, orderStatus: String): Future[Int] =
    db.run(PedidosTable += (0,productoId, quantityOrdered, orderDate, orderStatus))
}

class PedidoTable(tag: Tag) extends Table[(Long,Long,Int,String,String)](tag,"Pedidos") {
  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def productoId = column[Long]("productoId")
  def quantityOrdered = column[Int]("quantityOrdered")
  def orderDate = column[String]("orderDate")
  def orderStatus = column[String]("orderStatus")

  def * = (id, productoId, quantityOrdered, orderDate,orderStatus)
}
object PedidosTable extends TableQuery(new PedidoTable(_))

