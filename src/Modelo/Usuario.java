package Modelo;

public class Usuario {

	private String username; // login
	private String password; // password
	private int elo;
	private int id;
	
	public Usuario(String username, String password) {
		
		this.username=username;
		this.password=password;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getElo() {
		return elo;
	}

	public void setElo(int elo) {
		this.elo = elo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Username: "+ username + ", password: " + password + ", elo = "+elo;
	}
}
