package co.edu.upb.sistemaInventario;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		 // Crear un inventario y agregar algunos productos
		 Inventario inventario = new Inventario();
		 Producto computador1 = new Producto("Computador 1","1" , 10, 800000);
		 Producto celular2 = new Producto("Celular 2","2" , 5, 400000);
		 Producto tablet3 = new Producto("Tablet 3","3" , 15, 500000);
		 inventario.agregarProducto(computador1);
		 inventario.agregarProducto(celular2);
		 inventario.agregarProducto(tablet3);
		 inventario.agregarProducto(new Producto("Usb", "4", 14, 7000));
		
		 //Crear un registro de ventas y agregar algunas ventas
		 Cliente cliente1 = new Cliente("Bryan Gonzalo", "Cra 23 # 30-01", TipoDocumento.CARNÉ_DE_IDENTIDAD, "1096065198", "3204132543", "blizcanod12@gmail.com");
		 ArrayList<Venta> ventas = new ArrayList<>();
		 Venta venta1 = new Venta(new Date(2022, 3, 20, 14, 30, 57), computador1, 2, cliente1);
		 Venta venta2 = new Venta(new Date(2022, 3, 20, 14, 30, 57), celular2, 3, cliente1);
		 ventas.add(venta1);
		 ventas.add(venta2);
		 RegistroVentas registroVentas = new RegistroVentas(ventas);
		 
		 //Crear algunos Usuarios
		 
		 ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		 Usuario vendedor = new Usuario("Panchi", "Panchito123", TipoUsuario.VENDEDOR);
		 usuarios.add(vendedor);
		 Usuario encaargadoInv =  new Usuario("Andres", "Inventario32", TipoUsuario.ENCARGADO_DE_INVENTARIO);
		 usuarios.add(encaargadoInv);
		 Usuario gerente =  new Usuario("Carlos", "gerencia10", TipoUsuario.GERENTE);
		 usuarios.add(gerente);
		 
		
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
					boolean correcta  = false;
					ArrayList<Usuario> usuariosVendedores = new ArrayList<Usuario>();
					for (int ii = 0; ii < usuarios.size();ii++) {
						if(usuarios.get(ii).getTipoDeUsuario().equals(TipoUsuario.VENDEDOR)) {
							usuariosVendedores.add(usuarios.get(ii));
						}
					}
					for (int jj = 0; jj < usuariosVendedores.size(); jj++) {
						if(usuariosVendedores.get(jj).getContraseña().equals(passwordVendedor)) {
							correcta = true;
							JOptionPane.showMessageDialog(null, "Inicio de sesion exitoso");
							
							int condicion0 = 1;
							while(condicion0 == 1) {
								
								String opciones0[] = {"1. Buscar Producto", "3. Ventas", "4. Salir"};
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
													"Precio: " + productoEncontrado.getPrecioProducto()
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
													"Precio: " + productoEncontrado.getPrecioProducto()
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
															}
															String numeroDocumentoCliente = JOptionPane.showInputDialog("Ingrese el numero de documento del cliente: ");
															Cliente clienteAVender = new Cliente(nombreCliente, direccionCliente, tipoDocumentoCliente, numeroDocumentoCliente, numeroTelefonoCliente, emailCliente);
															ventaTemp = new Venta(new Date(), productoEncontrado, iCantidadVendida, clienteAVender);
															registroVentas.registrarVenta(ventaTemp);
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
															ventaTemp = new Venta(new Date(), productoEncontrado, iCantidadVendida, clienteAVender);
															registroVentas.registrarVenta(ventaTemp);
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
								
								String opciones0[] = {"1. Agregar Producto" ,"2. Buscar Producto", "3. Salir"};
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
													"Precio: " + productoEncontrado.getPrecioProducto()
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
													"Precio: " + productoEncontrado.getPrecioProducto()
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
									
									case 2:{
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
								
								String opciones0[] = {"1. Agregar Producto" ,"2. Buscar Producto", "3. Ventas", "4. Agregar Usuario" , "5. Salir"};
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
													"Precio: " + productoEncontrado.getPrecioProducto()
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
													"Precio: " + productoEncontrado.getPrecioProducto()
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
															}
															String numeroDocumentoCliente = JOptionPane.showInputDialog("Ingrese el numero de documento del cliente: ");
															Cliente clienteAVender = new Cliente(nombreCliente, direccionCliente, tipoDocumentoCliente, numeroDocumentoCliente, numeroTelefonoCliente, emailCliente);
															ventaTemp = new Venta(new Date(), productoEncontrado, iCantidadVendida, clienteAVender);
															registroVentas.registrarVenta(ventaTemp);
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
															ventaTemp = new Venta(new Date(), productoEncontrado, iCantidadVendida, clienteAVender);
															registroVentas.registrarVenta(ventaTemp);
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
				case 3:{
					condicion00 = 0;
					break;
				}
		 	}
		}
	}

}
