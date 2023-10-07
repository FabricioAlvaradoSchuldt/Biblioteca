package biblioteca.model;

import java.io.Serializable;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Libri implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String titolo;
	private String autore;
	private boolean prenotato = false;
	private Utenti utente;

	public Libri(int id, String titolo, String autore, boolean prenotato) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.autore = autore;
		this.prenotato = prenotato;

	}

	public static Libri fromGraphics(JTextField id, JTextField titolo, JTextField autore, JTextField prenotato) {
		return new Libri(Integer.parseInt(id.getText()), titolo.getText(), autore.getText(),
				Boolean.parseBoolean(prenotato.getText()));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public boolean isPrenotato() {
		return prenotato;
	}

	public void setPrenotato() {
		this.prenotato = true;
	}

	public void setConsegnato() {
		this.prenotato = false;
	}

	public Utenti getUtente() {
		return utente;
	}

	public void setUtente(Utenti utente) {
		this.utente = utente;
	}

	@Override
	public String toString() {
		return "Libri [id=" + id + ", titolo=" + titolo + ", autore=" + autore + ", prenotato=" + prenotato
				+ ", utente=" + utente + "]";
	}

	public String[] getForTable() {
		return new String[] { "" + this.getId(), this.getTitolo(), this.getAutore(), "" + this.isPrenotato(),
				"" + this.getUtente()

		};
	}

}
