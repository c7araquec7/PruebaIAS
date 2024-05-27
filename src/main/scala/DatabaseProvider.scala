import slick.jdbc.MySQLProfile.api._

object DatabaseProvider {

  val db: Database = Database.forURL( // Configuración de la conexión a la base de datos
    url = "jdbc:mysql://localhost:3306/iasinventory",
    user = "root",
    password = "sasa",
    driver = "com.mysql.jdbc.Driver"
  )
}

