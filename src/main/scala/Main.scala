import akka.actor.TypedActor.dispatcher
import dominio.services.{PedidoServices, ProductoServices}

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object Main extends App {

  val productService = new ProductoServices(DatabaseProvider.db)
  val pedidoService = new PedidoServices(DatabaseProvider.db)

  // Ejemplo de uso: Crear un nuevo producto
  val newProduct = productService.crearProducto("Producto de Ejemplo", "Descripción de Ejemplo", 10.99, 100)
  val productId = Await.result(newProduct, Duration.Inf)
  println(s"Producto creado con ID: $productId")

  // Ejemplo de uso: Crear un nuevo pedido
  val newPedido = pedidoService.crearPedido("Producto de Ejemplo", "Descripción de Ejemplo", 10.99, 100)
  val pedidoId = Await.result(newPedido, Duration.Inf)
  println(s"Pedido creado con ID: $pedidoId")

  // Cierra la conexión cuando hayas terminado
  DatabaseProvider.db.close()
}
