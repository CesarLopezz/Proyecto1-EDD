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
    private static final String ARCHIVO_GUARDADO = "Hay datos sin guardar. ¿Desea guardarlos antes de cargar un nuevo archivo?";
    public static void main(String[] args) {
        // Mostramos el cuadro de diálogo para que el usuario seleccione el archivo
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(null);

        // Si el usuario selecciona un archivo, lo cargamos
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            try {
                // Leemos el archivo
                BufferedReader br = new BufferedReader(new FileReader(archivo));
                String linea;
                List<String> lineas = new ArrayList<>();
                while ((linea = br.readLine()) != null) {
                    lineas.add(linea);
                }
                br.close();

                // Creamos el objeto grafo con la información del archivo
                Grafo grafo = crearGrafo(lineas);

                // Si había datos sin guardar, mostramos un mensaje de alerta
                if (hayDatosSinGuardar()) {
                    int opcion = JOptionPane.showConfirmDialog(null, ARCHIVO_GUARDADO);
                    if (opcion == JOptionPane.YES_OPTION) {
                        guardarDatos();
                    }
                }

                // TODO: Hacer algo con el objeto grafo creado
                // ...

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static Grafo crearGrafo(List<String> lineas) {
        // TODO: Implementar la creación del objeto grafo con la información del archivo
        // ...
        return null;
    }

    private static boolean hayDatosSinGuardar() {
        // TODO: Implementar la lógica para determinar si hay datos sin guardar
        // ...
        return false;
    }

    private static void guardarDatos() {
        // TODO: Implementar la lógica para guardar los datos
        // ...
    }
}
    
}