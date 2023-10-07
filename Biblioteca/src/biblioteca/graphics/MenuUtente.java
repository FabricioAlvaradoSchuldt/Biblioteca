package biblioteca.graphics;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import biblioteca.model.Libri;
import biblioteca.model.Utenti;

public class MenuUtente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List<Utenti> listaUtenti;
	private List<Libri> listaLibri;
	private JButton consegnaLibro;
	private JButton visualizzaLibriInPrestito;
	private Login login;

	public MenuUtente(Login login, String nome) {
		super(nome);
		this.login = login;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		// bottoni
		consegnaLibro = new JButton("Consegna Libro");
		contentPane.add(consegnaLibro);
		consegnaLibro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ButtonConsegnaLibro consegnaLibro = new ButtonConsegnaLibro("Consegna Libro", MenuUtente.this);
			}

		});

		visualizzaLibriInPrestito = new JButton("Visualizza lista libri");
		contentPane.add(visualizzaLibriInPrestito);
		visualizzaLibriInPrestito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ButtonVisualizzaListaGeneraleLibriPrenotati visualizzaLibriInPrestito = new ButtonVisualizzaListaGeneraleLibriPrenotati(
						"Lista libri", MenuUtente.this);
			}

		});

		login.setVisible(false);

	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

}
