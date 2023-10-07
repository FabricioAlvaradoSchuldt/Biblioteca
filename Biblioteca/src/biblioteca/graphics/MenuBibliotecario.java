package biblioteca.graphics;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import biblioteca.model.Libri;
import biblioteca.model.Serializzatore;
import biblioteca.model.Utenti;
import javax.swing.JTextField;

public class MenuBibliotecario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// varibili finestra Bibliotecario
	private JPanel contentPaneB;
	private JButton AggiungiUtente;
	private JButton VisualizzaUtenti;
	private JButton VisualizzaLibri;
	private JButton RicercaLibro;
	private JButton AggiungiLibro;
	private JButton PrenotaLibro;
	private Login login;

	// costruttore
	public MenuBibliotecario(Login login, String nome) {

		super(nome);
		this.login = login;

		// finestra e pannello
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 299);
		contentPaneB = new JPanel();
		contentPaneB.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPaneB.setLayout(null);
		setContentPane(contentPaneB);

		// bottoni con aggiunta al pannello
		AggiungiUtente = new JButton("Aggiungi utente");
		AggiungiUtente.setBounds(37, 46, 140, 21);
		contentPaneB.add(AggiungiUtente);
		AggiungiUtente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ButtonAggiungiUtente aggiungiUtente = new ButtonAggiungiUtente("Aggiungi Utente",
						MenuBibliotecario.this);

			}

		});

		VisualizzaUtenti = new JButton("Visualizza utenti");
		VisualizzaUtenti.setBounds(37, 77, 140, 21);
		contentPaneB.add(VisualizzaUtenti);
		VisualizzaUtenti.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				ButtonVisualizzaUtenti visualizzaUtenti = new ButtonVisualizzaUtenti("Visualizza Utenti",
						MenuBibliotecario.this);

			}

		});

		VisualizzaLibri = new JButton("Visualizza libri");
		VisualizzaLibri.setBounds(37, 108, 140, 21);
		contentPaneB.add(VisualizzaLibri);
		VisualizzaLibri.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ButtonVisualizzaLibri visualizzaLibri = new ButtonVisualizzaLibri("Visualizza Libri",
						MenuBibliotecario.this);

			}

		});

		RicercaLibro = new JButton("Ricerca libro");
		RicercaLibro.setBounds(208, 46, 125, 21);
		contentPaneB.add(RicercaLibro);
		RicercaLibro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				ButtonRicercaLibro ricercaLibro = new ButtonRicercaLibro("Ricerca Libro", MenuBibliotecario.this);

			}

		});

		AggiungiLibro = new JButton("Aggiungi libro");
		AggiungiLibro.setBounds(208, 77, 125, 21);
		contentPaneB.add(AggiungiLibro);
		AggiungiLibro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ButtonAggiungiLibro aggiungiLibro = new ButtonAggiungiLibro("Aggiungi libro", MenuBibliotecario.this);
			}

		});

		PrenotaLibro = new JButton("Prenota libro");
		PrenotaLibro.setBounds(208, 108, 125, 21);
		contentPaneB.add(PrenotaLibro);
		PrenotaLibro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ButtonPrenotaLibro prenotaLibro = new ButtonPrenotaLibro("Prenota Libro", MenuBibliotecario.this);
			}

		});

		contentPaneB.setVisible(true);
		login.setVisible(false);

	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

}
