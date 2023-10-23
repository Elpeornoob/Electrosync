package co.edu.upb.sistemaInventario;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RegistroVentas {
	private ArrayList<Venta> ventas;
	private static final String JSON_FILE = "registroVentas.json";
	
	public RegistroVentas() {
		ventas = new ArrayList<>();
		cargarDatosDesdeJSON();
	}
	
	public void registrarVenta(Venta venta) {
		ventas.add(venta);
		guardarDatosEnJSON();
	}
	
	public void generarInformeVentas() {
        double totalVentas = 0.0;
        String cadenaConcatenada2 = "\n";
        
        for (int ii = 0; ii < ventas.size(); ii++) {
        	String titulo = "INFORME DE VENTA";
        	String fecha = "Fecha de Venta: " + ventas.get(ii).getFechaVenta();
            String cliente = "Cliente: " + ventas.get(ii).getCliente().getNombreCliente();
            String productoVendido = "Producto Vendido: " + ventas.get(ii).getProductoVendido().getNombreProducto();
            String cantidadVendida = "Cantidad Vendida: " + ventas.get(ii).getCantidadVendida();
            String totalDeVenta = "Total de Venta: $ " + ventas.get(ii).calcularTotal();
            String separacion = "------------------------------------------------------------------------";
            
            JOptionPane.showMessageDialog(null,
            		titulo + "\n" + "\n" +
            		separacion + "\n" +
            		fecha + "\n" +
            		cliente + "\n" +
            		productoVendido + "\n" +
            		cantidadVendida + "\n" +
            		totalDeVenta + "\n" +
            		separacion + "\n"
            		);
            
            String cadenaConcatenada = "\n" + separacion + "\n" + titulo + "\n" + fecha + "\n" + cliente + "\n" + productoVendido + "\n" + cantidadVendida + "\n" + totalDeVenta + "\n" + separacion + "\n" + "\n";
            totalVentas += ventas.get(ii).calcularTotal();
            
            cadenaConcatenada2 = cadenaConcatenada2 + cadenaConcatenada;
        }
        cadenaConcatenada2 = cadenaConcatenada2 + "\n" + "Total de Ventas: " + totalVentas;
        
        JOptionPane.showMessageDialog(null, "Total de Ventas: $ " + totalVentas);
        
	        try {
	            BufferedWriter writer = new BufferedWriter(new FileWriter("Output.txt"));
	            writer.write(cadenaConcatenada2);
	
	            writer.close();
	
	            JOptionPane.showMessageDialog(null, "Archivo creado correctamente");
	        } catch (IOException e) {
	        	JOptionPane.showMessageDialog(null, "Error al crear el archivo" + e.getMessage());
	        }
        
    	}
	
	private void cargarDatosDesdeJSON() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
           ventas = objectMapper.readValue(new File(JSON_FILE), new TypeReference<ArrayList<Venta>>() {});
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }
	
	private void guardarDatosEnJSON() {
	    try {
	        ObjectMapper objectMapper = new ObjectMapper();
	        objectMapper.writeValue(new File(JSON_FILE), ventas);
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
 }
