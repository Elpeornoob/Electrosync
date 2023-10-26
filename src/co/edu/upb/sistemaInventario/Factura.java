package co.edu.upb.sistemaInventario;

import java.util.ArrayList;
import java.util.Date;

public class Factura {
	private int numeroFactura;
	private Cliente cliente;
	private ArrayList<Venta> ventas = new ArrayList<Venta>();
	private Date fechaFactura;
	
	public Factura(ArrayList<Venta> venta, Cliente cliente, Date fecha, int numeroFactura) {
		for (int ii = 0; ii < venta.size(); ii++) {
			ventas.add(venta.get(ii));
		}
		this.cliente = cliente;
		fechaFactura = fecha;
		this.numeroFactura = numeroFactura;
	}
	
	public Factura(Venta venta, Cliente cliente, Date fecha, int numeroFactura) {
		ventas.add(venta);
		this.cliente = cliente;
		fechaFactura = fecha;
		this.numeroFactura = numeroFactura;
	}
	
	public Date getDate() {
		return fechaFactura;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public int getIdFactura() {
		return numeroFactura;
	}
	
	public ArrayList<Venta> getVentas(){
		return ventas;
	}

}
