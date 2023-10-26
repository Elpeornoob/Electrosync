package co.edu.upb.sistemaInventario;

public class Producto {
	private String nombreProducto;
	private String idProducto;
	private int stockProducto;
	private float costoProducto;
	private float precioProducto;
	
	public Producto(String nombreProducto, String idProducto, int stockProducto, float costoProducto) {
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

	public float getCostoProducto() {
		return costoProducto;
	}

	public void setCostoProducto(float costoProducto) {
		this.costoProducto = costoProducto;
	}

	public float getPrecioProducto() {
		float precioProducto;
		precioProducto = (float) (getCostoProducto() + (getCostoProducto() * 1.2));
		return precioProducto;
	}

	public void setStockProducto(int stockProducto) {
		this.stockProducto = stockProducto;
	}
	
	
	
}
