package biblioteca.model;

import java.awt.TextField;
import java.io.Serializable;

import javax.swing.JTextField;

public class Utenti implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private User_type user_type;

	public Utenti(int id, String nome, String cognome, String username, String password, User_type user_type) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.user_type = user_type;
	}

	public static Utenti fromGraphics(JTextField id, JTextField nome, JTextField cognome, JTextField username,
			JTextField password) {
		return new Utenti(Integer.parseInt(id.getText()), nome.getText(), cognome.getText(), username.getText(),
				password.getText(), User_type.UTENTE);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
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

	public User_type getUser_type() {
		return user_type;
	}

	public void setUser_type(User_type user_type) {
		this.user_type = user_type;
	}

	@Override
	public String toString() {
		return "Utenti [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", username=" + username + ", password="
				+ password + ", user_type=" + user_type + "]";
	}

	public String[] getForTable() {
		return new String[] { "" + this.getId(), this.getNome(), this.getCognome(), this.getUsername(),
				this.getPassword(), this.getUser_type().toString() };
	}

}
