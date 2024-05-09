package progUD8.RetoUD8;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*Clase para la gestión de la BBDD, se declaran variables
 * necesarias para establecer la conexión. Al declarar en variables
 * se parametrizan los datos de conexión 
 */

public class DatabaseManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/tucine";
    private static final String USER = "root";
    private static final String PASS = "admin";

    private Connection miConexion;

    public DatabaseManager() {
        try {
        	miConexion = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
    /*
     * Sinceramente se que lo ideal sería crear un codigo escalable que se puediera adaptar a cualquier
     * tabla de la BBDD, pero no se me acurrido.... así que he creado un metodo por cada operación posible
     * en cada tabla. Todas las operaciones las he realizado medienta la interfaz PreparedStatement añadiendo una
     * capa de seguridad y rendimiento respecto a la interfaz Statement.
     */
    
    	/*Metodo para intsertar pelicular en la BBDD. El metodo recibe tantas variables como columnas tiene la tabla Peliculas
    	 * se crea una variable tipo string llamada sql con la consulta generica. Despues mediante el metodo set de la interfaz
    	 * preparedstatemente de tipo clave-valor se completa la consulta con los valores apotados, lanzando la query con el 
    	 * metodo executeUpdate(). El resto de metodos son iguales a este. Se utiliza la función "try with resources", por lo que
    	 * los flujos se autocierran, no hay que close() manualmente.   	  
    	 */
    public void insertaPelicula(String titulo, int duracionMinutos, String genero, String director, String clasificacionEdad, double precio) {
        String sql = "INSERT INTO Peliculas (titulo, duracionMinutos, genero, director, clasificacionEdad, precio) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = miConexion.prepareStatement(sql)) {
            statement.setString(1, titulo);
            statement.setInt(2, duracionMinutos);
            statement.setString(3, genero);
            statement.setString(4, director);
            statement.setString(5, clasificacionEdad);
            statement.setDouble(6, precio);
            statement.executeUpdate();
            System.out.println("Película insertada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar la pelicula");
        	e.printStackTrace();
        }
    }

    	//Metodo para insertar Sala
    public void insertaSala(int capacidad, double metrosCuadrados) {
        String sql = "INSERT INTO Salas (capacidad, metrosCuadrados) VALUES (?, ?)";
        try (PreparedStatement statement = miConexion.prepareStatement(sql)) {
            statement.setInt(1, capacidad);
            statement.setDouble(2, metrosCuadrados);
            statement.executeUpdate();
            System.out.println("Sala insertada correctamente.");
        } catch (SQLException e) {
        	System.out.println("Error al insertar sala");
        	e.printStackTrace();
            
        }
    }
    	//Metodo para insertar Sala
    public void insertaCine(String nombreCine, String direccion) {
        String sql = "INSERT INTO Cines (nombreCine, direccion) VALUES (?, ?)";
        try (PreparedStatement statement = miConexion.prepareStatement(sql)) {
            statement.setString(1, nombreCine);
            statement.setString(2, direccion);
            statement.executeUpdate();
            System.out.println("Cine insertado correctamente.");
        } catch (SQLException e) {
        	System.out.println("Error al insertar sala");
            e.printStackTrace();
        }
    }
    	//Metodo para borrar pelicula
    public void borraPelicula(int id) {
        String sql = "DELETE FROM Peliculas WHERE id = ?";
        try (PreparedStatement statement = miConexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Película eliminada correctamente.");
            } else {
                System.out.println("No se encontró ninguna película con el ID proporcionado.");
            }
        } catch (SQLException e) {
        	System.out.println("Error al borrar pelicula");
            e.printStackTrace();
        }
    }
    	//Metodo para borrar sala
    public void borraSala(int id) {
        String sql = "DELETE FROM Salas WHERE id = ?";
        try (PreparedStatement statement = miConexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Sala eliminada correctamente.");
            } else {
                System.out.println("No se encontró ninguna sala con el ID proporcionado.");
            }
        } catch (SQLException e) {
        	System.out.println("Error al borrar sala");
            e.printStackTrace();
        }
    }
    	//Metodo para borrar cine
    public void borraCine(int id) {
        String sql = "DELETE FROM Cines WHERE id = ?";
        try (PreparedStatement statement = miConexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cine eliminado correctamente.");
            } else {
                System.out.println("No se encontró ningún cine con el ID proporcionado.");
            }
        } catch (SQLException e) {
        	System.out.println("Error al borrar cine");
            e.printStackTrace();
        }
    }
    	//Metodo para actualizar datos de una pelicula ya existente en la BBDD.
    public void updatePelicula(int id, String titulo, int duracionMinutos, String genero, String director, String clasificacionEdad, double precio) {
        String sql = "UPDATE Peliculas SET titulo = ?, duracionMinutos = ?, genero = ?, director = ?, clasificacionEdad = ?, precio = ? WHERE id = ?";
        try (PreparedStatement statement = miConexion.prepareStatement(sql)) {
            statement.setString(1, titulo);
            statement.setInt(2, duracionMinutos);
            statement.setString(3, genero);
            statement.setString(4, director);
            statement.setString(5, clasificacionEdad);
            statement.setDouble(6, precio);
            statement.setInt(7, id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Película actualizada correctamente.");
            } else {
                System.out.println("No se encontró ninguna película con el ID proporcionado.");
            }
        } catch (SQLException e) {
        	System.out.println("Error al actualizar pelicula");
            e.printStackTrace();
        }
    }
  //Metodo para actualizar datos de una sala ya existente en la BBDD.
    public void updateSala(int id, int capacidad, double metrosCuadrados) {
        String sql = "UPDATE Salas SET capacidad = ?, metrosCuadrados = ? WHERE id = ?";
        try (PreparedStatement statement = miConexion.prepareStatement(sql)) {
            statement.setInt(1, capacidad);
            statement.setDouble(2, metrosCuadrados);
            statement.setInt(3, id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Sala actualizada correctamente.");
            } else {
                System.out.println("No se encontró ninguna sala con el ID proporcionado.");
            }
        } catch (SQLException e) {
        	System.out.println("Error al actualizar sala");
            e.printStackTrace();
        }
    }
    	//Metodo para actualizar datos de un cine ya existente en la BBDD.
    public void updateCine(int id, String nombreCine, String direccion) {
        String sql = "UPDATE Cines SET nombreCine = ?, direccion = ? WHERE id = ?";
        try (PreparedStatement statement = miConexion.prepareStatement(sql)) {
            statement.setString(1, nombreCine);
            statement.setString(2, direccion);
            statement.setInt(3, id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cine actualizado correctamente.");
            } else {
                System.out.println("No se encontró ningún cine con el ID proporcionado.");
            }
        } catch (SQLException e) {
        	System.out.println("Error al actualizar cine");
            e.printStackTrace();
        }
    }
    	/*Metodo para listar todas las peliculas. Este metodo varia respecto a los anteriores
    	 * ya que recibe datos de la BBDD. Esto datos, como hemos visto en la unidad, se almacenan en
    	 * un objeto de la interfaz Resulset, el cual hay que recorrer para poder mostrar los datos 
    	 * en consola. Esta interfaz resulset se usará en todos los métodos que reciban datos de la BBDD.
    	 */
    public void getAllPeliculas() {
        String sql = "SELECT * FROM Peliculas";
        try (PreparedStatement statement = miConexion.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String titulo = resultSet.getString("titulo");
                int duracionMinutos = resultSet.getInt("duracionMinutos");
                String genero = resultSet.getString("genero");
                String director = resultSet.getString("director");
                String clasificacionEdad = resultSet.getString("clasificacionEdad");
                double precio = resultSet.getDouble("precio");
                System.out.println("ID: " + id + ", Título: " + titulo + ", Duración: " + duracionMinutos + " minutos, Género: " + genero + ", Director: " + director + ", Clasificación: " + clasificacionEdad + ", Precio: " + precio);
            }
        } catch (SQLException e) {
        	System.out.println("Error al listar peliculas");
            e.printStackTrace();
        }
    }
    	//Metodo para listar todas las salas
    public void getAllSalas() {
        String sql = "SELECT * FROM Salas";
        try (PreparedStatement statement = miConexion.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int capacidad = resultSet.getInt("capacidad");
                int metrosCuadrados = resultSet.getInt("metrosCuadrados");
                System.out.println("ID: " + id + ", Capacidad: " + capacidad + ", Metros cuadrados: " + metrosCuadrados);
            }
        } catch (SQLException e) {
        	System.out.println("Error al listar peliculas");
            e.printStackTrace();
        }
    }
    	//Metodo para listar todas los cines
    public void getAllCines() {
        String sql = "SELECT * FROM cines";
        try (PreparedStatement statement = miConexion.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("identificador");//estoy probando esto
                String nombreCine = resultSet.getString("nombreCine");
                String direccion = resultSet.getString("direccion");
                System.out.println("ID: " + id + ", Nombre: " + nombreCine + ", Dirección: " + direccion);
            }
        } catch (SQLException e) {
        	System.out.println("Error al listar cine");
            e.printStackTrace();
        }
    }
    	//Metodo para seleccionar una pelicula
    public void getPelicula(int id) {
        String sql = "SELECT * FROM Peliculas WHERE id = ?";
        try (PreparedStatement statement = miConexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String titulo = resultSet.getString("titulo");
                int duracionMinutos = resultSet.getInt("duracionMinutos");
                String genero = resultSet.getString("genero");
                String director = resultSet.getString("director");
                String clasificacionEdad = resultSet.getString("clasificacionEdad");
                double precio = resultSet.getDouble("precio");
                System.out.println("Pelicula encontrada:");
                System.out.println("ID: " + id + ", Título: " + titulo + ", Duración: " + duracionMinutos + " minutos, Género: " + genero + ", Director: " + director + ", Clasificación: " + clasificacionEdad + ", Precio: " + precio);
            } else {
                System.out.println("No se encontró ninguna película con el ID proporcionado.");
            }
        } catch (SQLException e) {
        	System.out.println("Error al seleccionar pelicula");
            e.printStackTrace();
        }
    }
    	//Metodo para seleccionar una sala
    public void getSala(int id) {
        String sql = "SELECT * FROM Salas WHERE id = ?";
        try (PreparedStatement statement = miConexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int capacidad = resultSet.getInt("capacidad");
                int metrosCuadrados = resultSet.getInt("metrosCuadrados");
                System.out.println("Sala encontrada:");
                System.out.println("ID: " + id + ", Capacidad: " + capacidad + ", Metros cuadrados: " + metrosCuadrados);
            } else {
                System.out.println("No se encontró ninguna sala con el ID proporcionado.");
            }
        } catch (SQLException e) {
        	System.out.println("Error al seleccionar pelicula");
            e.printStackTrace();
        }
    }
    	//Metodo para seleccionar un cine
    public void getCine(int id) {
        String sql = "SELECT * FROM Cines WHERE id = ?";
        try (PreparedStatement statement = miConexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nombreCine = resultSet.getString("nombreCine");
                String direccion = resultSet.getString("direccion");
                System.out.println("Cine encontrado:");
                System.out.println("ID: " + id + ", Nombre: " + nombreCine + ", Dirección: " + direccion);
            } else {
                System.out.println("No se encontró ningún cine con el ID proporcionado.");
            }
        } catch (SQLException e) {
        	System.out.println("Error al seleccionar cine");
            e.printStackTrace();
        }
    }
    
    	/*Metodo para comprobar si el cine existe.
    	 * Es algo que implementamos en la unidad de los Streams al comprobar si el archivo existe antes de
    	 * operar con él, así que me ha parecido buena idea hacer un metodo similar.
    	 * El metodo es booleano, así se puede utilizar como condicional en una estructura if - else
    	 */
    public boolean existeCine(int id) {
        String sql = "SELECT COUNT(*) AS count FROM Cines WHERE id = ?";
        try (PreparedStatement statement = miConexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                return count > 0; // Si count es mayor que 0, significa que el cine existe  
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Si ocurre algún error o no se encuentra ningún registro, se asume que el cine no existe.
    }

    public boolean existePelicula(int id) {
        String sql = "SELECT COUNT(*) AS count FROM Peliculas WHERE id = ?";
        try (PreparedStatement statement = miConexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                return count > 0; // Si count es mayor que 0, significa que la película existe  
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Si ocurre algún error o no se encuentra ningún registro, se asume que la película no existe.
    }

    public boolean existeSala(int id) {
        String sql = "SELECT COUNT(*) AS count FROM Salas WHERE Identificador = ?";
        try (PreparedStatement statement = miConexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                return count > 0; // Si count es mayor que 0, significa que la sala existe  
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Si ocurre algún error o no se encuentra ningún registro, se asume que la sala no existe.
    }   
    
    
}
