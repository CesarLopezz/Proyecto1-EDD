/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Andrea
 */
public class Pila {
    Nodo cima;
    int tamaño;

    public Pila() {
        this.tamaño = 0;
        this.cima = null;
    }
    /**
     * Description: Destruye la pila
     */
    public void destructor() {
        while (cima != null) {
            this.cima = cima.next;
        }
        this.tamaño = 0;
    }
    /**
     * Description: Comprueba si la pila esta vacia
     * @return true si esta vacia, false si no lo esta
     */
    public boolean isEmpty() {
        return tamaño == 0;
    }
    /**
     * Description: añade un nodo con s a la cima de la pila
     * @param s info del nodo
     */
    public void apilar(int s ) {
        Nodo newNode = new Nodo(s);
        newNode.next = this.cima;
        this.cima = newNode;
        this.tamaño++;
    }
    /**
     * Description: Elimina el nodo de la cima de la pila
     */
    public void desapilar() {
        this.cima = this.cima.next;
        this.tamaño--;
    }

    /**
     * Description: Busca si un elemento se encuentra en la pila
     * @param referencia Info del nodo buscado
     * @return true si esta en la pila, false si no lo esta
     */
    public boolean buscar(int referencia){
        // Crea una copia de la pila.
        Nodo aux = cima;
        // Bandera para verificar si existe el elemento a buscar.
        boolean existe = false;
        // Recorre la pila hasta llegar encontrar el nodo o llegar al final
        // de la pila.
        while(existe != true && aux != null){
            // Compara si el valor del nodo es igual que al de referencia.
            if (referencia == aux.valorInt()) {
                // Cambia el valor de la bandera.
                existe = true;
            }
            else{
                // Avanza al siguiente nodo.
                aux = aux.getSiguiente();
            }
        }
        // Retorna el valor de la bandera.
        return existe;
}
}
