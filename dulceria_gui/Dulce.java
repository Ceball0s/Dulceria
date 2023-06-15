package dulceria_gui;

public class Dulce {
  // Atributos de la clase Dulce
  private String nombre; // El nombre del dulce
  private String categoria; // La categoría del dulce (dulce, ácido, sin azúcar)

  // Constructor de la clase Dulce
  public Dulce(String nombre, String categoria) {
    this.nombre = nombre; // Asigna el nombre al atributo nombre
    this.categoria = categoria; // Asigna la categoría al atributo categoria
  }

  // Métodos setter y getter de la clase Dulce

  // Método setter para asignar el nombre al dulce
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  // Método getter para obtener el nombre del dulce
  public String getNombre() {
    return this.nombre;
  }

  // Método setter para asignar la categoría al dulce
  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  // Método getter para obtener la categoría del dulce
  public String getCategoria() {
    return this.categoria;
  }
}
