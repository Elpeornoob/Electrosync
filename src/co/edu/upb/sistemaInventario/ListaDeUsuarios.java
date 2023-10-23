package co.edu.upb.sistemaInventario;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ListaDeUsuarios {
	private ArrayList<Usuario> usuarios;
	
	public ListaDeUsuarios() {
		this.usuarios = new ArrayList<>();
	}
	
	public void motrarUsuarios() {
		for (int ii = 0; ii < usuarios.size(); ii++) {
			String nombreTemp = usuarios.get(ii).getNombre();
			String contraseñaTemp =  usuarios.get(ii).getContraseña();
			String tipoUsuarioTemp = usuarios.get(ii).tipoUsuario();
			JOptionPane.showMessageDialog(
					null,
					"Nombre: " + nombreTemp + "\n" +
					"Contraseña: " + contraseñaTemp + "\n" +
					"Tipo de Usuario: " + tipoUsuarioTemp + "\n"
					);
		}
	}
	
	public void agregarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public void agregarUsuarios(ArrayList usuarios) {
		for (int ii = 0; ii < usuarios.size(); ii++) {
			this.usuarios.add((Usuario) usuarios.get(ii));
		}
	}

}
