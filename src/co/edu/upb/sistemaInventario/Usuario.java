package co.edu.upb.sistemaInventario;

public class Usuario {
	private String nombre;
	private String contraseña;
	private TipoUsuario tipoUsuario;
	
	public Usuario(String nombre, String contraseña, TipoUsuario tipoUsuario) {
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.tipoUsuario = tipoUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public TipoUsuario getTipoDeUsuario() {
		return tipoUsuario;
	}

	public String tipoUsuario() {
		return "Usuario [tipoUsuario=" + tipoUsuario + "]";
	}

}
