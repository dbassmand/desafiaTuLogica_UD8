package progUD8.RetoUD8;

import java.util.Scanner;

public class MenuOpcion {
	
	private DatabaseManager dbManager;
	Scanner scanner = new Scanner(System.in);

    public MenuOpcion(DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }

    public void muestraMenu() {
    	
    	if (dbManager.verificarConexion()) {
            System.out.println("***Establecida conexión con base de datos***");
        } else {
            System.out.println("Error: No se pudo establecer la conexión con la base de datos.");
        }
    	
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenú Principal:");
            System.out.println("1. Cines");
            System.out.println("2. Películas");
            System.out.println("3. Salas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    opcionesCines();
                    break;
                case 2:
                    opcionesPeliculas();
                    break;
                case 3:
                    opcionesSalas();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }

    private void opcionesCines() {
        // Lógica para manejar la opción de Cines
        
    	
    	boolean exit = false;
        while (!exit) {
            System.out.println("\nMenú Cines:");
            System.out.println("1. Mostrar todos los cines");
            System.out.println("2. Mostrar información de un cine específico");
            System.out.println("3. Insertar un nuevo cine");
            System.out.println("4. Actualizar información de un cine existente");
            System.out.println("5. Eliminar un cine");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    dbManager.getAllCines();
                    break;
                case 2:
                	//Lógica para buscar un cine especifico por ID
                    System.out.print("Introduzca el ID del cine: ");
                    int cineId = scanner.nextInt();
                    if (dbManager.existeCine(cineId)) {
                        dbManager.getCine(cineId);
                    } else {
                        System.out.println("El cine con el ID proporcionado no existe.");
                    }
                    break;
                case 3:
                	// Lógica para insertar un nuevo cine
                	scanner.nextLine(); // Consumir el salto de línea pendiente
                	System.out.println("\nIntroduzca el nombre del cine: ");
                	String nombre = scanner.nextLine();
                	System.out.println("Introduzca la direccion del cine: ");
                	String direccion = scanner.nextLine();
                	dbManager.insertaCine(nombre, direccion);
                    break;
                case 4:
                    // Lógica para actualizar un cine existente
                	scanner.nextLine(); // Consumir el salto de línea pendiente
                	System.out.println("Introduzca el ID del cine a actualizar: ");
                	int cineId2 = scanner.nextInt();
                	if (dbManager.existeCine(cineId2)) {
                		scanner.nextLine(); // Consumir el salto de línea pendiente
                		System.out.println();
                    	System.out.println("Introduzca el nombre del cine: ");
                    	String nombre2 = scanner.nextLine();
                    	System.out.println("Introduzca la direccion del cine: ");
                    	String direccion2 = scanner.nextLine();
                    	dbManager.updateCine(cineId2, nombre2, direccion2);
                    } else {
                        System.out.println("El cine con el ID proporcionado no existe.");
                    }                                    	
                    break;
                case 5:
                    // Lógica para eliminar un cine
                	System.out.println("Introduce el ID del cine a eliminar: ");
                	int cineId3 = scanner.nextInt();
                	if (dbManager.existeCine(cineId3)) {
                		dbManager.borraCine(cineId3);
                    } else {
                        System.out.println("El cine con el ID proporcionado no existe.");
                    }                	
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }

    private void opcionesPeliculas() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenú Películas:");
            System.out.println("1. Mostrar todas las películas");
            System.out.println("2. Mostrar información de una película específica");
            System.out.println("3. Insertar una nueva película");
            System.out.println("4. Actualizar información de una película existente");
            System.out.println("5. Eliminar una película");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    dbManager.getAllPeliculas();
                    break;
                case 2:
                    System.out.print("Introduzca el ID de la película: ");
                    int peliculaId = scanner.nextInt();
                    if (dbManager.existePelicula(peliculaId)) {
                        dbManager.getPelicula(peliculaId);
                    } else {
                        System.out.println("La película con el ID proporcionado no existe.");
                    }
                    break;
                case 3:
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                    System.out.println("Introduzca el título de la película: ");
                    String titulo = scanner.nextLine();
                    System.out.println("Introduzca la duración en minutos de la película: ");
                    int duracion = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.println("Introduzca el género de la película: ");
                    String genero = scanner.nextLine();
                    System.out.println("Introduzca el nombre del director de la película: ");
                    String director = scanner.nextLine();
                    System.out.println("Introduzca la clasificación por edad de la película: ");
                    String clasificacion = scanner.nextLine();
                    System.out.println("Introduzca el precio de la película: ");
                    double precio = scanner.nextDouble();
                    dbManager.insertaPelicula(titulo, duracion, genero, director, clasificacion, precio);
                    break;
                case 4:
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                    System.out.print("Introduzca el ID de la película a actualizar: ");
                    int peliculaId2 = scanner.nextInt();
                    if (dbManager.existePelicula(peliculaId2)) {
                        scanner.nextLine(); 
                        System.out.println("Introduzca el nuevo título de la película: ");
                        String nuevoTitulo = scanner.nextLine();
                        System.out.println("Introduzca la nueva duración en minutos de la película: ");
                        int nuevaDuracion = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.println("Introduzca el nuevo género de la película: ");
                        String nuevoGenero = scanner.nextLine();
                        System.out.println("Introduzca el nuevo nombre del director de la película: ");
                        String nuevoDirector = scanner.nextLine();
                        System.out.println("Introduzca la nueva clasificación por edad de la película: ");
                        String nuevaClasificacion = scanner.nextLine();
                        System.out.println("Introduzca el nuevo precio de la película: ");
                        double nuevoPrecio = scanner.nextDouble();
                        dbManager.updatePelicula(peliculaId2, nuevoTitulo, nuevaDuracion, nuevoGenero, nuevoDirector, nuevaClasificacion, nuevoPrecio);
                    } else {
                        System.out.println("La película con el ID proporcionado no existe.");
                    }
                    break;
                case 5:
                    System.out.print("Introduzca el ID de la película a eliminar: ");
                    int peliculaId3 = scanner.nextInt();
                    if (dbManager.existePelicula(peliculaId3)) {
                        dbManager.borraPelicula(peliculaId3);
                    } else {
                        System.out.println("La película con el ID proporcionado no existe.");
                    }
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }

    private void opcionesSalas() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenú Salas:");
            System.out.println("1. Mostrar todas las salas");
            System.out.println("2. Mostrar información de una sala específica");
            System.out.println("3. Insertar una nueva sala");
            System.out.println("4. Actualizar información de una sala existente");
            System.out.println("5. Eliminar una sala");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    dbManager.getAllSalas();
                    break;
                case 2:
                    System.out.print("Introduzca el ID de la sala: ");
                    int salaId = scanner.nextInt();
                    if (dbManager.existeSala(salaId)) {
                        dbManager.getSala(salaId);
                    } else {
                        System.out.println("La sala con el ID proporcionado no existe.");
                    }
                    break;
                case 3:
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                    System.out.println("Introduzca la capacidad de la sala: ");
                    int capacidad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Introduzca los metros cuadrados de la sala: ");
                    String metrosCuadrados = scanner.nextLine();
                    dbManager.insertaSala(capacidad, metrosCuadrados);
                    break;
                case 4:
                    System.out.print("Introduzca el ID de la sala a actualizar: ");
                    int salaId2 = scanner.nextInt();
                    if (dbManager.existeSala(salaId2)) {
                        System.out.println("Introduzca la nueva capacidad de la sala: ");
                        int nuevaCapacidad = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Introduzca los nuevos metros cuadrados de la sala: ");
                        String nuevosMetrosCuadrados = scanner.nextLine(); 
                        dbManager.updateSala(salaId2, nuevaCapacidad, nuevosMetrosCuadrados);
                    } else {
                        System.out.println("La sala con el ID proporcionado no existe.");
                    }
                    break;
                case 5:
                    System.out.print("Introduzca el ID de la sala a eliminar: ");
                    int salaId3 = scanner.nextInt();
                    if (dbManager.existeSala(salaId3)) {
                        dbManager.borraSala(salaId3);
                    } else {
                        System.out.println("La sala con el ID proporcionado no existe.");
                    }
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}
