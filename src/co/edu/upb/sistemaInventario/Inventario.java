package co.edu.upb.sistemaInventario;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Inventario {
	private ArrayList<Producto> productos = new ArrayList<Producto>() ;

	public Inventario(){
	}

	public void agregarProducto(Producto producto) {
		productos.add(producto);
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
		productos.add(productoTemporal);
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
		productos.remove(indiceProducto);
	}
	
	public void eliminarCantidadDeProducto(Producto producto ,int cantidadAEliminar) {
		int indiceProducto = productos.indexOf(producto);
		int numeroParaEliminar = productos.get(indiceProducto).getStockProducto() - cantidadAEliminar;
		productos.get(indiceProducto).setStockProducto(numeroParaEliminar);
	}
	
}
