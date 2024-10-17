import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaEcommerce {
    private ArrayList<Producto> productos;
    private GestorCategorias gestorCategorias;

    public SistemaEcommerce() {
        productos = new ArrayList<>();
        gestorCategorias = new GestorCategorias();
    }

    // Métodos para productos
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void listarProductos() {
        for (Producto p : productos) {
            System.out.println(p);
        }
    }

    public void eliminarProducto(int id) {
        productos.removeIf(p -> p.getId() == id);
    }

    // Métodos para categorías
    public void agregarCategoria(Categoria categoria) {
        gestorCategorias.agregarCategoria(categoria);
    }

    public void listarCategorias() {
        gestorCategorias.listarCategorias();
    }

    public void eliminarCategoria(int id) {
        gestorCategorias.eliminarCategoria(id);
    }

    // Método para ejecutar el menú
    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Gestión de productos");
            System.out.println("2. Gestión de categorías");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarMenuProductos(scanner);
                    break;
                case 2:
                    mostrarMenuCategorias(scanner);
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 3);
    }

    // Menú para gestionar productos
    private void mostrarMenuProductos(Scanner scanner) {
        int opcionProducto = 0;
    
        do {
            System.out.println("\n--- GESTIÓN DE PRODUCTOS ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcionProducto = scanner.nextInt();
    
            switch (opcionProducto) {
                case 1:
                    agregarProductoDesdeMenu(scanner);
                    break;
                case 2:
                    listarProductos();
                    break;
                case 3:
                    eliminarProductoDesdeMenu(scanner);  // CORRECCIÓN AQUÍ
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcionProducto != 4);
    }

    // Métodos para interactuar con productos en el menú
    private void agregarProductoDesdeMenu(Scanner scanner) {
        try {
            System.out.println("Ingrese el ID del producto:");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente
    
            System.out.println("Ingrese el nombre del producto:");
            String nombre = scanner.nextLine();  // Usa nextLine para capturar nombres con espacios
            
            // Aquí manejamos posibles errores de entrada para el precio
            double precio = 0.0;
            boolean precioValido = false;
            while (!precioValido) {
                try {
                    System.out.println("Ingrese el precio del producto:");
                    precio = scanner.nextDouble();
                    precioValido = true;  // Si se ingresa un número válido
                } catch (InputMismatchException e) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número decimal para el precio.");
                    scanner.next(); // Limpiar la entrada incorrecta
                }
            }
            System.out.println("Ingrese el stock del producto:");
            int stock = scanner.nextInt();
    
            Producto producto = new Producto(id, nombre, precio, stock);
            agregarProducto(producto);
            System.out.println("Producto agregado con éxito.");
            
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Intente de nuevo.");
            scanner.next();
        }
    }
    
    
    private void eliminarProductoDesdeMenu(Scanner scanner) {
        System.out.println("Ingrese el ID del producto a eliminar:");
        int id = scanner.nextInt();
        eliminarProducto(id);
        System.out.println("Producto eliminado con éxito.");
    }


    // Menú para gestionar categorías
    private void mostrarMenuCategorias(Scanner scanner) {
        int opcionCategoria = 0;

        do {
            System.out.println("\n--- GESTIÓN DE CATEGORÍAS ---");
            System.out.println("1. Agregar categoría");
            System.out.println("2. Listar categorías");
            System.out.println("3. Eliminar categoría");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcionCategoria = scanner.nextInt();

            switch (opcionCategoria) {
                case 1:
                    agregarCategoriaDesdeMenu(scanner);
                    break;
                case 2:
                    listarCategorias();
                    break;
                case 3:
                    eliminarCategoriaDesdeMenu(scanner);
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcionCategoria != 4);
    }

    // Métodos para interactuar con categorías en el menú
    private void agregarCategoriaDesdeMenu(Scanner scanner) {
        System.out.println("Ingrese el ID de la categoría:");
        int id = scanner.nextInt();
        System.out.println("Ingrese el nombre de la categoría:");
        String nombre = scanner.next();

        Categoria categoria = new Categoria(id, nombre);
        agregarCategoria(categoria);
        System.out.println("Categoría agregada con éxito.");
    }

    private void eliminarCategoriaDesdeMenu(Scanner scanner) {
        System.out.println("Ingrese el ID de la categoría a eliminar:");
        int id = scanner.nextInt();
        eliminarCategoria(id);
        System.out.println("Categoría eliminada con éxito.");
    }
}
