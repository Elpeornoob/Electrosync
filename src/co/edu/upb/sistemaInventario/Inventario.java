package co.edu.upb.sistemaInventario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.plaf.synth.SynthScrollPaneUI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
	
	public void generarInformeProductos() {
	    Workbook libro = new XSSFWorkbook();
	    final String nombreArchivo = "InformeProductos.xlsx";
	    Sheet hoja = libro.createSheet("Productos"); // Nombre de la hoja
	    Row primeraFila = hoja.createRow(0);

	    // Encabezados de las columnas
	    String[] encabezados = {"ID", "Nombre", "Código", "Stock", "Costo", "Precio Venta"};
	    CellStyle estiloNegritas = libro.createCellStyle();
	    Font fuenteNegritas = libro.createFont();
	    fuenteNegritas.setBold(true);
	    estiloNegritas.setFont(fuenteNegritas);

	    for (int i = 0; i < encabezados.length; i++) {
	        Cell celda = primeraFila.createCell(i);
	        celda.setCellValue(encabezados[i]);
	        celda.setCellStyle(estiloNegritas); // Aplicar el estilo en negritas a la celda
	    }
	    // Agregar datos de los productos a las filas
	    for (int i = 0; i < productos.size(); i++) {
	        Producto producto = productos.get(i);
	        Row fila = hoja.createRow(i + 1); // +1 para evitar sobrescribir la fila de encabezados
	        Cell celdaId = fila.createCell(0);
	        celdaId.setCellValue(producto.getIdProducto());
	        Cell celdaNombre = fila.createCell(1);
	        celdaNombre.setCellValue(producto.getNombreProducto());
	        Cell celdaCodigo = fila.createCell(2);
	        celdaCodigo.setCellValue(producto.getIdProducto());
	        Cell celdaStock = fila.createCell(3);
	        celdaStock.setCellValue(producto.getStockProducto());
	        Cell celdaCosto = fila.createCell(4);
	        celdaCosto.setCellValue(producto.getCostoProducto());
	        Cell celdaPrecioVenta = fila.createCell(5);
	        celdaPrecioVenta.setCellValue(producto.getPrecioProducto());
	    }

	    File directorioActual = new File(".");
	    String ubicacion = directorioActual.getAbsolutePath();
	    String ubicacionArchivoSalida = ubicacion.substring(0, ubicacion.length() - 1) + nombreArchivo;
	    FileOutputStream outputStream;

	    try {
	        outputStream = new FileOutputStream(ubicacionArchivoSalida);
	        libro.write(outputStream);
	        libro.close();
	        System.out.println("Informe de productos guardado correctamente en " + ubicacionArchivoSalida);
	    } catch (FileNotFoundException ex) {
	        System.out.println("Error de FileNotFoundException: " + ex.getMessage());
	    } catch (Exception e) {
	        System.out.println("Error Exception e: " + e.getMessage());
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
