package co.edu.upb.sistemaInventario;

public class Producto {
	private String nombreProducto;
	private String idProducto;
	private int stockProducto;
	private double costoProducto;
	
	public Producto(String nombreProducto, String idProducto, int stockProducto, double costoProducto) {
		super();
		this.nombreProducto = nombreProducto;
		this.idProducto = idProducto;
		this.stockProducto = stockProducto;
		this.costoProducto = costoProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public int getStockProducto() {
		return stockProducto;
	}

	public double getPrecioProducto() {
		double precioProducto;
		precioProducto = costoProducto + (costoProducto * 1.2);
		return precioProducto;
	}

	public void setStockProducto(int stockProducto) {
		this.stockProducto = stockProducto;
	}
	
	
	
}
