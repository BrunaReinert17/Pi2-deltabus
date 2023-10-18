package modelo;

public class Usuario {

	private long idUsuario;
	private String email;
	private String senha;
	private String cargo;

	
	
	public Usuario() {
		super();
	}

	public Usuario(long idUsuario, String email, String senha, String cargo) {
		super();
		this.idUsuario = idUsuario;
		this.email = email;
		this.senha = senha;
		this.cargo = cargo;

	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", email=" + email + ", senha=" + senha + ", cargo=" + cargo + "]";
	}

	public void setNome(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setIdade(int i) {
		// TODO Auto-generated method stub
		
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public Object getFuncao() {
		// TODO Auto-generated method stub
		return false;
	}

	public static Object getNome() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Object getCpf() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Object getTelefone() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Object getDataNasci() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Object getGenero() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Object Email() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
