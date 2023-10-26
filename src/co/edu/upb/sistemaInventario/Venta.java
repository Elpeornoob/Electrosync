package co.edu.upb.sistemaInventario;

import java.util.Date;

public class Venta {
	
	private Producto productoVendido;
	private int cantidadVendida;
	
	public Venta(Producto productoVendido, int cantidadVendida) {
		this.productoVendido = productoVendido;
		this.cantidadVendida = cantidadVendida;
	}
	
	public Venta() {
		
	}

	public Producto getProductoVendido() {
		return productoVendido;
	}

	public int getCantidadVendida() {
		return cantidadVendida;
	}
	
	public float calcularTotal() {
		float totalVenta;
		totalVenta = productoVendido.getPrecioProducto() * cantidadVendida;
		return totalVenta;
	}
	
	public void imprimirRecibo() {
		
	}

}
