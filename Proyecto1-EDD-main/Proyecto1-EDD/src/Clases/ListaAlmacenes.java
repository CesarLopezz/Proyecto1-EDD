/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Andrea
 */
public class ListaAlmacenes {
    public Almacen first;
    public Almacen last;
    public int size;

    public ListaAlmacenes() {
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
     * @param newAlmacen el nuevo almacen que añadir
     */
    public void addAtTheEnd(Almacen newAlmacen) {
        if (this.isEmpty()) {
            first = last = newAlmacen;
        } else {
            last.next = newAlmacen;
            this.last = newAlmacen;
        }
        this.size++;
    }
    /**
     * Description: Busca el valor de indice para el grafo de la key dada
     * @param key key del restaurante
     * @return numero de indice correspondiente en el grafo
     */
    public int getNumDelAlmacen(char key) {
        Almacen temp = this.first;
        int count = 1;
        while (temp.key != key) {
            count += 1;
            temp = temp.next;
        }
        return count;
    }
}
