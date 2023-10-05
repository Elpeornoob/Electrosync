package co.edu.upb.sistemaInventario;

import java.util.Date;

public class Venta {
	
	private Date fechaVenta;
	private Producto productoVendido;
	private int cantidadVendida;
	private Cliente cliente;
	
	public Venta(Date fechaVenta, Producto productoVendido, int cantidadVendida, Cliente cliente) {
		this.fechaVenta = fechaVenta;
		this.productoVendido = productoVendido;
		this.cantidadVendida = cantidadVendida;
		this.cliente = cliente;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public Producto getProductoVendido() {
		return productoVendido;
	}

	public int getCantidadVendida() {
		return cantidadVendida;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public double calcularTotal() {
		double totalVenta;
		totalVenta = productoVendido.getPrecioProducto() * cantidadVendida;
		return totalVenta;
	}
	
	public void imprimirRecibo() {
		
	}

}
