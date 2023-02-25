/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Andrea
 */
public class Producto {
    public String Almacen;
    public String Nombre;
    public int Cantidad;
    public Producto next;

    public Producto(String Almacen, String Nombre, int Cantidad ) {
        this.Almacen = Almacen;
        this.Nombre = Nombre;
        this.Cantidad = Cantidad;
        this.next = null;
    }
    
    
}
