package dulceria_gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList; 
import javax.swing.DefaultListModel;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ListCellRenderer;



import java.util.ArrayList;

public class VistaGrafica extends Vista{
    private JList<Dulce> listaDulces;
    private DefaultListModel<Dulce> modelo; 
    public JPanel panelBprincipales;
    public JPanel panelBotones;

    public JPanel Panel_crearDulce;
    public JPanel panel_lista_Dulce;

    // Atributos para los elementos gráficos
    private JTextField txtNombre;
    private JTextField txtTipo;

    private JFrame frame;

    //CrearMesas manejoM = new CrearMesas();

    JButton boton_crearGato = new JButton();
    JButton botonVend = new JButton();
    JButton usuarios  = new JButton();
    JButton boton_crearPerro = new JButton();

    // Atributo para el controlador
    private Controlador controlador;



    public VistaGrafica(){  //Creamos el constructor y dentro de este creamos el JFrame
        frame = new JFrame(); // Crear el objeto JFrame
        
        
        // Inicializar los demás componentes gráficos del frame
        frame.setTitle("Dulcería");
        frame.setSize(700, 450);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);  


        frame.setVisible(true); //Hacemos visible la ventana
        iniciarComponentes();

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        // Crear una instancia del controlador y pasarle el modelo y la vista
        controlador = new Controlador(new Dulceria(), this);

        // Llamar al método del controlador para inicializar la vista
        controlador.iniciarVista();
    }    

//============================================================================
    private void iniciarComponentes(){
        listaDulces = new JList<>(new DefaultListModel<>());
        modelo = (DefaultListModel<Dulce>) listaDulces.getModel(); // Asigna el modelo al atributo de la clase
        iniciarPaneles();
        iniciarBotones();
        //crearPanelPerro();
        Panel_crearDulce();
        crearPanelLista();
    }
//============================================================================
    // Método para iniciar los paneles
    private void iniciarPaneles(){
        panelBprincipales = new JPanel();
        panelBprincipales.setLayout(null);//desactivamos el layout por defecto que esta centrado
        panelBprincipales.setBackground(Color.WHITE);
        // establecemos el color del panel
        panelBprincipales.setSize(300, 600);
        frame.getContentPane().add(panelBprincipales);//agregamos el panel al frame

        //panel donde se agregan los botones principales
        panelBotones = new JPanel();
        panelBotones.setLayout(null);
        panelBotones.setSize(150, 600);
        panelBotones.setBackground(new Color(30, 136, 229));

        panelBprincipales.add(panelBotones);
    
    }

    // Método para iniciar los botones
    private void iniciarBotones(){
        boton_crearPerro.setText("Crear Dulces");
        boton_crearPerro.setBounds(20, 20, 100, 30);
        boton_crearPerro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            //llamamos el metodo que creamos para el panel
                mostrar_crear_dulces();
            }
        });
        panelBotones.add(boton_crearPerro);

    
        
        botonVend.setText("Lista Dulcees");
        botonVend.setBounds(20, 100, 100, 30);
        botonVend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MostrarLista();
            }
        });
        panelBotones.add(botonVend);

        
        
        usuarios .setText("Proximamente 2");
        usuarios .setBounds(20, 140, 100, 30);
        //panelBotones.add(usuarios);

        
    //creamos el boton cerrar y configuramos su funcionamiento
        JButton botonCe = new JButton();
        botonCe.setText("Cerrar");
        botonCe.setBounds(20, 180, 100, 30);

    
        botonCe.addActionListener(new ActionListener() {  //agregamos el addAcionlistener al boton para que al precionarlo funcione

            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(frame, "desea salir de la APP", "SALIR", JOptionPane.YES_NO_OPTION); // Usar el frame como componente padre
                if(respuesta == JOptionPane.YES_OPTION){ //creamos el bucle que se encarga de evaluar la desicion de usiario
                    System.exit(0);
                }
                
            }
            
        });

        panelBotones.add(botonCe);

    }


//============================================================================


    public void Panel_crearDulce() {
        // Crear un panel
        Panel_crearDulce = new JPanel();

        // Crear los componentes del panel
        JLabel titulo = new JLabel("Agregar Gato");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        JLabel nombreLabel = new JLabel("Nombre:");
        JTextField nombreField = new JTextField(10);
        JLabel TipoLabel = new JLabel("Tipo:");


        // Crear el array con las opciones
        String[] opciones = {"Dulce", "Acido", "Sin azucar"};


        // Crear el objeto JComboBox y pasarle el array de opciones
        JComboBox<String> caja = new JComboBox<String>(opciones);
        caja.setBounds(50, 50, 100, 30); // Establecer la posición y el tamaño

        // Agregar un ActionListener al botón para mostrar el valor seleccionado

        // Agregar los componentes al JFrame
        JButton crearButton = new JButton("Crear");

        // Agregar un listener al botón crear
        crearButton.addActionListener(e -> {
            // Obtener los datos del panel
            String nombre = nombreField.getText();
            String Tipo =  (String) caja.getSelectedItem();

            // Llamar al método del controlador para agregar un gato al modelo y a la vista
            controlador.agregarDulce(nombre,Tipo);

            // Limpiar los campos del panel
            nombreField.setText("");
            caja.setSelectedIndex(-1);

        });

        // Agregar los componentes al panel
        Panel_crearDulce.add(titulo);
        Panel_crearDulce.add(new JLabel(""));
        Panel_crearDulce.add(nombreLabel);
        Panel_crearDulce.add(nombreField);
        Panel_crearDulce.add(TipoLabel);
        Panel_crearDulce.add(caja);

        Panel_crearDulce.add(new JLabel(""));
        Panel_crearDulce.add(crearButton);

        // Establecer el tamaño y el layout del panel
        Panel_crearDulce.setLayout(new GridLayout(7, 1));
        Panel_crearDulce.setBackground(Color.WHITE);
        Panel_crearDulce.setSize(300, 300);
        Panel_crearDulce.setVisible(true);
        Panel_crearDulce.setBounds(200, 0, 300, 300);

        panelBprincipales.add(Panel_crearDulce);

    }

    public void crearPanelLista() {
        // Inicializar el JList con un modelo de lista que contenga los Dulcees
        //listaDulces = new JList<>(new DefaultListModel<>());
        // Agregar un renderizador personalizado al JList para que muestre el nombre y el tipo de Dulce
        listaDulces.setCellRenderer(new DulceRenderer());

        // Crear un botón de modificar
        JButton botonModificar = new JButton("Modificar");

        // Agregar un escuchador de eventos al botón para que se ejecute una acción cuando se haga clic en él
        botonModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el objeto seleccionado en el JList y verificar que no sea nulo
                Dulce dulce = listaDulces.getSelectedValue();
                if (dulce != null) {
                    // Crear una ventana emergente con campos de texto para ingresar los nuevos datos del objeto
                    JTextField nombreField = new JTextField(dulce.getNombre());
                    // Crear el array con las opciones
                    String[] opciones = {"Dulce", "Acido", "Sin azucar"};
                    // Crear el objeto JComboBox y pasarle el array de opciones
                    int indice = -1;
                    if (dulce.getCategoria() == "Dulce"){
                        indice = 0;
                    }else if (dulce.getCategoria() == "Acido") {
                        indice = 1;
                    } else {
                        indice = 2;
                    }
                    JComboBox<String> caja = new JComboBox<String>(opciones);
                    caja.setBounds(50, 50, 100, 30); // Establecer la posición y el tamaño
                    caja.setSelectedIndex(indice);
                    Object[] campos = {
                            "Nombre:", nombreField,
                            "tipo:", caja
                    };
                    int opcion = JOptionPane.showConfirmDialog(null, campos, "Modificar Dulce", JOptionPane.OK_CANCEL_OPTION);
                    // Si se presiona el botón OK, asignar los nuevos datos al objeto y actualizar el modelo de la lista
                    if (opcion == JOptionPane.OK_OPTION) {
                        controlador.actualizarDulce(dulce.getNombre(),nombreField.getText(),(String) caja.getSelectedItem());
                    }
                
                }
            }
        });

        // Crear un botón con un texto que indique la acción de eliminar
        JButton botonEliminar = new JButton("Eliminar");

        // Agregar un escuchador de eventos al botón para que se ejecute una acción cuando se haga clic en él
        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el objeto seleccionado en el JList y verificar que no sea nulo
                Dulce Dulce = listaDulces.getSelectedValue();
                if (Dulce != null) {
                    // Llamar al método del controlador para eliminar el Dulce del modelo y de la vista
                    controlador.eliminarDulce(Dulce.getNombre());
                }
            }
        });

        // Crear una caja de texto con un texto vacío
        JTextField campoBuscar = new JTextField();
        campoBuscar.setSize(100, 300);
        campoBuscar.setPreferredSize(new Dimension(80, 50));
        // Crear un botón con un texto que indique la acción de buscar
        JButton botonBuscar = new JButton("Buscar");
        botonBuscar.setPreferredSize(new Dimension(80, 50));
        // Agregar un escuchador de eventos al botón para que se ejecute una acción cuando se haga clic en él
        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el texto de la caja de texto y verificar que no sea vacío
                String nombre = campoBuscar.getText();
                if (!nombre.isEmpty()) {
                    // Llamar al método del controlador para buscar el Dulce por su nombre y seleccionarlo en la lista
                    controlador.buscarDulce(nombre);
                }
            }
        });
        
        
        // Agregar la caja de texto y el botón al panel
        // Crear un GridLayout con dos filas y una columna




        // Crear un panel principal y agregar el JList al panel
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new FlowLayout());
        panelPrincipal.setSize(100, 100);
        panelPrincipal.setVisible(true);
        
        panelPrincipal.add(campoBuscar);
        panelPrincipal.add(botonBuscar);

        JPanel panel_eliminar_modificar = new JPanel();
        panel_eliminar_modificar.setLayout(new BorderLayout());
        // Agregar el panel al GridLayout
        // Agregar el panel secundario y la lista al panel principal
        
        panel_eliminar_modificar.add(botonEliminar,BorderLayout.WEST);
        panel_eliminar_modificar.add(botonModificar,BorderLayout.EAST);

        
        panel_lista_Dulce = new JPanel(); // Asignarle un objeto JPanel a la variable
        panel_lista_Dulce.setLayout(new BorderLayout());

        // Configurar el tamaño y la ubicación del panel
        panel_lista_Dulce.setSize(450, 400);
        //panel_lista_Dulce.setPreferredSize(new Dimension(500, 500));
        panel_lista_Dulce.setBounds(200, 0, 450, 400);
        panel_lista_Dulce.setVisible(false);
        // Agregar el panel al JFrame y hacerlo visible
        
        panel_lista_Dulce.add(panelPrincipal,BorderLayout.NORTH);
        panel_lista_Dulce.add(listaDulces,BorderLayout.CENTER);
        panel_lista_Dulce.add(panel_eliminar_modificar,BorderLayout.SOUTH);

        panelBprincipales.add(panel_lista_Dulce);  
    }

    private class DulceRenderer implements ListCellRenderer<Dulce> {

        @Override
        public Component getListCellRendererComponent(JList<? extends Dulce> list, Dulce value, int index,boolean isSelected, boolean cellHasFocus) {
            // Crear un JLabel con el nombre y el tipo de Dulce
            JLabel label = new JLabel(value.getNombre() + " (" + value.getClass().getSimpleName() + ")");
            label.setOpaque(true);

            // Cambiar el color del fondo y del texto según si el elemento está seleccionado o no
            if (isSelected) {
                label.setBackground(list.getSelectionBackground());
                label.setForeground(list.getSelectionForeground());
            } else {
                label.setBackground(list.getBackground());
                label.setForeground(list.getForeground());
            }

            return label;
        }
    }

    // Método para asignar el controlador a la vista
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    // Método para mostrar un mensaje en una ventana emergente
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(frame, mensaje); // Usar el frame como componente padre
    }


    // Método para mostrar los datos de un Dulce en los campos de texto
    public void mostrarDulce(Dulce dulce) {
        if (dulce != null) { // Si el Dulce existe
            Object[] campos = {
                    "Nombre:", dulce.getNombre(),
                    "tipo:", dulce.getCategoria()
            };
            int opcion = JOptionPane.showConfirmDialog(null, campos, "Modificar Dulce", JOptionPane.OK_CANCEL_OPTION);
            // Si se presiona el botón OK, asignar los nuevos datos al objeto y actualizar el modelo de la lista
        } else { // Si el Dulce no existe
            mostrarMensaje("No se encontró el Dulce");
        }
    }

    // Método para limpiar los campos de texto
    public void limpiarCampos() {
        txtNombre.setText("");
        txtTipo.setText("");
    }


    public void actualizarLista(ArrayList<Dulce> lista) {
        modelo.clear(); // Limpiar el modelo de la lista
        for (Dulce Dulce : lista) { // Recorrer la lista de Dulcees del modelo
            modelo.addElement(Dulce); // Agregar cada Dulce al modelo de la lista
        }
        listaDulces.repaint(); // Repintar la lista para mostrar los cambios
    }
     private void apagarTodo(){
        Panel_crearDulce.setVisible(false);

        panel_lista_Dulce.setVisible(false);
    }

    // Método para mostrar el panel para crear dulces
    private void mostrar_crear_dulces(){
        apagarTodo();
        Panel_crearDulce.setVisible(true);
        frame.revalidate(); // Usar el frame para revalidar
        frame.repaint(); // Usar el frame para repintar
    }

    // Método para mostrar el panel con la lista de dulces
    private void MostrarLista(){
        apagarTodo();
        panel_lista_Dulce.setVisible(true);
        frame.revalidate(); // Usar el frame para revalidar
        frame.repaint(); // Usar el frame para repintar
    }
    
    // Método para hacer visible la ventana
    @Override
    public void setVisible(boolean visible) {
        frame.setVisible(visible); // Llamar al método setVisible del frame
    }
}

