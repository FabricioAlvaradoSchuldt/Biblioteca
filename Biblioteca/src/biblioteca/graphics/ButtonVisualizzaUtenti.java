package biblioteca.graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import biblioteca.model.Serializzatore;
import biblioteca.model.Utenti;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ButtonVisualizzaUtenti extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MenuBibliotecario menuBibliotecario;
	private JPanel contentPane;
	private JScrollPane scrollpane;

	public ButtonVisualizzaUtenti(String nome, MenuBibliotecario menuBibliotecario) {

		super(nome);
		this.menuBibliotecario = menuBibliotecario;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.add(this.createTable());
		menuBibliotecario.setVisible(false);
		contentPane.setVisible(true);
		this.setVisible(true);

		JButton indietro = new JButton("Torna al Menù");
		getContentPane().add(indietro);
		indietro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				menuBibliotecario.setVisible(true);
				ButtonVisualizzaUtenti.this.setVisible(false);

			}

		});

	}

	private JScrollPane createTable() {
		List<Utenti> listaUtenti = Serializzatore.deserialize("Utenti.dat");
		String[] columnNames = { "ID", "Nome", "Cognome", "Username", "Password", "User Type" };
		Object[][] data = new Object[listaUtenti.size()][];
		for (int i = 0; i < listaUtenti.size(); i++) {
			data[i] = listaUtenti.get(i).getForTable();
		}
		JTable table = new JTable(data, columnNames);
		// scrfi il ibro nuobo
		// legge tutti i libri
		// ricri l'array
		// table = new JTable(data, columnNames);
		table.setBounds(0, 0, 500, 500);
		scrollpane = new JScrollPane(table);
		scrollpane.setBounds(500, 550, 300, 500);
		scrollpane.setVisible(true);
		return scrollpane;
	}

}
