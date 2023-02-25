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
import java.io.PrintWriter;
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
    public void cargarArchivo() {
        String info_txt = "";
        JFileChooser jf = new JFileChooser();
        jf.showOpenDialog(null);
        File archivo = jf.getSelectedFile();
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    info_txt += line + "\n";
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de lectura");
        }
        try {
            if (!"".equals(info_txt)) {
                String[] arr_txt = info_txt.split("\n");
                int linea = 1;
                while (!arr_txt[linea].equals("Almacenes;")) {
                    String[] atributos = arr_txt[linea].split("\n");
                    Almacen newAlmacen = new Almacen(atributos[0].charAt(0), atributos[1], atributos[2]);
                    this.almacenGuardado.addAtTheEnd(newAlmacen);
                    linea += 1;
                
                }
                JOptionPane.showMessageDialog(null, "Archivo cargado en el sistema.");
                this.full = true;
            } else {
                JOptionPane.showMessageDialog(null, "El archivo esta vacío");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de lectura");
        }

    }
}