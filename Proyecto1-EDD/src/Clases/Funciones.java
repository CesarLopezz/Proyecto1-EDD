/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 *
 * @author Andrea
 */
public class Funciones {
    public Grafo grafoGuardado;
    public ListaClientes clientesGuardado;
    public ListaAlmacenes almacenGuardado;
    public ListaPedidos pedidosGuardado;
    public ListaRutas rutaGuardado;
    public boolean full;
    
    public Funciones() {
        this.clientesGuardado = new ListaClientes();
        this.almacenGuardado = new ListaAlmacenes();
        this.pedidosGuardado = new ListaPedidos();
        this.rutaGuardado = new ListaRutas();
        this.full = false;
    }

    public class CargarArchivo {
    
    }    
}