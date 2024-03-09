
package Panel.administrador;

import Models.Doctor;
import Models.Frecuencia;
import Models.Paciente;
import Models.Producto;
import controller.Panel_Controller;
import controller.Persona_Controller;
import controller.Productos_Controller;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Panel_Reportes extends javax.swing.JPanel{
    
    private javax.swing.JButton btn_Doctores;
    private javax.swing.JButton btn_Pacientes;
    private javax.swing.JButton btn_Productos;
    private DefaultTableModel model = new DefaultTableModel();
    public javax.swing.JTable tbl_Base;
    private javax.swing.JScrollPane jScrollPane1;
    private ArrayList<Doctor> lista_Doctores = new ArrayList<Doctor>();
    private ArrayList<Paciente> lista_Pacientes = new ArrayList<Paciente>();
    private ArrayList<Producto> lista_Productos = new ArrayList<Producto>();
    private Persona_Controller persona_Controller = new Persona_Controller();
    private Productos_Controller productos_Controller = new Productos_Controller();
    private ArrayList<Frecuencia> lista_Frecuencias = new ArrayList<Frecuencia>();
    private ChartPanel panel;
    
    public Panel_Reportes(){
        initComponents();
    }
    
    
    private void initComponents(){
        
        setLayout(null);
        lista_Doctores = persona_Controller.get_Lista_Doctores();
        lista_Productos = productos_Controller.get_Lista_Productos();
        lista_Pacientes = persona_Controller.get_Lista_Pacietes();
        btn_Doctores = new javax.swing.JButton();
        btn_Pacientes = new javax.swing.JButton();
        btn_Productos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Base = new javax.swing.JTable();
        
        panel = new ChartPanel(null);
        panel.setMouseWheelEnabled(true);
        panel.setBounds(25, 175, 650, 250);
        this.add(panel);
        
        btn_Doctores.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Doctores.setForeground(new java.awt.Color(0, 0, 0));
        btn_Doctores.setText("Doctores");
        btn_Doctores.setBounds(50, 25, 150, 30);
        btn_Doctores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DoctoresActionPerformed(evt);
            }
        });
        
        this.add(btn_Doctores);
        
        btn_Pacientes.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Pacientes.setForeground(new java.awt.Color(0, 0, 0));
        btn_Pacientes.setText("Pacientes");
        btn_Pacientes.setBounds(220, 25, 150, 30);
        btn_Pacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PacientesActionPerformed(evt);
            }
        });
        this.add(btn_Pacientes);
        
        btn_Productos.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Productos.setForeground(new java.awt.Color(0, 0, 0));
        btn_Productos.setText("Productos");
        btn_Productos.setBounds(390, 25, 150, 30);
        btn_Productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ProductosActionPerformed(evt);
            }
        });
        this.add(btn_Productos);
        
        // Configurar la tabla
        tbl_Base.setModel(model);
        tbl_Base.setEnabled(false);
        jScrollPane1.setViewportView(tbl_Base);
        
        int x = 25;
        int y = 70;
        int width = 650;
        int height = 100;
        
        // Establecer la posición y tamaño del JScrollPane
        jScrollPane1.setBounds(x, y, width, height);

        // Añadir el JScrollPane al panel
        add(jScrollPane1);
        
        setBackground(new java.awt.Color(171,255,213));
    }
    
    private void btn_DoctoresActionPerformed(java.awt.event.ActionEvent evt) {
        // Generar estructura de tabla para doctores
        model.setRowCount(0);
        generarEstructuraDoctores();
        // Cargar datos de la lista de doctores en la tabla
        cargarDatosDoctores();
        generar_Grafica_Doctores();
        cambiar_Visibilidad(true);
    }
    
    private void btn_ProductosActionPerformed(java.awt.event.ActionEvent evt) {
        model.setRowCount(0);
        generarEstructuraProductos();
        //Cargar datos de la lista de products en la tabla
        cargarDatosProductos();
        generar_Grafica_Producos();
        cambiar_Visibilidad(true);
    }
    
    
    private void generar_Grafica_Producos(){
        ArrayList<Producto> lista_Productos = productos_Controller.get_Lista_Productos_Ordenados();
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        for(int i = 0; i < 3; i++){
            Producto producto = lista_Productos.get(i);
            datos.setValue(producto.getCantidad(), "Top Produdctos", producto.getNombre());
        }
        
        JFreeChart grafico_Barras = ChartFactory.createBarChart3D(
            "Top 3 Productos",
            "Productos",
            "Cantidad",
            datos,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );
        panel.setChart(grafico_Barras);
    }
    
    private void generar_Grafica_Doctores(){
        if(lista_Frecuencias.size() == 0){
            Persona_Controller persona_Controller = new Persona_Controller();
            lista_Frecuencias = persona_Controller.registrarFrecuenciaEspecialidad();
        }
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        for(int i = 0; i < 5; i++){
            Frecuencia frecuencia = lista_Frecuencias.get(i);
            datos.setValue(frecuencia.getFrecuencia(),"Top Especialidad",frecuencia.getDato());
        }
        
        JFreeChart grafico_Barras = ChartFactory.createBarChart3D(
                "Top 5 Especialidades", //Nombre del grafico
                "Especialidades", //Nombre de las barras o columnas
                "Frecuencia", // Nombre de la numeracion
                datos, // Datos que tendra el grafico
                PlotOrientation.VERTICAL, //Orientacion del grafico
                true,
                true,
                false
        );
        panel.setChart(grafico_Barras);
    }
    
    private void generarEstructuraDoctores() {
        model.setColumnIdentifiers(new Object[]{"Código", "Nombre Completo", "Género", "Edad", "Especialidad", "Teléfono"});
        tbl_Base.setModel(model);
    }

    private void cargarDatosDoctores() {
        // Aquí se cargan los datos de la lista de doctores en la tabla
        // Recorre la lista de doctores y agrega cada doctor como una fila en la tabla
        
        for (Doctor doctor : lista_Doctores) {
            model.addRow(new Object[]{doctor.getid(), doctor.getNombre()+ " " +doctor.getApellido(),
                doctor.getSexo(), doctor.getEdad(), doctor.getEspecialidad(), doctor.getTelefono()});
        }
    }
    
    private void cambiar_Visibilidad(boolean dato){
        panel.setVisible(dato);
    }

    private void generarEstructuraProductos() {
        model.setColumnIdentifiers(new Object[]{"Código", "Nombre", "Cantidad", "Descripción", "Precio"});
        tbl_Base.setModel(model);
    }

    private void cargarDatosProductos() {
        // Aquí se cargan los datos de la lista de productos en la tabla
        // Similar al método cargarDatosDoctores, pero para la lista de productos
        
        for( Producto producto: lista_Productos ){
            model.addRow(new Object[]{producto.getId_Producto(), producto.getNombre(),
                producto.getCantidad(), producto.getDescripcion(), producto.getPrecio()});
        }
    }
    
    private void btn_PacientesActionPerformed(java.awt.event.ActionEvent evt){
        // Generar estructura de tabla para doctores
        model.setRowCount(0);
        generar_Estructura_Pacientes();
        // Cargar datos de la lista de doctores en la tabla
        cargar_Datos_Pacientes();
        cambiar_Visibilidad(false);
    }
    
    private void generar_Estructura_Pacientes(){
        model.setColumnIdentifiers(new Object[]{"Código", "Nombre Completo", "Género", "Edad"});
        tbl_Base.setModel(model);
    }
    
    private void cargar_Datos_Pacientes(){
        // Aquí se cargan los datos de la lista de doctores en la tabla
        // Recorre la lista de doctores y agrega cada doctor como una fila en la tabla
        
        for (Paciente paciente : lista_Pacientes) {
            model.addRow(new Object[]{paciente.getid(), paciente.getNombre()+ " " +paciente.getApellido(),
                paciente.getSexo(), paciente.getEdad()});
        }
    }
}
