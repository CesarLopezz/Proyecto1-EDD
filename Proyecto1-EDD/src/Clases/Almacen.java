/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Andrea
 */
public class Almacen {
    /**public char key;*/
    public String Nombre;
    public String Productos;
    public Almacen next;

    public Almacen(char key, String Nombre, String Productos) {
        /**this.key = key;*/
        this.Nombre = Nombre;
        this.Productos = Productos;
        this.next = null;
    }
    
    public void EliminarProducto(String producto){
        this.Productos = Productos.replaceAll("/"+producto," ");
    }
    
}
