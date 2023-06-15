package dulceria_gui;
import java.util.Scanner; // Importar la clase Scanner para leer datos desde la consola
import java.util.ArrayList;


public class VistaConsola extends Vista{

    // Atributos para el controlador y el scanner
    private Controlador controlador;
    private Scanner scanner;

    // Constructor
    public VistaConsola() {
        scanner = new Scanner(System.in); // Crear el objeto scanner
        controlador = new Controlador(new Dulceria(), this);
        mostrarMenu();
    }

    // Método para hacer visible la ventana (en este caso, la consola)
    public void setVisible(boolean visible) {
        if (visible) { // Si se quiere hacer visible la consola
            mostrarMenu(); // Llamar al método para mostrar el menú de opciones
        } else { // Si se quiere ocultar la consola
            System.exit(0); // Terminar el programa
        }
    }

    // Método para mostrar el menú de opciones
    public void mostrarMenu() {
        System.out.println("Bienvenido a la dulcería");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Agregar un dulce");
        System.out.println("2. Buscar un dulce");
        System.out.println("3. Actualizar un dulce");
        System.out.println("4. Eliminar un dulce");
        System.out.println("5. Salir");
        int opcion = scanner.nextInt(); // Leer la opción elegida por el usuario
        scanner.nextLine(); // Limpiar el buffer del scanner
        ejecutarOpcion(opcion); // Llamar al método para ejecutar la opción elegida
    }

    // Método para ejecutar la opción elegida por el usuario
    public void ejecutarOpcion(int opcion) {
        switch (opcion) { // Según la opción elegida
            case 1: // Si es agregar un dulce
                agregarDulce(); // Llamar al método para agregar un dulce
                break;
            case 2: // Si es buscar un dulce
                buscarDulce(); // Llamar al método para buscar un dulce
                break;
            case 3: // Si es actualizar un dulce
                actualizarDulce(); // Llamar al método para actualizar un dulce
                break;
            case 4: // Si es eliminar un dulce
                eliminarDulce(); // Llamar al método para eliminar un dulce
                break;
            case 5: // Si es salir
                setVisible(false); // Hacer invisible la consola
                break;
            default: // Si es una opción inválida
                mostrarMensaje("Opción inválida. Intente de nuevo."); // Mostrar un mensaje de error
                mostrarMenu(); // Mostrar de nuevo el menú de opciones
                break;
        }
    }

    // Método para agregar un dulce
    public void agregarDulce() {
        System.out.println("Ingrese el nombre del dulce:");
        String nombre = scanner.nextLine(); // Leer el nombre del dulce desde la consola
        System.out.println("Ingrese el tipo del dulce:");
        String tipo = scanner.nextLine(); // Leer el tipo del dulce desde la consola
        controlador.agregarDulce(nombre, tipo); // Llamar al método del controlador para agregar el dulce al modelo y a la vista
        mostrarMenu(); // Mostrar de nuevo el menú de opciones
    }

    // Método para buscar un dulce
    public void buscarDulce() {
        System.out.println("Ingrese el nombre del dulce a buscar:");
        String nombre = scanner.nextLine(); // Leer el nombre del dulce a buscar desde la consola
        controlador.buscarDulce(nombre); // Llamar al método del controlador para buscar el dulce por su nombre en el modelo y mostrarlo en la vista
        mostrarMenu(); // Mostrar de nuevo el menú de opciones

    }

    // Método para actualizar un dulce

    public void actualizarDulce() {
        System.out.println("Ingrese el nombre del dulce a actualizar:"); 
        String nombre_viejo = scanner.nextLine(); // Leer el nombre del dulce a actualizar desde la consola 
        System.out.println("Ingrese el nuevo nombre del dulce:"); 
        String nombre = scanner.nextLine(); // Leer el nuevo nombre del dulce desde la consola 
        System.out.println("Ingrese el nuevo tipo del dulce:"); 
        String tipo = scanner.nextLine(); // Leer el nuevo tipo del dulce desde la consola 
        controlador.actualizarDulce(nombre_viejo, nombre, tipo); // Llamar al método del controlador para actualizar el dulce en el modelo y en la vista 
        mostrarMenu(); // Mostrar de nuevo el menú de opciones 
    }

    // Método para eliminar un dulce 
    public void eliminarDulce() { 
        System.out.println("Ingrese el nombre del dulce a eliminar:"); 
        String nombre = scanner.nextLine(); // Leer el nombre del dulce a eliminar desde la consola 
        boolean eliminado = controlador.eliminarDulce(nombre); // Llamar al método del controlador para eliminar el dulce de la lista 
        if (eliminado) { // Si se eliminó el dulce 
            mostrarMensaje("Dulce eliminado con éxito."); // Mostrar un mensaje de confirmación 
        } else { // Si no se eliminó el dulce 
            mostrarMensaje("No se encontró ningún dulce con ese nombre."); // Mostrar un mensaje de error 
        } mostrarMenu(); // Mostrar de nuevo el menú de opciones 
    }

    // Método para actualizar la lista de Dulces con los datos del modelo 
    public void actualizarLista(ArrayList<Dulce> listaDulces) { 
        System.out.println("Lista de Dulces:"); 
        for (Dulce Dulce : listaDulces) { // Recorrer la lista de Dulces 
           mostrarDulce(Dulce);
        } 
    }

    // Método para mostrar los datos de un Dulce en los campos de texto 
    public void mostrarDulce(Dulce Dulce) { 
        System.out.println("Datos del Dulce:"); 
        System.out.println("Nombre: " + Dulce.getNombre()); // Mostrar el nombre del Dulce 
        System.out.println("Tipo: " + Dulce.getCategoria()); // Mostrar el tipo del Dulce

    }

    // Método para mostrar un mensaje en la consola public 
    public void mostrarMensaje(String mensaje) { 
        System.out.println(mensaje); // Mostrar el mensaje en la consola 
    } 
}