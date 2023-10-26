package co.edu.upb.sistemaInventario;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ListaFacturas {
	private ArrayList<Factura> facturas = new ArrayList<Factura>();
	
	public ListaFacturas() {
		facturas = new ArrayList<Factura>();
	}
	
	public void agregarNuevaFactura(Factura factura) {
		facturas.add(factura);
	}
	
	public void mostrarFactura(Factura factura) {
		StringBuilder facturaDetails = new StringBuilder();
		String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String fechaStr = sdf.format(factura.getDate());
        facturaDetails.append("Fecha: ").append(fechaStr).append("\n");
        facturaDetails.append("Nombre cliente: ").append(factura.getCliente().getNombreCliente()).append("\n");
        String tipoDocumento = null;
        if(factura.getCliente().getTipoDocumento() == TipoDocumento.CARNÉ_DE_IDENTIDAD) {
        	tipoDocumento = "Carné de Identidad";
        }if(factura.getCliente().getTipoDocumento() == TipoDocumento.CEDULA_DE_CIUDADANIA) {
        	tipoDocumento = "Cedula Ciudadana";
        }if(factura.getCliente().getTipoDocumento() == TipoDocumento.CEDULA_DE_EXTRANJERIA) {
        	tipoDocumento = "Cedula Extranjeria";
        }if(factura.getCliente().getTipoDocumento() == TipoDocumento.DOCUMENTO_NACIONAL_DE_IDENTIDAD) {
        	tipoDocumento = "Documento Nacional de Identidad";
        }if(factura.getCliente().getTipoDocumento() == TipoDocumento.TARJETA_DE_IDENTIDAD) {
        	tipoDocumento = "Tarjeta de Identidad";
        }
        facturaDetails.append("Tipo de documento: ").append(tipoDocumento).append("\n");
        facturaDetails.append("Número de documento: ").append(factura.getCliente().getNumeroDocumento()).append("\n");
        facturaDetails.append("Id de factura: ").append(factura.getIdFactura()).append("\n");
        facturaDetails.append("------------------------------------------------------------------\n");
        facturaDetails.append("------------------------------------------------------------------\n");

        for (Venta venta : factura.getVentas()) {
            facturaDetails.append("Producto: ").append(venta.getProductoVendido().getNombreProducto()).append("\n");
            facturaDetails.append("Cantidad: ").append(venta.getCantidadVendida()).append("\n");
            facturaDetails.append("Precio Unitario: ").append(venta.getProductoVendido().getPrecioProducto()).append("\n");
            facturaDetails.append("Subtotal: ").append(Float.toString(venta.calcularTotal())).append("\n");
            facturaDetails.append("------------------------------------------------------------------\n");
        }

        JOptionPane.showMessageDialog(null, facturaDetails.toString());
		
	}

}
