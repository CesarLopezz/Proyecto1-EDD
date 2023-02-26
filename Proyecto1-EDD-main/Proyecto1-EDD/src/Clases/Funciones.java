/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
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
    public ListaProductos productoGuardado;
    public boolean full;
    
    public Funciones() {
        this.clientesGuardado = new ListaClientes();
        this.almacenGuardado = new ListaAlmacenes();
        this.pedidosGuardado = new ListaPedidos();
        this.rutaGuardado = new ListaRutas();
        this.productoGuardado = new ListaProductos();
        this.full = false;
    }

    public void actualizarTexto() {
        if (!(this.almacenGuardado.isEmpty() || this.grafoGuardado.isEmpty()|| this.productoGuardado.isEmpty() || this.rutaGuardado.isEmpty())) {
            try {
                String newTxt = "";
                newTxt += "Almacenes \n";
                Almacen temp1 = this.almacenGuardado.first;
                while (temp1 != null) {
                    String newLine = Character.toString(temp1.key) + "," + temp1.Nombre + "," + temp1.Productos + "\n";
                    newTxt += newLine;
                    temp1 = temp1.next;
                }
                newTxt += "Producto \n";
                Producto temp3 = this.productoGuardado.first;
                while (temp3 != null) {
                    String newLine = temp3.Almacen+ "," + temp3.Nombre + "," + temp3.Cantidad + "\n";
                    newTxt += newLine;
                    temp3 = temp3.next;
                }
                newTxt += "Rutas \n";
                String textoRutas = this.grafoGuardado.rutasString(clientesGuardado, almacenGuardado);
                newTxt += textoRutas;
                JFileChooser jf = new JFileChooser();
                jf.showOpenDialog(null);
                File archivo = jf.getSelectedFile();
                String ruta = archivo.getAbsolutePath();
                try (PrintWriter pw = new PrintWriter(ruta)) {
                    pw.print(newTxt);
                }
                JOptionPane.showMessageDialog(null, "Actualización exitosa.");
                this.full = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en el catch");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error, una de las estructuras no tiene información");
        }
    }
    /**
     * Description: Acomida el tamaño de una imagen ubicada en "test/Resources" al tamaño de un label
     * @param frame Label que tiene el tamaño deseado
     * @param imgName el nombre de la imagen
     */
    public void scaleImage(JLabel frame, String imgName) {
        ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("Test/Resources/" + imgName));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        frame.setIcon(scaledIcon);
    }
    /**
     * Description: Escoge un archivo txt y carga sus datos en los atributos de la clase
     */
    
    
        
    public void leerArchivo() {
        File file = new File("/Users/cesar/amazon.txt");
 
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                br.lines().forEach(System.out::println);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    
    public void cargarArchivo(){
        String nombreArchivo = "/Users/cesar/amazon.txt";
        Map<String, Map<String, Integer>> almacenes = new HashMap<>();
        Map<String, Integer> rutas = new HashMap<>();
        boolean archivoCargado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            String almacenActual = null;
            while ((linea = br.readLine()) != null) {
                if (linea.equals("Almacenes;")) {
                    archivoCargado = true;
                } else if (linea.equals("Rutas;")) {
                    almacenActual = null;
                } else if (almacenActual != null) {
                    String[] partes = linea.split(",");
                    String producto = partes[0];
                    String cantidad = partes[1];
                    almacenes.get(almacenActual).put(producto, Integer.parseInt(cantidad));
                } else if (linea.endsWith(":")) {
                    almacenActual = linea.substring(0, linea.length() - 1);
                    almacenes.put(almacenActual, new HashMap<>());
                } else {
                    String[] partes = linea.split(",");
                    String almacenOrigen = partes[0];
                    String almacenDestino = partes[1];
                    int peso = Integer.parseInt(partes[2]);
                    rutas.put(almacenOrigen + "-" + almacenDestino, peso);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        if (!archivoCargado) {
            System.out.println("El archivo no se ha cargado correctamente.");
            return;
        }

        // Imprimir los almacenes
        for (Map.Entry<String, Map<String, Integer>> entry : almacenes.entrySet()) {
            String nombreAlmacen = entry.getKey();
            Map<String, Integer> productos = entry.getValue();
            System.out.println(nombreAlmacen + ":");
            for (Map.Entry<String, Integer> producto : productos.entrySet()) {
                System.out.println(producto.getKey() + "," + producto.getValue());
            }
        }

        // Imprimir las rutas
        System.out.println("Rutas:");
        for (Map.Entry<String, Integer> entry : rutas.entrySet()) {
            String[] partes = entry.getKey().split("-");
            String almacenOrigen = partes[0];
            String almacenDestino = partes[1];
            int peso = entry.getValue();
            System.out.println(almacenOrigen + "," + almacenDestino + "," + peso);
        }
    }}