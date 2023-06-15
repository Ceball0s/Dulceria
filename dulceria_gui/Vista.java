package dulceria_gui;
import java.util.ArrayList;
public abstract class Vista {

    // Atributo para el controlador
    protected Controlador controlador;

    // Método para asignar el controlador a la vista
    public void setControlador(Controlador controlador) {
        this.controlador = controlador; // Asignar el controlador a la vista
    }

    // Método abstracto para hacer visible la ventana
    public abstract void setVisible(boolean visible);


    // Método abstracto para actualizar la lista de Dulces con los datos del modelo
    public abstract void actualizarLista(ArrayList<Dulce> listaDulces);

    // Método abstracto para mostrar los datos de un Dulce en los campos de texto
    public abstract void mostrarDulce(Dulce dulce);

    // Método abstracto para mostrar un mensaje en la consola o en la ventana
    public abstract void mostrarMensaje(String mensaje);
}
