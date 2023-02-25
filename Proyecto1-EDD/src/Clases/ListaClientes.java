/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Andrea
 */
public class ListaClientes {
    public Clientes first;
    public Clientes last;
    public int size;
    
    public ListaClientes() {
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
     * Description: Vacia la lista de clientes
     */
    public void empty() {
        this.first = this.last = null;
        this.size = 0;
    }
    /**
     * Description añade un cliente al final de la lista
     * @param newCliente cliente nuevo a añadir
     */
    public void addAtTheEnd(Clientes newCliente) {
        if (this.isEmpty()) {
            first = last = newCliente;
        } else {
            last.next = newCliente;
            this.last = newCliente;
        }
        this.size ++;
    }
}
