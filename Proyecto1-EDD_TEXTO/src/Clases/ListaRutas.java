/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Andrea
 */
public class ListaRutas {
    public Rutas first;
    public Rutas last;
    public int size;

    public ListaRutas() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    /**
     * Description: revisa si la lista esta vacia
     * @return true si esta vacia, false si no lo esta
     */
    public boolean isEmpty() {
        return null == this.first;
    }
    /**
     * Description: vacia la lista
     */
    public void empty() {
        this.first = this.last = null;
        this.size = 0;
    }
    /**
     * Description: Añade un alamcen al final de la lista
     * @param newRuta nuevo ruta que añadir
     */
    public void addAtTheEnd(Rutas newRuta) {
        if (this.isEmpty()) {
            first = last = newRuta;
        } else {
            last.next = newRuta;
            this.last = newRuta;
        }
        this.size++;
    }
}
