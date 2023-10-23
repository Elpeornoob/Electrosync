package co.edu.upb.sistemaInventario;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Inventario {
	private ArrayList<Producto> productos = new ArrayList<Producto>() ;
	private static final String JSON_FILE = "inventario.json";

	public Inventario(){
		productos = new ArrayList<>();
		cargarDatosDesdeJSON();
	}

	public void agregarProducto(Producto producto) {
		productos.add(producto);
		guardarDatosEnJSON();
	}
	
	public void agregarProducto() {
		String nombreDelProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto: ");
		if(nombreDelProducto == null) {
			return;
		}
		String codigoDelProducto = JOptionPane.showInputDialog("Ingrese el código del producto: ");
		if(codigoDelProducto == null) {
			return;
		}
		String sStockProducto = JOptionPane.showInputDialog("Ingrese la cantidad del producto: ");
		int iStockProducto = 0;
		if(sStockProducto == null) {
			return;
		}else {
			iStockProducto = Integer.parseInt(sStockProducto);
		}
		String sCostoProducto = JOptionPane.showInputDialog("Ingrese el costo del producto: ");
		Double dCostoProducto = null;
		if(sCostoProducto == null) {
			return;
		}else {
			dCostoProducto = Double.parseDouble(sCostoProducto);
		}
		Producto productoTemporal = new Producto(nombreDelProducto, codigoDelProducto, iStockProducto, dCostoProducto);
		agregarProducto(productoTemporal);;
    }
	
	public Producto buscarProductoPorNombre(String producto) {
		Producto productoEncontrado =  null;
		for(int ii = 0; ii < productos.size(); ii++) {		
			if(productos.get(ii).getNombreProducto().equals(producto)) {
				productoEncontrado = productos.get(ii);	
				return productoEncontrado;
				}	
			}
		return null;
	}
	
	public Producto buscarProductoPorId(String id) {
		Producto productoEncontrado = null;
		for(int ii = 0; ii < productos.size(); ii++) {		
			if(productos.get(ii).getIdProducto().equals(id)) {
				productoEncontrado = productos.get(ii);	
				return productoEncontrado;
				}	
			}
		return null;
	}
	
	public void eliminarProducto(Producto producto) {
	    int indiceProducto = productos.indexOf(producto);
	    if (indiceProducto >= 0) {
	        productos.remove(indiceProducto);
	        guardarDatosEnJSON(); // Agrega esta línea para actualizar el JSON
	    }
	}
	
	public void eliminarCantidadDeProducto(Producto producto, int cantidadAEliminar) {
	    int indiceProducto = productos.indexOf(producto);
	    if (indiceProducto >= 0) {
	        int stockActual = productos.get(indiceProducto).getStockProducto();
	        int nuevoStock = stockActual - cantidadAEliminar;
	        
	        if (nuevoStock < 0) {
	            nuevoStock = 0; // Asegurarse de que el stock no sea negativo
	        }

	        productos.get(indiceProducto).setStockProducto(nuevoStock);
	        guardarDatosEnJSON(); // Agrega esta línea para actualizar el JSON
	    }
	}
	
	private void cargarDatosDesdeJSON() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            productos = objectMapper.readValue(new File(JSON_FILE), new TypeReference<ArrayList<Producto>>() {});
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }
	
	private void guardarDatosEnJSON() {
	    try {
	        ObjectMapper objectMapper = new ObjectMapper();
	        objectMapper.writeValue(new File(JSON_FILE), productos);
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}

}
