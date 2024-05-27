package dominio.models.entities

class Pedido {

  case class Order(id: Long,
                   productoId: Long,
                   quantityOrdered: Int,
                   orderDate: String,
                   orderStatus: String)
}
