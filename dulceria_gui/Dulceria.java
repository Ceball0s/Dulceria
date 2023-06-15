package dulceria_gui;

import java.util.ArrayList; // Importar la clase ArrayList para manejar listas dinámicas


public class Dulceria {

   // Atributo para almacenar los Dulcees en una lista
   private ArrayList<Dulce> listaDulces;

   // Constructor
   public Dulceria() {
       listaDulces = new ArrayList<>(); // Inicializar la lista vacía
   }

   // Método para agregar un Dulce a la lista
   public boolean agregarDulce(Dulce Dulce) {
        Dulce dulce_dulce_no_repetido = buscarDulce(Dulce.getNombre()); // Buscar el Dulce por su nombre
        if (dulce_dulce_no_repetido != null) { // Si se encontró el Dulce
            return false;//no se agrego el Dulce
        } else { // Si no se encontró el Dulce
            listaDulces.add(Dulce); // Añadir el Dulce al final de la lista
            return true;
        }
       
   }
    
    // Método para buscar un Dulce por su nombre en la lista
    public Dulce buscarDulce(String nombre) {
       for (Dulce dulce : listaDulces) { // Recorrer la lista usando un bucle for-each
           if (dulce.getNombre().equals(nombre)) { // Comparar el nombre del Dulce con el buscado
               return dulce;
            }
        }
        return null; // Si no se encuentra el Dulce, devolver null
    }

    // Método para actualizar un Dulce de la lista
    public void actualizarDulce(String nombre, Dulce dulce_nuevo) {
        Dulce dulce = buscarDulce(nombre); // Buscar el Dulce por su nombre
        Dulce DulceViejo = (Dulce) dulce; // Hacer un casting a Perro
        DulceViejo = dulce_nuevo;
    }

    // Método para eliminar un Dulce de la lista
    public boolean eliminarDulce(String nombre) {
        Dulce dulce = buscarDulce(nombre); // Buscar el Dulce por su nombre
        if (dulce != null) { // Si se encontró el Dulce
            listaDulces.remove(dulce); // Eliminar el Dulce de la lista
            return true;
        } else { // Si no se encontró el Dulce
            return false;
        }
    }
 

    public ArrayList<Dulce> get_listaDulces(){
        return listaDulces;
    }

    
}
