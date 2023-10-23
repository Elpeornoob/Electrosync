package co.edu.upb.sistemaInventario;

public class Producto {
	private String nombreProducto;
	private String idProducto;
	private int stockProducto;
	private double costoProducto;
	private double precioProducto;
	
	public Producto(String nombreProducto, String idProducto, int stockProducto, double costoProducto) {
		super();
		this.nombreProducto = nombreProducto;
		this.idProducto = idProducto;
		this.stockProducto = stockProducto;
		this.costoProducto = costoProducto;
		this.precioProducto = getPrecioProducto();
	}
	
	public Producto() {
		
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

	public double getCostoProducto() {
		return costoProducto;
	}

	public void setCostoProducto(double costoProducto) {
		this.costoProducto = costoProducto;
	}

	public double getPrecioProducto() {
		double precioProducto;
		precioProducto = getCostoProducto() + (getCostoProducto() * 1.2);
		return precioProducto;
	}

	public void setStockProducto(int stockProducto) {
		this.stockProducto = stockProducto;
	}
	
	
	
}
