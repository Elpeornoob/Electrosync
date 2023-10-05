package co.edu.upb.sistemaInventario;

public class Cliente {
    private String nombreCliente;
    private String direccion;
    private TipoDocumento tipoDocumento;
    private String numeroDocumento;
    private String numeroTelefono;
    private String email;
	
    public Cliente(String nombreCliente, String direccion, TipoDocumento tipoDocumento, String numeroDocumento,
			String numeroTelefono, String email) {
		this.nombreCliente = nombreCliente;
		this.direccion = direccion;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.numeroTelefono = numeroTelefono;
		this.email = email;
	}
    
	public String getNombreCLiente() {
		return nombreCliente;
	}

	public String getDireccion() {
		return direccion;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public String getEmail() {
		return email;
	}
}
