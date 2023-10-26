package co.edu.upb.sistemaInventario;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RegistroVentas {
	private ArrayList<Venta> ventas;
	private static final String JSON_FILE = "registroVentas.json";
	private ListaFacturas listaFacturas = new ListaFacturas();
	private int IdFactura = 1;
	
	public RegistroVentas() {
		ventas = new ArrayList<>();
		cargarDatosDesdeJSON();
	}
	
	public void registrarVentaUnica(Venta venta, Cliente cliente) {
		ventas.add(venta);
		guardarDatosEnJSON();
		Factura facturaTemp = new Factura(venta, cliente, new Date(), IdFactura);
		listaFacturas.agregarNuevaFactura(facturaTemp);
		IdFactura++;
		listaFacturas.mostrarFactura(facturaTemp);
	}
	
	public void registrarVentasMultiples(ArrayList<Venta> venta, Cliente cliente) {
		for (int ii = 0; ii < venta.size(); ii++) {
			ventas.add(venta.get(ii));
		}
		Factura facturaTemp = new Factura(venta, cliente, new Date(), IdFactura);
		listaFacturas.agregarNuevaFactura(facturaTemp);
		IdFactura++;
		listaFacturas.mostrarFactura(facturaTemp);
	}
	
	public void generarInformeVentas() {
        float totalVentas = 0;
        String cadenaConcatenada2 = "\n";
        
        for (int ii = 0; ii < ventas.size(); ii++) {
        	String titulo = "INFORME DE VENTA";
            String productoVendido = "Producto Vendido: " + ventas.get(ii).getProductoVendido().getNombreProducto();
            String cantidadVendida = "Cantidad Vendida: " + ventas.get(ii).getCantidadVendida();
            String totalDeVenta = "Total de Venta: $ " + String.format("%.0f", ventas.get(ii).calcularTotal());
            String separacion = "------------------------------------------------------------------------";
            
            JOptionPane.showMessageDialog(null,
            		titulo + "\n" + "\n" +
            		separacion + "\n" +
            		productoVendido + "\n" +
            		cantidadVendida + "\n" +
            		totalDeVenta + "\n" +
            		separacion + "\n"
            		);
            
            String cadenaConcatenada = "\n" + separacion + "\n" + titulo + "\n" + productoVendido + "\n" + cantidadVendida + "\n" + totalDeVenta + "\n" + separacion + "\n" + "\n";
            totalVentas += ventas.get(ii).calcularTotal();
            
            cadenaConcatenada2 = cadenaConcatenada2 + cadenaConcatenada;
        }
        cadenaConcatenada2 = cadenaConcatenada2 + "\n" + "Total de Ventas: " + String.format("%.0f", totalVentas);;
        
        JOptionPane.showMessageDialog(null, "Total de Ventas: $ " + String.format("%.0f", totalVentas));
        
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
