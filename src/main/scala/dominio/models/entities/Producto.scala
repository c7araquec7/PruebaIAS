package dominio.models.entities

class Producto {

  case class Producto(id: Long,
                      nombre: String,
                      descripcion: String,
                      precio: Double,
                      Stock: Int)


}
