package biblioteca.graphics;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import biblioteca.model.Libri;
import biblioteca.model.Serializzatore;
import biblioteca.model.Utenti;

public class ButtonPrenotaLibro extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField inserisciLibro;
	private JTextField inserisciUtente;
	private MenuBibliotecario menuBibliotecario;
	private JButton inserisciPrenotazione;
	private int cont = 0;

	public ButtonPrenotaLibro(String nome, MenuBibliotecario menuBibliotecario) {

		super(nome);
		this.menuBibliotecario = menuBibliotecario;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Inserisci l'ID del Libro:");
		lblNewLabel.setBounds(58, 47, 126, 13);
		contentPane.add(lblNewLabel);

		inserisciLibro = new JTextField();
		inserisciLibro.setBounds(70, 68, 96, 19);
		contentPane.add(inserisciLibro);
		inserisciLibro.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Inserisci l'ID dell'utente:");
		lblNewLabel_1.setBounds(60, 97, 220, 13);
		contentPane.add(lblNewLabel_1);

		inserisciUtente = new JTextField();
		inserisciUtente.setBounds(70, 120, 96, 19);
		contentPane.add(inserisciUtente);
		inserisciUtente.setColumns(10);

		inserisciPrenotazione = new JButton("PRENOTA LIBRO");
		inserisciPrenotazione.setBounds(245, 93, 153, 21);
		contentPane.add(inserisciPrenotazione);
		inserisciPrenotazione.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int idLibro = Integer.parseInt(inserisciLibro.getText());
				int idUtente = Integer.parseInt(inserisciUtente.getText());

				List<Libri> listaLibri = Serializzatore.deserialize("Libri.dat");
				List<Utenti> listaUtenti = Serializzatore.deserialize("Utenti.dat");

				ESTERNO: for (int x = 0; x < listaLibri.size(); x++) {
					for (int i = 0; i < listaUtenti.size(); i++) {
						if (!listaLibri.get(x).isPrenotato()) {
							if (listaLibri.get(x).getId() == idLibro & listaUtenti.get(i).getId() == idUtente) {
								listaLibri.get(x).setPrenotato();
								listaLibri.get(x).setUtente(listaUtenti.get(i));
								Serializzatore.<Libri>serialize(listaLibri, "Libri.dat");
								cont = 1;
								break ESTERNO;
							}
						} else {
							cont = 2;
						}
					}

				}

				if (cont == 1)
					JOptionPane.showMessageDialog(null, "Libro prenotato");

				else if (cont == 2)
					JOptionPane.showMessageDialog(null, "Impossibile procedere, Libro già prenotato");

			}

		});

		JButton indietro = new JButton("Torna al Menù");
		getContentPane().add(indietro);
		indietro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		indietro.setBounds(269, 148, 113, 23);
		getContentPane().add(indietro);
		indietro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				menuBibliotecario.setVisible(true);
				ButtonPrenotaLibro.this.setVisible(false);
			}

		});

		menuBibliotecario.setVisible(false);
		contentPane.setVisible(true);
		this.setVisible(true);

	}

}
