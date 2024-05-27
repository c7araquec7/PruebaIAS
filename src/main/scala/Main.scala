import akka.actor.TypedActor.dispatcher
import dominio.services.ProductoServices

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object Main extends App {

  val productService = new ProductoServices(DatabaseProvider.db)

  // Ejemplo de uso: Crear un nuevo producto
  val newProduct = productService.crearProducto("Producto de Ejemplo", "Descripción de Ejemplo", 10.99, 100)
  val productId = Await.result(newProduct, Duration.Inf)
  println(s"Producto creado con ID: $productId")
  /*
    // Ejemplo de uso: Obtener todos los productos
    val allProducts = Await.result(productService.getAllProducts, Duration.Inf)
    allProducts.foreach(println)*/

  // Cierra la conexión cuando hayas terminado
  DatabaseProvider.db.close()
}
