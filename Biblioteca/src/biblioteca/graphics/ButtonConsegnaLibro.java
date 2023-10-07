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

public class ButtonConsegnaLibro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JTextField id;
	JButton consegna;
	JLabel inserisciID;
	JPanel contentPane;
	MenuUtente menuUtene;
	private JTextField textField;

	ButtonConsegnaLibro(String nome, MenuUtente menuUtente) {
		super();
		this.menuUtene = menuUtente;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		inserisciID = new JLabel("Inserisci l'id del libro");
		inserisciID.setBounds(78, 28, 299, 13);
		contentPane.add(inserisciID);

		id = new JTextField();
		id.setBounds(88, 51, 217, 19);
		contentPane.add(id);

		consegna = new JButton("Consegna");
		consegna.setBounds(131, 177, 153, 21);
		contentPane.add(consegna);
		consegna.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				List<Libri> listaLibri = Serializzatore.deserialize("Libri.dat");
				List<Utenti> listaUtenti = Serializzatore.deserialize("Utenti.dat");
				int idutente = Integer.parseInt(textField.getText());

				for (int i = 0; i < listaLibri.size(); i++) {
					for (int x = 0; x < listaUtenti.size(); x++) {

						if (listaUtenti.get(x).getId() == idutente) {

							if (listaLibri.get(i).isPrenotato()) {
								if (listaLibri.get(i).getId() == Integer.parseInt(id.getText())) {
									listaLibri.get(i).setConsegnato();
									listaLibri.get(i).setUtente(null);
									Serializzatore.<Libri>serialize(listaLibri, "Libri.dat");
									JOptionPane.showMessageDialog(null, "Libro consegnato");

								}
							}
						}
					}
				}
			}

		});

		JButton indietro = new JButton("Torna al Menù");
		getContentPane().add(indietro);
		indietro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		indietro.setBounds(152, 208, 113, 23);
		getContentPane().add(indietro);

		JLabel lblNewLabel = new JLabel("Inserisci l'id dell'utente");
		lblNewLabel.setBounds(78, 91, 113, 13);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(88, 114, 217, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		indietro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				menuUtente.setVisible(true);
				ButtonConsegnaLibro.this.setVisible(false);
			}

		});

		menuUtente.setVisible(false);
		contentPane.setVisible(true);
		this.setVisible(true);

	}
}
