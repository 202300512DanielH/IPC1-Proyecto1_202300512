
package Panel.administrador;

import Models.Producto;
import controller.Panel_Controller;
import controller.Productos_Controller;
import javax.swing.JOptionPane;

public class Panel_Control_Producto extends javax.swing.JPanel {

    private int codigo;
    javax.swing.JPanel panelFind = null;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel lbl_Nombre;
    private javax.swing.JLabel lbl_Precio;
    private javax.swing.JLabel lbl_Descripcion;
    private javax.swing.JLabel lbl_Cantidad;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Precio;
    private javax.swing.JTextField txt_Descripcion;
    private javax.swing.JTextField txt_Cantidad;
    private javax.swing.JButton btn_Regresar;
    private javax.swing.JButton btn_Crear_Producto;
    private javax.swing.JButton btn_Actualizar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Aceptar_Cambios;
    private javax.swing.JButton btn_Cancelar_Cambios;

    public Panel_Control_Producto() {
        initComponents();
    }

    private void initComponents() {
        setLayout(null);

        titulo = new javax.swing.JLabel();
        lbl_Nombre = new javax.swing.JLabel();
        lbl_Precio = new javax.swing.JLabel();
        lbl_Descripcion = new javax.swing.JLabel();
        lbl_Cantidad = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        txt_Precio = new javax.swing.JTextField();
        txt_Descripcion = new javax.swing.JTextField();
        txt_Cantidad = new javax.swing.JTextField();
        btn_Regresar = new javax.swing.JButton();
        btn_Crear_Producto = new javax.swing.JButton();
        btn_Actualizar = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();
        btn_Aceptar_Cambios = new javax.swing.JButton();
        btn_Cancelar_Cambios = new javax.swing.JButton();

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setText("Acciones Productos - Administrador");
        titulo.setBounds(250, 50, 320, 30);
        this.add(titulo);

        lbl_Nombre.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_Nombre.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Nombre.setText("Nombre:");
        lbl_Nombre.setBounds(250, 150, 80, 25);
        this.add(lbl_Nombre);

        lbl_Precio.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_Precio.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Precio.setText("Precio:");
        lbl_Precio.setBounds(250, 200, 80, 25);
        this.add(lbl_Precio);

        lbl_Descripcion.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_Descripcion.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Descripcion.setText("Descripción:");
        lbl_Descripcion.setBounds(250, 250, 80, 25);
        this.add(lbl_Descripcion);

        lbl_Cantidad.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lbl_Cantidad.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Cantidad.setText("Cantidad:");
        lbl_Cantidad.setBounds(250, 300, 80, 25);
        this.add(lbl_Cantidad);

        txt_Nombre.setBounds(350, 150, 200, 25);
        this.add(txt_Nombre);

        txt_Precio.setBounds(350, 200, 200, 25);
        this.add(txt_Precio);

        txt_Descripcion.setBounds(350, 250, 200, 25);
        this.add(txt_Descripcion);

        txt_Cantidad.setBounds(350, 300, 200, 25);
        this.add(txt_Cantidad);

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

        btn_Crear_Producto.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Crear_Producto.setForeground(new java.awt.Color(0, 0, 0));
        btn_Crear_Producto.setText("Crear Producto");
        btn_Crear_Producto.setBounds(50, 500, 150, 30);
        btn_Crear_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Crear_ProductoActionPerformed(evt);
            }
        });
        this.add(btn_Crear_Producto);

        btn_Actualizar.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Actualizar.setForeground(new java.awt.Color(0, 0, 0));
        btn_Actualizar.setText("Actualizar");
        btn_Actualizar.setBounds(220, 500, 150, 30);
        btn_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ActualizarActionPerformed(evt);
            }
        });
        this.add(btn_Actualizar);

        btn_Eliminar.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Eliminar.setForeground(new java.awt.Color(0, 0, 0));
        btn_Eliminar.setText("Eliminar");
        btn_Eliminar.setBounds(390, 500, 150, 30);
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarActionPerformed(evt);
            }
        });
        this.add(btn_Eliminar);

        btn_Aceptar_Cambios.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Aceptar_Cambios.setForeground(new java.awt.Color(0, 0, 0));
        btn_Aceptar_Cambios.setText("Aceptar");
        btn_Aceptar_Cambios.setBounds(50, 450, 150, 30);
        btn_Aceptar_Cambios.setBackground(new java.awt.Color(0, 153, 51)); // Color rojo
        btn_Aceptar_Cambios.setVisible(false);
        btn_Aceptar_Cambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Aceptar_CambiosActionPerformed(evt);
            }
        });
        this.add(btn_Aceptar_Cambios);

        btn_Cancelar_Cambios.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btn_Cancelar_Cambios.setForeground(new java.awt.Color(0, 0, 0));
        btn_Cancelar_Cambios.setText("Cancelar");
        btn_Cancelar_Cambios.setBounds(220, 450, 150, 30);
        btn_Cancelar_Cambios.setBackground(new java.awt.Color(255, 0, 0)); // Color azul
        btn_Cancelar_Cambios.setVisible(false);
        btn_Cancelar_Cambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Cancelar_CambiosActionPerformed(evt);
            }
        });
        this.add(btn_Cancelar_Cambios);

        setBackground(new java.awt.Color(210, 242, 238));
    }

    private void btn_RegresarActionPerformed(java.awt.event.ActionEvent evt) {
        regresar();
    }

    private void btn_Crear_ProductoActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int cantidad = Integer.parseInt(txt_Cantidad.getText());
            String nombre = txt_Nombre.getText();
            String descripcion = txt_Descripcion.getText();
            double precio =  Double.valueOf(txt_Precio.getText());
            
            Productos_Controller producto_Controller = new Productos_Controller();
            producto_Controller.crear_Producto(nombre, precio, descripcion, cantidad);
            Panel_Controller panel_Controller = new Panel_Controller();
            panelFind = panel_Controller.get_Panel_Menu_Administrador();
            panel_Controller.get_Ventana_Base().cambiarPaneles(panelFind);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "La cantidad o el precio no son numeros");            
        }
    }

    private void btn_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {
        // Mostrar un cuadro de diálogo de entrada para que el usuario ingrese un código
        try{
            codigo = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el código del producto a actualizar:", "Código producto", JOptionPane.PLAIN_MESSAGE));
            Productos_Controller producto_Controller = new Productos_Controller();
            Producto producto_Encontrado = producto_Controller.encontrar_Producto(codigo);
            if (producto_Encontrado != null){
                txt_Nombre.setText(producto_Encontrado.getNombre());
                txt_Descripcion.setText(producto_Encontrado.getDescripcion());
                txt_Cantidad.setText(String.valueOf(producto_Encontrado.getCantidad()));
                txt_Precio.setText(String.valueOf(producto_Encontrado.getPrecio()));
                uso_Boton(false);
            }else{
                JOptionPane.showMessageDialog(null, "producto no encontrado o no existe");
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "El codigo proporcionado debe ser numeros enteros");
        }
    }

    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {
        codigo = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el código del doctor a eliminar:", "Código Doctor", JOptionPane.PLAIN_MESSAGE));
        Productos_Controller productos_Controller = new Productos_Controller();
        boolean resultado = productos_Controller.eliminar_Producto(codigo);
        if(resultado){
            JOptionPane.showMessageDialog(null, "El producto ha sido encontrado y eliminado exitosamente");
        }else{
            JOptionPane.showMessageDialog(null, "El producto no ha sido encotrado o no existe");
        }
    }

    private void btn_Aceptar_CambiosActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String nombre = txt_Nombre.getText();
            String descripcion = txt_Descripcion.getText();
            int cantidad = Integer.valueOf(txt_Cantidad.getText());
            double precio = Double.valueOf(txt_Precio.getText());
            Productos_Controller producto_Controller = new Productos_Controller();
            producto_Controller.actualizar_Producto(codigo, nombre, precio, descripcion, cantidad);
            JOptionPane.showMessageDialog(null, "Se han actualizado los datos del producto correctamente");
            regresar();
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "cantidad y precio deben ser datos numericos");
        }
    }

    private void btn_Cancelar_CambiosActionPerformed(java.awt.event.ActionEvent evt) {
        txt_Nombre.setText("");
        txt_Descripcion.setText("");
        txt_Cantidad.setText("");
        txt_Precio.setText("");
        uso_Boton(true);
    }
    
    private void regresar(){
        Panel_Controller panel_Controller = new Panel_Controller();
        panelFind = panel_Controller.get_Panel_Menu_Administrador();
        panel_Controller.get_Ventana_Base().cambiarPaneles(panelFind);
    }
    
    private void uso_Boton(boolean valor){
        btn_Crear_Producto.setEnabled(valor);
        btn_Actualizar.setEnabled(valor);
        btn_Eliminar.setEnabled(valor);
        if(!valor){
            btn_Aceptar_Cambios.setVisible(true);
            btn_Cancelar_Cambios.setVisible(true);
        }else{
            btn_Aceptar_Cambios.setVisible(false);
            btn_Cancelar_Cambios.setVisible(false);
        }
    }
}

