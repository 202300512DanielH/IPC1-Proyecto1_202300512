
package Panel.administrador;

import Models.Doctor;
import Models.Frecuencia;
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
    
    private javax.swing.JPanel panelFind = null;
    private javax.swing.JLabel titulo;
    private javax.swing.JButton btn_Regresar;
    private javax.swing.JButton btn_Doctores;
    private javax.swing.JButton btn_Productos;
    private DefaultTableModel model = new DefaultTableModel();
    public javax.swing.JTable tbl_Base;
    private javax.swing.JScrollPane jScrollPane1;
    private ArrayList<Doctor> lista_Doctores = new ArrayList<Doctor>();
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
        titulo = new javax.swing.JLabel();
        btn_Regresar = new javax.swing.JButton();
        btn_Doctores = new javax.swing.JButton();
        btn_Productos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Base = new javax.swing.JTable();
        
        panel = new ChartPanel(null);
        panel.setMouseWheelEnabled(true);
        panel.setBounds(50, 300, 700, 280);
        this.add(panel);
        
        titulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setText("Reportes - Administrador");
        titulo.setBounds(300, 50, 300, 30);
        this.add(titulo);
        
        btn_Regresar.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Regresar.setForeground(new java.awt.Color(0, 0, 0));
        btn_Regresar.setText("Regresar");
        btn_Regresar.setBounds(550, 600, 150, 30);
        btn_Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegresarActionPerformed(evt);
            }
        });        
        this.add(btn_Regresar);
        
        btn_Doctores.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Doctores.setForeground(new java.awt.Color(0, 0, 0));
        btn_Doctores.setText("Doctores");
        btn_Doctores.setBounds(50, 120, 150, 30);
        btn_Doctores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DoctoresActionPerformed(evt);
            }
        });
        
        this.add(btn_Doctores);
        
        btn_Productos.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Productos.setForeground(new java.awt.Color(0, 0, 0));
        btn_Productos.setText("Productos");
        btn_Productos.setBounds(220, 120, 150, 30);
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
        
        int x = 50;
        int y = 170;
        int width = 700;
        int height = 120;
        
        // Establecer la posición y tamaño del JScrollPane
        jScrollPane1.setBounds(x, y, width, height);

        // Añadir el JScrollPane al panel
        add(jScrollPane1);
        
        setBackground(new java.awt.Color(171,255,213));
    }
    
    private void regresar(){
        Panel_Controller panel_Controller = new Panel_Controller();
        panelFind = panel_Controller.get_Panel_Menu_Administrador();
        panel_Controller.get_Ventana_Base().cambiarPaneles(panelFind);
    }
    
    private void btn_RegresarActionPerformed(java.awt.event.ActionEvent evt) {
        regresar();
    }
    
    private void btn_DoctoresActionPerformed(java.awt.event.ActionEvent evt) {
        // Generar estructura de tabla para doctores
        model.setRowCount(0);
        generarEstructuraDoctores();
        // Cargar datos de la lista de doctores en la tabla
        cargarDatosDoctores();
        generar_Grafica_Doctores();
    }
    
    private void btn_ProductosActionPerformed(java.awt.event.ActionEvent evt) {
        model.setRowCount(0);
        generarEstructuraProductos();
        //Cargar datos de la lista de products en la tabla
        cargarDatosProductos();
        generar_Grafica_Producos();
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
    
}
