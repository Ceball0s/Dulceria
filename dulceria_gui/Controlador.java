package dulceria_gui;

// Clase Controlador
public class Controlador {

    // Atributos para el modelo y la vista
    private Dulceria modelo;
    private Vista vista;

    // Constructor
    public Controlador(Dulceria modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setControlador(this); // Asignar el controlador a la vista
    }



    // Método para inicializar la vista
    public void iniciarVista() {
        vista.setVisible(true); // Hacer visible la ventana
        vista.actualizarLista(modelo.get_listaDulces()); // Actualizar la lista de Dulces con los datos del modelo
    }

    // Método para agregar un Dulce al modelo y a la vista
    public void agregarDulce(String nombre, String tipo) {
        modelo.agregarDulce(new Dulce(nombre,tipo)); // Llamar al método del modelo para agregar el Dulce a la lista
        vista.actualizarLista(modelo.get_listaDulces()); // Llamar al método de la vista para actualizar la lista de Dulces con los datos del modelo
        vista.mostrarMensaje("Dulce agregado con éxito."); // Mostrar un mensaje de confirmación en la vista
    }

    // Método para buscar un Dulce por su nombre en el modelo y mostrarlo en la vista
    public void buscarDulce(String nombre) {
        Dulce Dulce = modelo.buscarDulce(nombre); // Llamar al método del modelo para buscar el Dulce por su nombre
        if (Dulce != null) { // Si se encontró el Dulce
            vista.mostrarDulce(Dulce); // Llamar al método de la vista para mostrar los datos del Dulce en los campos de texto
            vista.mostrarMensaje("Dulce encontrado."); // Mostrar un mensaje de confirmación en la vista

        } else { // Si no se encontró el Dulce
            vista.mostrarMensaje("No se encontró ningún Dulce con ese nombre."); // Mostrar un mensaje de error en la vista
        }
    }

    // Método para actualizar un Dulce del modelo y de la vista
    public void actualizarDulce(String nombre_viejo,String nombre, String Tipo) {
        Dulce dulce = modelo.buscarDulce(nombre_viejo); // Llamar al método del modelo para buscar el Dulce por su nombre
        if (dulce != null) { // Si se encontró el Dulce
            Dulce Dulce_en_la_lista = (Dulce) dulce; // Hacer un casting a Dulce
            Dulce_en_la_lista.setNombre(nombre); // Actualizar el nombre del Dulce
            Dulce_en_la_lista.setCategoria(Tipo); // Actualizar la categoria
            vista.actualizarLista(modelo.get_listaDulces()); // Llamar al método de la vista para actualizar la lista de Dulces con los datos del modelo
            vista.mostrarMensaje("Dulce actualizado con éxito."); // Mostrar un mensaje de confirmación en la vista
        } else { // Si no se encontró el Dulce
            vista.mostrarMensaje("No se encontró ningún Dulce con ese nombre."); // Mostrar un mensaje de error en la vista
        }
    }
    // Método para actualizar un Dulce del modelo y de la vista
    
    // Método para mostrar los datos de un Dulce en la vista
    public void mostrarDulce(String nombre) {
        Dulce Dulce = modelo.buscarDulce(nombre); // Llamar al método del modelo para buscar el Dulce por su nombre
        vista.mostrarDulce(Dulce); // Llamar al método de la vista para mostrar los datos del Dulce en los campos de texto
    }
    // Método para eliminar un Dulce de la lista
    public boolean eliminarDulce(String nombre) {
        return modelo.eliminarDulce(nombre); // Buscar el Dulce por su nombre
    }
}
