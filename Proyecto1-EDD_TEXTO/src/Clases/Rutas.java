/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Andrea
 */
public class Rutas {
    public int key;
    public String Salida;
    public String Llegada;
    public int Tiempo;
    public Rutas next;

    public Rutas(int key, String Salida, String Llegada, int Tiempo) {
        this.key = key;
        this.Salida = Salida;
        this.Llegada = Llegada;
        this.Tiempo = Tiempo;
        this.next = null;
    }
    
    
    
}
