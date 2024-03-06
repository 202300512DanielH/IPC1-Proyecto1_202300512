
package controller;

import Models.Frecuencia;
import Models.Producto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;

public class Productos_Controller {
    
    static ArrayList<Producto> lista_Productos = new ArrayList<Producto>();
    static int id = 0;
    
    public boolean crear_Producto(String nombre, double precio, String descripcion, int cantidad){
        id++;
        Producto nuevo_Producto = new Producto(id, nombre, precio, descripcion, cantidad);
        lista_Productos.add(nuevo_Producto);
        JOptionPane.showMessageDialog(null, "Se a creado el producto con exito, su codigo es:"+"\n"+id);
        return false;
    }
    
    public void crearProductos() {
        String[] nombres = {"Producto1", "Producto2", "Producto3", "Producto4", "Producto5", "Producto6", "Producto7", "Producto8", "Producto9", "Producto10", "Producto11", "Producto12", "Producto13", "Producto14", "Producto15"};
        double[] precios = {10.50, 20.25, 15.75, 30.00, 12.80, 18.60, 25.40, 22.90, 17.35, 28.75, 14.20, 21.90, 19.60, 32.50, 24.75};
        String[] descripciones = {"Descripción1", "Descripción2", "Descripción3", "Descripción4", "Descripción5", "Descripción6", "Descripción7", "Descripción8", "Descripción9", "Descripción10", "Descripción11", "Descripción12", "Descripción13", "Descripción14", "Descripción15"};
        int cantidad = 50; // Puedes cambiar la cantidad si deseas que sea diferente para cada producto

        for (int i = 0; i < nombres.length; i++) {
            id++; // Incrementar el ID para el próximo producto
            Producto nuevoProducto = new Producto(id, nombres[i], precios[i], descripciones[i], cantidad);
            lista_Productos.add(nuevoProducto);
        }
    }
    
    public void actualizar_Producto(int id, String nombre, double precio, String descripcion, int cantidad){
        for(int i = 0; i < lista_Productos.size(); i++){
            Producto producto = lista_Productos.get(i);
            if( producto.getId_Producto() == id ){
                producto.setNombre(nombre);
                producto.setPrecio(precio);
                producto.setDescripcion(descripcion);
                producto.setCantidad(cantidad);
                lista_Productos.set(i, producto);
                break;
            }
        }
    }
    
    public Producto encontrar_Producto(int id){
        for( Producto producto: lista_Productos ){
            if( producto.getId_Producto() == id ){
                return producto;
            }            
        }
        return null;
    }
    
    public boolean eliminar_Producto(int id){
        Producto producto;
        for( int i = 0; i < lista_Productos.size(); i++ ){
            producto = lista_Productos.get(i);
            if( producto.getId_Producto() == id ){
                lista_Productos.remove(i);
                return true;
            }
        }        
        return false;
    }
    
    public void organizar_Productos() {
        Collections.sort(lista_Productos, new Comparator<Producto>() {
            @Override
            public int compare(Producto p1, Producto p2) {
                return Integer.compare(p2.getCantidad(), p1.getCantidad());
            }
        });
    }
    
    public ArrayList<Producto> get_Lista_Productos_Ordenados(){
        organizar_Productos();
        return lista_Productos;
    }
    
    public ArrayList<Producto> get_Lista_Productos(){
        return lista_Productos;
    }
}
