package biblioteca.graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import biblioteca.model.Libri;
import biblioteca.model.Serializzatore;
import biblioteca.model.User_type;
import biblioteca.model.Utenti;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Login extends JFrame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// variabili finestra LOGIN
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField passwordField;
	private JButton login;
	private int cont;

	// variabili che salvano ingresso utente
	Utenti accessoUtente;

	// create frame
	public Login(String nome) {

		super(nome);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 327, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 10, 108, 33);
		contentPane.add(lblNewLabel);

		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 18));
		username.setBounds(128, 10, 114, 29);
		contentPane.add(username);
		username.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 53, 108, 33);
		contentPane.add(lblNewLabel_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(128, 53, 114, 29);
		contentPane.add(passwordField);

		login = new JButton("Login");
		login.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				/*
				 * Libri libro0 = new Libri(1, "La divina commedia", "Dante Alighieri", false);
				 * 
				 * 
				 * Serializzatore.<Libri>serialize(libro0, "Libri.dat");
				 * 
				 */

				// procedura per prendere i dati, aggiungere i dati, riscriverli e leggerli
				// sovrascritti
				List<Utenti> listaUtenti = Serializzatore.deserialize("Utenti.dat");
				Serializzatore.<Utenti>serialize(listaUtenti, "Utenti.dat");
				listaUtenti = Serializzatore.<Utenti>deserialize("Utenti.dat");

				// libri
				List<Libri> listaLibri = Serializzatore.deserialize("Libri.dat");
				Serializzatore.<Libri>serialize(listaLibri, "Libri.dat");
				listaLibri = Serializzatore.<Libri>deserialize("Libri.dat");

				for (int i = 0; i < listaUtenti.size(); i++) {

					if (username.getText().equals(listaUtenti.get(i).getUsername())
							&& passwordField.getText().equals(listaUtenti.get(i).getPassword())
							&& User_type.BIBLIOTECARIO.equals(listaUtenti.get(i).getUser_type())) {

						cont = 1;

					}

					else if (username.getText().equals(listaUtenti.get(i).getUsername())
							&& passwordField.getText().equals(listaUtenti.get(i).getPassword())
							&& User_type.UTENTE.equals(listaUtenti.get(i).getUser_type())) {

						cont = 2;

						accessoUtente = listaUtenti.get(i);

					}

					else {
					}
				}

				if (cont == 1) {
					JOptionPane.showMessageDialog(null, "Login effettuato");
					MenuBibliotecario menuBibliotecario = new MenuBibliotecario(Login.this, "Menu Bibliotecario");
					menuBibliotecario.setVisible(true);

				} else if (cont == 2) {
					JOptionPane.showMessageDialog(null, "Login effettuato");
					MenuUtente menuUtente = new MenuUtente(Login.this, "Menù Utente");
					menuUtente.setVisible(true);

				} else {
					JOptionPane.showMessageDialog(null, "Login fallito");
				}

			}
		});

		login.setBounds(106, 153, 85, 21);
		contentPane.add(login);
	}
}
