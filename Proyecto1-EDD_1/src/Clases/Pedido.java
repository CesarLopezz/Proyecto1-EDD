/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Andrea
 */
public class Pedido {
    public String Almacen;
    public String Pedido;
    public int Cantidad;
    public String Ruta;
    public Pedido next;

    public Pedido(String Almacen, String Pedido, int Cantidad, String Ruta) {
        this.Almacen = Almacen;
        this.Pedido = Pedido;
        this.Cantidad = Cantidad;
        this.Ruta = Ruta;
        this.next = null;
    }
    
    public String getPedidoString() {
        String ped = this.Almacen + "," + this.Pedido + "," + this.Cantidad + "," + this.Ruta;
        return ped;
    }
    
}
