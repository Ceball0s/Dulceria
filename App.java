
//import dulceria_gui.Dulce;
//import dulceria_gui.Dulceria;
//import dulceria_gui.controlador;
import dulceria_gui.Controlador;
import dulceria_gui.Dulceria;
import dulceria_gui.VistaGrafica;
import dulceria_gui.VistaConsola;
import java.util.Scanner;



public class App {
    public static void main(String[] args) throws Exception {
        //ventana ventanaP = new ventana();
        //VistaConsola Vista_controlador = new VistaConsola();
        //Vista_controlador.setControlador(new Controlador(new Dulceria(), Vista_controlador));
        Scanner sc = new Scanner(System.in);
        System.out.println("Elige una opción:"); 
        System.out.println("1. Vista Grafica"); 
        System.out.println("2. Vista Consola");
        int opcion = sc.nextInt();

        if (opcion == 1) { 
            VistaGrafica vista_Grafica = new VistaGrafica();
        } else if (opcion == 2) { 
            VistaConsola vistaConsola = new VistaConsola();
        } else { // Si el usuario elige una opción inválida, mostramos un mensaje de error 
            System.out.println("Opción inválida"); 
        }

        // Cerramos el objeto Scanner sc.close(); }
    }
}
