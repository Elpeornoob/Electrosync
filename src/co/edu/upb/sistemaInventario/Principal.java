package co.edu.upb.sistemaInventario;

import java.awt.JobAttributes;
import java.util.ArrayList; 
import java.util.Date;
import javax.swing.JOptionPane;

//Pendiente en linea 427



public class Principal {

	public static void main(String[] args) {
		 // Crear un inventario y agregar algunos productos
		 Inventario inventario = new Inventario();
		 
		 //Crear un registro de ventas y agregar algunas ventas
		 RegistroVentas registroVentas = new RegistroVentas();
		 
		 //Craar lista usuarios
		 ListaDeUsuarios usuariosEnElSistema = new ListaDeUsuarios();
		 
		 //Crear algunos Usuarios
		 ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		 Usuario vendedor = new Usuario("Panchi", "Panchito123", TipoUsuario.VENDEDOR);
		 usuarios.add(vendedor);
		 Usuario encaargadoInv =  new Usuario("Andres", "Inventario32", TipoUsuario.ENCARGADO_DE_INVENTARIO);
		 usuarios.add(encaargadoInv);
		 Usuario gerente =  new Usuario("Carlos", "gerencia10", TipoUsuario.GERENTE);
		 usuarios.add(gerente);
		 usuariosEnElSistema.agregarUsuarios(usuarios);
		 
		//Menu Inicio de Sesion
		int condicion00 = 1;
		 while(condicion00 == 1) {
			 
			 String opciones00[] = {"Vendedor", "Encargado de Inventario", "Gerente", "Cerrar Sesión"};
				int opcionMenu00;
				opcionMenu00 = JOptionPane.showOptionDialog(
					null, 
					"Seleccione el tipo de Usuario: ", 
					"Menu de opciones", 
					JOptionPane.DEFAULT_OPTION,
		    		JOptionPane.QUESTION_MESSAGE, 
					null, 
					opciones00, 
					opciones00[0]
					);
			 
			switch(opcionMenu00) {
				case 0:{
					String passwordVendedor = JOptionPane.showInputDialog("Ingrese su contraseña: ");
					if(passwordVendedor == null) {
						break;
					}
					boolean correcta  = false;
					ArrayList<Usuario> usuariosVendedores = new ArrayList<Usuario>();
					for (int ii = 0; ii < usuarios.size();ii++) {
						if(passwordVendedor == null) {
							break;
						}
						if(usuarios.get(ii).getTipoDeUsuario().equals(TipoUsuario.VENDEDOR)) {
							usuariosVendedores.add(usuarios.get(ii));
						}
					}
					for (int jj = 0; jj < usuariosVendedores.size(); jj++) {
						if(usuariosVendedores.get(jj).getContraseña().equals(passwordVendedor)) {
							correcta = true;
							JOptionPane.showMessageDialog(null, "Inicio de sesion exitoso");
							
							//Menu Vendedor
							int condicion0 = 1;
							while(condicion0 == 1) {
								
								String opciones0[] = {"1. Buscar Producto", "2. Ventas", "3. Consultar Productos" , "4. Salir"};
								int opcionMenu0;
								
								opcionMenu0 = JOptionPane.showOptionDialog(
										null, 
										"Seleccione una Opcion: ", 
										"Menu Opciones", 
										JOptionPane.DEFAULT_OPTION,
							    		JOptionPane.QUESTION_MESSAGE, 
										null, 
										opciones0, 
										opciones0[0]);
								
								switch(opcionMenu0) {
									
									case 0:{
										
										//Menu Buscar producto por nombre o ID
										int condicion1 = 1;
										while (condicion1 == 1){
										
										String opciones[] = {"1. Buscar producto por nombre" , "2. Buscar producto por ID" , "3. Salir"};
										int opcionMenu;
										opcionMenu = JOptionPane.showOptionDialog(
											null, 
											"Seleccione una opcion: ", 
											"Menu de opciones", 
											JOptionPane.DEFAULT_OPTION,
								    		JOptionPane.QUESTION_MESSAGE, 
											null, 
											opciones, 
											opciones[0]
											);
					
										switch(opcionMenu){
											case 0:{
											String nombreDelProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto: ");
												
												Producto productoEncontrado = inventario.buscarProductoPorNombre(nombreDelProducto);
												if(productoEncontrado != null){
													JOptionPane.showMessageDialog(
													null, 
													"Nombre: " + productoEncontrado.getNombreProducto() + "\n" +
													"Codigo: " + productoEncontrado.getIdProducto() + "\n" +
													"Cantidades: " + productoEncontrado.getStockProducto() + "\n" +
													"Precio: " + String.format("%.0f", productoEncontrado.getPrecioProducto())
													);
													break;
												}
												else{
													JOptionPane.showMessageDialog(null, "Producto no encontrado");
													break;
												}
											}
											case 1:{
											String codigoDelProducto = JOptionPane.showInputDialog("Ingrese el codigo del producto:");
											
												Producto productoEncontrado = inventario.buscarProductoPorId(codigoDelProducto);
												if(productoEncontrado != null){
													JOptionPane.showMessageDialog(
													null, 
													"Nombre: " + productoEncontrado.getNombreProducto() + "\n" +
													"Codigo: " + productoEncontrado.getIdProducto() + "\n" +
													"Cantidades: " + productoEncontrado.getStockProducto() + "\n" +
													"Precio: " + String.format("%.0f", productoEncontrado.getPrecioProducto())
													);
													break;
												}
												else{
													JOptionPane.showMessageDialog(null, "Producto no encontrado");
													break;
												}
											}
											case 2:{
												condicion1 = 0;
											}
										}
					
									}
									break;
									}
								
									case 1:{
										
										int condicion2 = 1;
										while (condicion2 == 1){
										
										String opciones[] = {"1. Registrar una venta" , "2. Generar Informe de Ventas" , "3. Registrar varias ventas" , "4. Salir"};
										int opcionMenu1;
										opcionMenu1 = JOptionPane.showOptionDialog(
											null, 
											"Seleccione una opcion: ", 
											"Menu de opciones", 
											JOptionPane.DEFAULT_OPTION,
								    		JOptionPane.QUESTION_MESSAGE, 
											null, 
											opciones, 
											opciones[0]
											);
					
											switch(opcionMenu1){
					
												case 0:{
													int conditional = 1;
													Producto productoEncontrado;
													Venta ventaTemp;
													int iCantidadVendida = 0;
													while(conditional == 1) {
														String opciones1[] = {"1. Buscar producto por nombre" , "2. Buscar producto por ID" , "3. Salir"};
														int opcionMenu;
														opcionMenu = JOptionPane.showOptionDialog(
																null, 
																"Seleccione una opcion: ", 
																"Menu de opciones", 
																JOptionPane.DEFAULT_OPTION,
																JOptionPane.QUESTION_MESSAGE, 
																null, 
																opciones1, 
																opciones1[0]
																);
														switch (opcionMenu) {
														case 0: {
															String nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto: ");
															productoEncontrado =  inventario.buscarProductoPorNombre(nombreProducto);
															if(productoEncontrado != null) {
																
															}else {
																JOptionPane.showMessageDialog(null, "Producto no encontrado");
																break;
															}
															String sCantidadVendida = JOptionPane.showInputDialog("Ingrese la cantidad del producto vendido: ");
															if(Integer.parseInt(sCantidadVendida) > 0) {
																iCantidadVendida = Integer.parseInt(sCantidadVendida);
																if(iCantidadVendida <= productoEncontrado.getStockProducto()) {
																	
																}else {
																	JOptionPane.showMessageDialog(null, "No alcanza el stock, hay " + productoEncontrado.getStockProducto() + " cantidades del producto");
																	break;
																}
															}else {
																break;
															}
															String nombreCliente = JOptionPane.showInputDialog("Ingresar nombre del cliente: ");
															String direccionCliente = JOptionPane.showInputDialog("Ingrese la direccion del cliente: ");
															String numeroTelefonoCliente = JOptionPane.showInputDialog("Ingrese el numero de telefono del cliente: ");
															String emailCliente = JOptionPane.showInputDialog("Ingrese el E-Mail del cliente: ");
															TipoDocumento tipoDocumentoCliente = null;
															String opciones3[] = {"Cedula de Ciudadanía", "Cedula de Extranjería", "Tarjeta de identidad", "Carné de identidad", "Documento nacional de identidad"};
															int opcionMenu2;
															opcionMenu2 = JOptionPane.showOptionDialog(
																null, 
																"Seleccione una opcion: ", 
																"Menu de opciones", 
																JOptionPane.DEFAULT_OPTION,
													    		JOptionPane.QUESTION_MESSAGE, 
																null, 
																opciones3, 
																opciones3[0]
																);
															switch(opcionMenu2) {
																
																case 0:{
																	tipoDocumentoCliente = TipoDocumento.CEDULA_DE_CIUDADANIA;
																	break;
																}
																case 1:{
																	tipoDocumentoCliente = TipoDocumento.CEDULA_DE_EXTRANJERIA;
																	break;
																}
																case 2:{
																	tipoDocumentoCliente = TipoDocumento.TARJETA_DE_IDENTIDAD;
																	break;
																}
																case 3:{
																	tipoDocumentoCliente = TipoDocumento.CARNÉ_DE_IDENTIDAD;
																	break;
																}
																case 4:{
																	tipoDocumentoCliente = TipoDocumento.DOCUMENTO_NACIONAL_DE_IDENTIDAD;
																	break;
																}
															}
															String numeroDocumentoCliente = JOptionPane.showInputDialog("Ingrese el numero de documento del cliente: ");
															Cliente clienteAVender = new Cliente(nombreCliente, direccionCliente, tipoDocumentoCliente, numeroDocumentoCliente, numeroTelefonoCliente, emailCliente);
															ventaTemp = new Venta(productoEncontrado, iCantidadVendida);
															registroVentas.registrarVentaUnica(ventaTemp, clienteAVender);
															inventario.eliminarCantidadDeProducto(productoEncontrado, iCantidadVendida);
															
					
															break;
														}
														case 1:{
															String codigoDelProducto = JOptionPane.showInputDialog("Ingrese el codigo del producto: ");
															productoEncontrado = inventario.buscarProductoPorId(codigoDelProducto);	
															if(productoEncontrado != null) {
																
															}else {
																JOptionPane.showMessageDialog(null, "Producto no encontrado");
																break;
															}
															String sCantidadVendida = JOptionPane.showInputDialog("Ingrese la cantidad del producto vendido: ");
															if(Integer.parseInt(sCantidadVendida) > 0) {
																iCantidadVendida = Integer.parseInt(sCantidadVendida);
																if(iCantidadVendida <= productoEncontrado.getStockProducto()) {
																	
																}else {
																	JOptionPane.showMessageDialog(null, "No alcanza el stock, hay " + productoEncontrado.getStockProducto() + " cantidades del producto");
																	break;
																}
															}else {
																break;
															}
															String nombreCliente = JOptionPane.showInputDialog("Ingresar nombre del cliente: ");
															String direccionCliente = JOptionPane.showInputDialog("Ingrese la direccion del cliente: ");
															String numeroTelefonoCliente = JOptionPane.showInputDialog("Ingrese el numero de telefono del cliente: ");
															String emailCliente = JOptionPane.showInputDialog("Ingrese el E-Mail del cliente: ");
															TipoDocumento tipoDocumentoCliente = null;
															String opciones3[] = {"Cedula de Ciudadanía", "Cedula de Extranjería", "Tarjeta de identidad", "Carné de identidad", "Documento nacional de identidad"};
															int opcionMenu2;
															opcionMenu2 = JOptionPane.showOptionDialog(
																null, 
																"Seleccione una opcion: ", 
																"Menu de opciones", 
																JOptionPane.DEFAULT_OPTION,
													    		JOptionPane.QUESTION_MESSAGE, 
																null, 
																opciones3, 
																opciones3[0]
																);
															switch(opcionMenu2) {
																
																case 0:{
																	tipoDocumentoCliente = TipoDocumento.CEDULA_DE_CIUDADANIA;
																	break;
																}
																case 1:{
																	tipoDocumentoCliente = TipoDocumento.CEDULA_DE_EXTRANJERIA;
																	break;
																}
																case 2:{
																	tipoDocumentoCliente = TipoDocumento.TARJETA_DE_IDENTIDAD;
																	break;
																}
																case 3:{
																	tipoDocumentoCliente = TipoDocumento.CARNÉ_DE_IDENTIDAD;
																	break;
																}
																case 4:{
																	tipoDocumentoCliente = TipoDocumento.DOCUMENTO_NACIONAL_DE_IDENTIDAD;
																	break;
																}
															}
															String numeroDocumentoCliente = JOptionPane.showInputDialog("Ingrese el numero de documento del cliente: ");
															Cliente clienteAVender = new Cliente(nombreCliente, direccionCliente, tipoDocumentoCliente, numeroDocumentoCliente, numeroTelefonoCliente, emailCliente);
															ventaTemp = new Venta(productoEncontrado, iCantidadVendida);
															registroVentas.registrarVentaUnica(ventaTemp, clienteAVender);
															inventario.eliminarCantidadDeProducto(productoEncontrado, iCantidadVendida);
					
															break;
														}
														case  2:{
															conditional = 1;
														}
														
														default:{
															JOptionPane.showMessageDialog(null, "Invalido");
														}
														
														}
														break;
													}
													break;
												}
					
												case 1:{
													registroVentas.generarInformeVentas();
						                            break;
												}
												
												case 2:{
													Cliente clienteAVender = null;
													boolean seguiRegistrandoVentas = true;
													int conditional = 1;
													Producto productoEncontrado;
													ArrayList<Venta> ventasTemp = new ArrayList<Venta>();
													int iCantidadVendida = 0;
													while(seguiRegistrandoVentas) {
														while(conditional == 1) {
															String opciones1[] = {"1. Buscar producto por nombre" , "2. Buscar producto por ID" , "3. Cerrar Factura", "4. Salir"};
															int opcionMenu;
															opcionMenu = JOptionPane.showOptionDialog(
																	null, 
																	"Seleccione una opcion: ", 
																	"Menu de opciones", 
																	JOptionPane.DEFAULT_OPTION,
																	JOptionPane.QUESTION_MESSAGE, 
																	null, 
																	opciones1, 
																	opciones1[0]
																	);
																
															switch(opcionMenu) {
																case 0:{
																	Venta ventaTemp;
																	String nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto: ");
																	productoEncontrado =  inventario.buscarProductoPorNombre(nombreProducto);
																	if(productoEncontrado != null) {
																		
																	}else {
																		JOptionPane.showMessageDialog(null, "Producto no encontrado");
																		break;
																	}
																	String sCantidadVendida = JOptionPane.showInputDialog("Ingrese la cantidad del producto vendido: ");
																	if(Integer.parseInt(sCantidadVendida) > 0) {
																		iCantidadVendida = Integer.parseInt(sCantidadVendida);
																		if(iCantidadVendida <= productoEncontrado.getStockProducto()) {
																			
																		}else {
																			JOptionPane.showMessageDialog(null, "No alcanza el stock, hay " + productoEncontrado.getStockProducto() + " cantidades del producto");
																			break;
																		}
																	}else {
																		break;
																	}
																	ventaTemp = new Venta(productoEncontrado, iCantidadVendida);
																	ventasTemp.add(ventaTemp);
																	break;
																}
																
																case 1:{
																	Venta ventaTemp;
																	String idProdcuto = JOptionPane.showInputDialog("Ingrese el nombre del producto: ");
																	productoEncontrado =  inventario.buscarProductoPorId(idProdcuto);
																	if(productoEncontrado != null) {
																		
																	}else {
																		JOptionPane.showMessageDialog(null, "Producto no encontrado");
																		break;
																	}
																	String sCantidadVendida = JOptionPane.showInputDialog("Ingrese la cantidad del producto vendido: ");
																	if(Integer.parseInt(sCantidadVendida) > 0) {
																		iCantidadVendida = Integer.parseInt(sCantidadVendida);
																		if(iCantidadVendida <= productoEncontrado.getStockProducto()) {
																			
																		}else {
																			JOptionPane.showMessageDialog(null, "No alcanza el stock, hay " + productoEncontrado.getStockProducto() + " cantidades del producto");
																			break;
																		}
																	}else {
																		break;
																	}
																	ventaTemp = new Venta(productoEncontrado, iCantidadVendida);
																	ventasTemp.add(ventaTemp);
																	break;
																}
																
																case 2:{
																	String nombreCliente = JOptionPane.showInputDialog("Ingresar nombre del cliente: ");
																	String direccionCliente = JOptionPane.showInputDialog("Ingrese la direccion del cliente: ");
																	String numeroTelefonoCliente = JOptionPane.showInputDialog("Ingrese el numero de telefono del cliente: ");
																	String emailCliente = JOptionPane.showInputDialog("Ingrese el E-Mail del cliente: ");
																	TipoDocumento tipoDocumentoCliente = null;
																	String opciones3[] = {"Cedula de Ciudadanía", "Cedula de Extranjería", "Tarjeta de identidad", "Carné de identidad", "Documento nacional de identidad"};
																	int opcionMenu2;
																	opcionMenu2 = JOptionPane.showOptionDialog(
																		null, 
																		"Seleccione una opcion: ", 
																		"Menu de opciones", 
																		JOptionPane.DEFAULT_OPTION,
															    		JOptionPane.QUESTION_MESSAGE, 
																		null, 
																		opciones3, 
																		opciones3[0]
																		);
																	switch(opcionMenu2) {
																		
																		case 0:{
																			tipoDocumentoCliente = TipoDocumento.CEDULA_DE_CIUDADANIA;
																			break;
																		}
																		case 1:{
																			tipoDocumentoCliente = TipoDocumento.CEDULA_DE_EXTRANJERIA;
																			break;
																		}
																		case 2:{
																			tipoDocumentoCliente = TipoDocumento.TARJETA_DE_IDENTIDAD;
																			break;
																		}
																		case 3:{
																			tipoDocumentoCliente = TipoDocumento.CARNÉ_DE_IDENTIDAD;
																			break;
																		}
																		case 4:{
																			tipoDocumentoCliente = TipoDocumento.DOCUMENTO_NACIONAL_DE_IDENTIDAD;
																			break;
																		}
																	}
																	String numeroDocumentoCliente = JOptionPane.showInputDialog("Ingrese el numero de documento del cliente: ");
																	clienteAVender = new Cliente(nombreCliente, direccionCliente, tipoDocumentoCliente, numeroDocumentoCliente, numeroTelefonoCliente, emailCliente);
																	registroVentas.registrarVentasMultiples(ventasTemp, clienteAVender);
																	seguiRegistrandoVentas = false;
																	conditional = 0;
																	break;
																}
																
																case 3:{
																	seguiRegistrandoVentas = false;
																	conditional = 0;
																	break;
																}
															}
														}
														
													}// While Agregar ventas
													break;
												}
					
												case 3:{
													condicion2 = 0;
													break;
												}
												
												default:{
													JOptionPane.showMessageDialog(null, "Invalido");
												}
					
											}
											
										}
										break;
									}
									
									case 2:{
										//Pendiente
										break;
									}
									
									case 3:{
										condicion0 = 0;
										break;
									}
									
								}
								
							}
							
						}else {
							
						}
				}
					if(correcta == false) {
						JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
					}
					break;
				}
				case 1:{
					
					String passwordEncargado = JOptionPane.showInputDialog("Ingrese su contraseña: ");
					if(passwordEncargado == null) {
						break;
					}
					boolean correcta  = false;
					ArrayList<Usuario> usuariosEncargado = new ArrayList<Usuario>();
					for (int ii = 0; ii < usuarios.size();ii++) {
						if(usuarios.get(ii).getTipoDeUsuario().equals(TipoUsuario.ENCARGADO_DE_INVENTARIO)) {
							usuariosEncargado.add(usuarios.get(ii));
						}
					}
					for (int jj = 0; jj < usuariosEncargado.size(); jj++) {
						if(usuariosEncargado.get(jj).getContraseña().equals(passwordEncargado)) {
							correcta = true;
							JOptionPane.showMessageDialog(null, "Inicio de sesion exitoso");
							
							int condicion0 = 1;
							while(condicion0 == 1) {
								
								String opciones0[] = {"1. Agregar Producto" , "2. Eliminar Productos" ,"3. Buscar Producto", "4. Informe Productos" , "4. Salir"};
								int opcionMenu0;
								
								opcionMenu0 = JOptionPane.showOptionDialog(
										null, 
										"Seleccione una Opcion: ", 
										"Menu Opciones", 
										JOptionPane.DEFAULT_OPTION,
							    		JOptionPane.QUESTION_MESSAGE, 
										null, 
										opciones0, 
										opciones0[0]);
								
								switch(opcionMenu0) {
									
									case 0:{
										inventario.agregarProducto();
										break;
									}
									case 1:{
										
										int condicion1 = 1;
										while (condicion1 == 1){
										
										String opciones[] = {"1. Buscar producto por nombre" , "2. Buscar producto por ID" , "3. Salir"};
										int opcionMenu;
										opcionMenu = JOptionPane.showOptionDialog(
											null, 
											"Seleccione una opcion: ", 
											"Menu de opciones", 
											JOptionPane.DEFAULT_OPTION,
								    		JOptionPane.QUESTION_MESSAGE, 
											null, 
											opciones, 
											opciones[0]
											);
					
										switch(opcionMenu){
											case 0:{
												String nombreDelProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto: ");
												Producto productoEncontrado = inventario.buscarProductoPorNombre(nombreDelProducto);
												if(productoEncontrado == null) {
													JOptionPane.showMessageDialog(null, "Producto no encontrado");
													break;
												}
												int cantidadAEliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad a eliminar: "));
												if(cantidadAEliminar < 0) {
													break;
												}if(cantidadAEliminar > productoEncontrado.getStockProducto()) {
													JOptionPane.showMessageDialog(null, "Stock insuficiente");
													break;
												}
												inventario.eliminarCantidadDeProducto(productoEncontrado, cantidadAEliminar);
											}
											case 1:{
												String codigoDelProducto = JOptionPane.showInputDialog("Ingrese el codigo del producto: ");
												Producto productoEncontrado = inventario.buscarProductoPorId(codigoDelProducto);
												if(productoEncontrado == null) {
													JOptionPane.showMessageDialog(null, "Producto no encontrado");
													break;
												}
												int cantidadAEliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad a eliminar: "));
												if(cantidadAEliminar < 0) {
													break;
												}if(cantidadAEliminar > productoEncontrado.getStockProducto()) {
													JOptionPane.showMessageDialog(null, "Stock insuficiente");
													break;
												}
												inventario.eliminarCantidadDeProducto(productoEncontrado, cantidadAEliminar);
												}
											case 2:{
												condicion1 = 0;
											}
										}
					
									}
										
									}
									case 2:{
										
										int condicion1 = 1;
										while (condicion1 == 1){
										
										String opciones[] = {"1. Buscar producto por nombre" , "2. Buscar producto por ID" , "3. Salir"};
										int opcionMenu;
										opcionMenu = JOptionPane.showOptionDialog(
											null, 
											"Seleccione una opcion: ", 
											"Menu de opciones", 
											JOptionPane.DEFAULT_OPTION,
								    		JOptionPane.QUESTION_MESSAGE, 
											null, 
											opciones, 
											opciones[0]
											);
					
										switch(opcionMenu){
											case 0:{
											String nombreDelProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto: ");
												
												Producto productoEncontrado = inventario.buscarProductoPorNombre(nombreDelProducto);
												if(productoEncontrado != null){
													JOptionPane.showMessageDialog(
													null, 
													"Nombre: " + productoEncontrado.getNombreProducto() + "\n" +
													"Codigo: " + productoEncontrado.getIdProducto() + "\n" +
													"Cantidades: " + productoEncontrado.getStockProducto() + "\n" +
													"Precio: " + String.format("%.0f", productoEncontrado.getPrecioProducto())
													);
													break;
												}
												else{
													JOptionPane.showMessageDialog(null, "Producto no encontrado");
													break;
												}
											}
											case 1:{
											String codigoDelProducto = JOptionPane.showInputDialog("Ingrese el codigo del producto:");
											
												Producto productoEncontrado = inventario.buscarProductoPorId(codigoDelProducto);
												if(productoEncontrado != null){
													JOptionPane.showMessageDialog(
													null, 
													"Nombre: " + productoEncontrado.getNombreProducto() + "\n" +
													"Codigo: " + productoEncontrado.getIdProducto() + "\n" +
													"Cantidades: " + productoEncontrado.getStockProducto() + "\n" +
													"Precio: " + String.format("%.0f", productoEncontrado.getPrecioProducto())
													);
													break;
												}
												else{
													JOptionPane.showMessageDialog(null, "Producto no encontrado");
													break;
												}
											}
											case 2:{
												condicion1 = 0;
											}
										}
					
									}
									break;
									}
									
									case 3:{
										inventario.generarInformeProductos();
										break;
									}
									
									case 4:{
										condicion0 = 0;
										break;
									}
									
								}
								
							}
					
						}else {
						}
					}
					if(correcta == false) {
						JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
					}
					break;
					
				}
				case 2:{
					
					String passwordGerente = JOptionPane.showInputDialog("Ingrese su contraseña: ");
					if(passwordGerente == null) {
						break;
					}
					boolean correcta  = false;
					ArrayList<Usuario> usuariosGerente = new ArrayList<Usuario>();
					for (int ii = 0; ii < usuarios.size();ii++) {
						if(usuarios.get(ii).getTipoDeUsuario().equals(TipoUsuario.GERENTE)) {
							usuariosGerente.add(usuarios.get(ii));
						}
					}
					for (int jj = 0; jj < usuariosGerente.size(); jj++) {
						if(usuariosGerente.get(jj).getContraseña().equals(passwordGerente)) {
							correcta = true;
							JOptionPane.showMessageDialog(null, "Inicio de sesion exitoso");
							
							int condicion0 = 1;
							while(condicion0 == 1) {
								
								String opciones0[] = {"1. Agregar Producto" ,"2. Buscar Producto", "3. Ventas", "4. Agregar Usuario" , "5. Ver Usuarios" , "6. Salir"};
								int opcionMenu0;
								
								opcionMenu0 = JOptionPane.showOptionDialog(
										null, 
										"Seleccione una Opcion: ", 
										"Menu Opciones", 
										JOptionPane.DEFAULT_OPTION,
							    		JOptionPane.QUESTION_MESSAGE, 
										null, 
										opciones0, 
										opciones0[0]);
								
								switch(opcionMenu0) {
									
									case 0:{
										inventario.agregarProducto();
										break;
									}
									case 1:{
										
										int condicion1 = 1;
										while (condicion1 == 1){
										
										String opciones[] = {"1. Buscar producto por nombre" , "2. Buscar producto por ID" , "3. Salir"};
										int opcionMenu;
										opcionMenu = JOptionPane.showOptionDialog(
											null, 
											"Seleccione una opcion: ", 
											"Menu de opciones", 
											JOptionPane.DEFAULT_OPTION,
								    		JOptionPane.QUESTION_MESSAGE, 
											null, 
											opciones, 
											opciones[0]
											);
					
										switch(opcionMenu){
											case 0:{
											String nombreDelProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto: ");
												
												Producto productoEncontrado = inventario.buscarProductoPorNombre(nombreDelProducto);
												if(productoEncontrado != null){
													JOptionPane.showMessageDialog(
													null, 
													"Nombre: " + productoEncontrado.getNombreProducto() + "\n" +
													"Codigo: " + productoEncontrado.getIdProducto() + "\n" +
													"Cantidades: " + productoEncontrado.getStockProducto() + "\n" +
													"Precio: " + String.format("%.0f", productoEncontrado.getPrecioProducto())
													);
													break;
												}
												else{
													JOptionPane.showMessageDialog(null, "Producto no encontrado");
													break;
												}
											}
											case 1:{
											String codigoDelProducto = JOptionPane.showInputDialog("Ingrese el codigo del producto:");
											
												Producto productoEncontrado = inventario.buscarProductoPorId(codigoDelProducto);
												if(productoEncontrado != null){
													JOptionPane.showMessageDialog(
													null, 
													"Nombre: " + productoEncontrado.getNombreProducto() + "\n" +
													"Codigo: " + productoEncontrado.getIdProducto() + "\n" +
													"Cantidades: " + productoEncontrado.getStockProducto() + "\n" +
													"Precio: " + String.format("%.0f", productoEncontrado.getPrecioProducto())
													);
													break;
												}
												else{
													JOptionPane.showMessageDialog(null, "Producto no encontrado");
													break;
												}
											}
											case 2:{
												condicion1 = 0;
											}
											default:{
												break;
											}
										}
					
									}
									break;
									}
								
									case 2:{
										
										int condicion2 = 1;
										while (condicion2 == 1){
										
										String opciones[] = {"1. Registrar una venta" , "2. Generar Informe de Ventas" , "3. Salir"};
										int opcionMenu1;
										opcionMenu1 = JOptionPane.showOptionDialog(
											null, 
											"Seleccione una opcion: ", 
											"Menu de opciones", 
											JOptionPane.DEFAULT_OPTION,
								    		JOptionPane.QUESTION_MESSAGE, 
											null, 
											opciones, 
											opciones[0]
											);
					
											switch(opcionMenu1){
					
												case 0:{
													int conditional = 1;
													Producto productoEncontrado;
													Venta ventaTemp;
													int iCantidadVendida = 0;
													while(conditional == 1) {
														String opciones1[] = {"1. Buscar producto por nombre" , "2. Buscar producto por ID" , "3. Salir"};
														int opcionMenu;
														opcionMenu = JOptionPane.showOptionDialog(
																null, 
																"Seleccione una opcion: ", 
																"Menu de opciones", 
																JOptionPane.DEFAULT_OPTION,
																JOptionPane.QUESTION_MESSAGE, 
																null, 
																opciones1, 
																opciones1[0]
																);
														switch (opcionMenu) {
														case 0: {
															String nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto: ");
															productoEncontrado =  inventario.buscarProductoPorNombre(nombreProducto);
															if(productoEncontrado != null) {
																
															}else {
																JOptionPane.showMessageDialog(null, "Producto no encontrado");
																break;
															}
															String sCantidadVendida = JOptionPane.showInputDialog("Ingrese la cantidad del producto vendido: ");
															if(Integer.parseInt(sCantidadVendida) > 0) {
																iCantidadVendida = Integer.parseInt(sCantidadVendida);
																if(iCantidadVendida <= productoEncontrado.getStockProducto()) {
																	
																}else {
																	JOptionPane.showMessageDialog(null, "No alcanza el stock, hay " + productoEncontrado.getStockProducto() + " cantidades del producto");
																	break;
																}
															}else {
																break;
															}
															String nombreCliente = JOptionPane.showInputDialog("Ingresar nombre del cliente: ");
															String direccionCliente = JOptionPane.showInputDialog("Ingrese la direccion del cliente: ");
															String numeroTelefonoCliente = JOptionPane.showInputDialog("Ingrese el numero de telefono del cliente: ");
															String emailCliente = JOptionPane.showInputDialog("Ingrese el E-Mail del cliente: ");
															TipoDocumento tipoDocumentoCliente = null;
															String opciones3[] = {"Cedula de Ciudadanía", "Cedula de Extranjería", "Tarjeta de identidad", "Carné de identidad", "Documento nacional de identidad"};
															int opcionMenu2;
															opcionMenu2 = JOptionPane.showOptionDialog(
																null, 
																"Seleccione una opcion: ", 
																"Menu de opciones", 
																JOptionPane.DEFAULT_OPTION,
													    		JOptionPane.QUESTION_MESSAGE, 
																null, 
																opciones3, 
																opciones3[0]
																);
															switch(opcionMenu2) {
																
																case 0:{
																	tipoDocumentoCliente = TipoDocumento.CEDULA_DE_CIUDADANIA;
																	break;
																}
																case 1:{
																	tipoDocumentoCliente = TipoDocumento.CEDULA_DE_EXTRANJERIA;
																	break;
																}
																case 2:{
																	tipoDocumentoCliente = TipoDocumento.TARJETA_DE_IDENTIDAD;
																	break;
																}
																case 3:{
																	tipoDocumentoCliente = TipoDocumento.CARNÉ_DE_IDENTIDAD;
																	break;
																}
																case 4:{
																	tipoDocumentoCliente = TipoDocumento.DOCUMENTO_NACIONAL_DE_IDENTIDAD;
																	break;
																}
																default:{
																	break;
																}
															}
															String numeroDocumentoCliente = JOptionPane.showInputDialog("Ingrese el numero de documento del cliente: ");
															Cliente clienteAVender = new Cliente(nombreCliente, direccionCliente, tipoDocumentoCliente, numeroDocumentoCliente, numeroTelefonoCliente, emailCliente);
															ventaTemp = new Venta(productoEncontrado, iCantidadVendida);
															registroVentas.registrarVentaUnica(ventaTemp, clienteAVender);
															inventario.eliminarCantidadDeProducto(productoEncontrado, iCantidadVendida);
					
															break;
														}
														case 1:{
															String codigoDelProducto = JOptionPane.showInputDialog("Ingrese el codigo del producto: ");
															productoEncontrado = inventario.buscarProductoPorId(codigoDelProducto);	
															if(productoEncontrado != null) {
																
															}else {
																JOptionPane.showMessageDialog(null, "Producto no encontrado");
																break;
															}
															String sCantidadVendida = JOptionPane.showInputDialog("Ingrese la cantidad del producto vendido: ");
															if(Integer.parseInt(sCantidadVendida) > 0) {
																iCantidadVendida = Integer.parseInt(sCantidadVendida);
																if(iCantidadVendida <= productoEncontrado.getStockProducto()) {
																	
																}else {
																	JOptionPane.showMessageDialog(null, "No alcanza el stock, hay " + productoEncontrado.getStockProducto() + " cantidades del producto");
																	break;
																}
															}else {
																break;
															}
															String nombreCliente = JOptionPane.showInputDialog("Ingresar nombre del cliente: ");
															String direccionCliente = JOptionPane.showInputDialog("Ingrese la direccion del cliente: ");
															String numeroTelefonoCliente = JOptionPane.showInputDialog("Ingrese el numero de telefono del cliente: ");
															String emailCliente = JOptionPane.showInputDialog("Ingrese el E-Mail del cliente: ");
															TipoDocumento tipoDocumentoCliente = null;
															String opciones3[] = {"Cedula de Ciudadanía", "Cedula de Extranjería", "Tarjeta de identidad", "Carné de identidad", "Documento nacional de identidad"};
															int opcionMenu2;
															opcionMenu2 = JOptionPane.showOptionDialog(
																null, 
																"Seleccione una opcion: ", 
																"Menu de opciones", 
																JOptionPane.DEFAULT_OPTION,
													    		JOptionPane.QUESTION_MESSAGE, 
																null, 
																opciones3, 
																opciones3[0]
																);
															switch(opcionMenu2) {
																
																case 0:{
																	tipoDocumentoCliente = TipoDocumento.CEDULA_DE_CIUDADANIA;
																	break;
																}
																case 1:{
																	tipoDocumentoCliente = TipoDocumento.CEDULA_DE_EXTRANJERIA;
																	break;
																}
																case 2:{
																	tipoDocumentoCliente = TipoDocumento.TARJETA_DE_IDENTIDAD;
																	break;
																}
																case 3:{
																	tipoDocumentoCliente = TipoDocumento.CARNÉ_DE_IDENTIDAD;
																	break;
																}
																case 4:{
																	tipoDocumentoCliente = TipoDocumento.DOCUMENTO_NACIONAL_DE_IDENTIDAD;
																	break;
																}
																default:{
																	break;
																}
															}
															String numeroDocumentoCliente = JOptionPane.showInputDialog("Ingrese el numero de documento del cliente: ");
															Cliente clienteAVender = new Cliente(nombreCliente, direccionCliente, tipoDocumentoCliente, numeroDocumentoCliente, numeroTelefonoCliente, emailCliente);
															ventaTemp = new Venta(productoEncontrado, iCantidadVendida);
															registroVentas.registrarVentaUnica(ventaTemp, clienteAVender);
															inventario.eliminarCantidadDeProducto(productoEncontrado, iCantidadVendida);
					
															break;
														}
														case  2:{
															conditional = 1;
														}
														
														default:{
															break;
														}
														
														}
														break;
													}
													break;
												}
					
												case 1:{
													 registroVentas.generarInformeVentas();
						                                break;
												}
					
												case 2:{
													condicion2 = 0;
													break;
												}
												
												default:{
													break;
												}
					
											}
											
										}
										break;
									}
									
									case 3:{
										String nombre;
										String password;
										String confirmPassword;
										TipoUsuario tipo = null;
											
										nombre = JOptionPane.showInputDialog("Ingrese el nombre de la persona: ");
										if(nombre ==  null) {
											break;
										}
										
										String opcionesUsuarios[] = {"Vendedor", "Encargado de Inventario"};
										int opcionMenuUsuarios;
										opcionMenuUsuarios = JOptionPane.showOptionDialog(
											null, 
											"Seleccione un rol: ", 
											"Menu de opciones", 
											JOptionPane.DEFAULT_OPTION,
								    		JOptionPane.QUESTION_MESSAGE, 
											null, 
											opcionesUsuarios, 
											opcionesUsuarios[0]
											);
										switch(opcionMenuUsuarios) {
										
											case 0:{
												tipo = TipoUsuario.VENDEDOR;
												break;
											}
											case 1:{
												tipo = TipoUsuario.ENCARGADO_DE_INVENTARIO;
												break;
											}
											default:{
												break;
											}
										
										}
										
										password = JOptionPane.showInputDialog("Ingrese la contraseña del usuario: ");
										confirmPassword = JOptionPane.showInputDialog("Confirme la contraseña: ");
										if(password.equals(confirmPassword)) {
											JOptionPane.showMessageDialog(null, "Las contraseñas coinciden.");
										}else {
											JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
											break;
										}
										
										Usuario nuevoUsuario =  new Usuario(nombre, confirmPassword, tipo);
										usuarios.add(nuevoUsuario);
										break;
									}
									
									case 4:{
										usuariosEnElSistema.motrarUsuarios();
										break;
									}
									
									case 5:{
										condicion0 = 0;
										break;
									}
									
									default:{
										break;
									}
									
								}
								
							}
					
						}else {
						}
					}
					if(correcta == false) {
						JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
					}
					break;
				}
				case 3:{
					condicion00 = 0;
					System.exit(0);
					break;
				}
				default:
					System.exit(0);
					break;
		 	}
		}
	}

}
