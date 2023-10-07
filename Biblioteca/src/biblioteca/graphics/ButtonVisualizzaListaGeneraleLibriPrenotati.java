package biblioteca.graphics;

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

public class ButtonVisualizzaListaGeneraleLibriPrenotati extends JFrame {

	MenuUtente menuUtente;
	Login login;
	private JPanel contentPane;
	private JScrollPane scrollPane;

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	public ButtonVisualizzaListaGeneraleLibriPrenotati(String nome, MenuUtente menuUtente) {
		super();
		this.menuUtente = menuUtente;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.add(this.createTable());
		menuUtente.setVisible(false);
		contentPane.setVisible(true);
		this.setVisible(true);

		JButton indietro = new JButton("Torna al Menù");
		getContentPane().add(indietro);
		indietro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				menuUtente.setVisible(true);
				ButtonVisualizzaListaGeneraleLibriPrenotati.this.setVisible(false);

			}

		});

	}

	private JScrollPane createTable() {
		List<Libri> listaLibri = Serializzatore.deserialize("Libri.dat");
		String[] columnNames = { "id", "titolo", "autore", "prenotato" };
		Object[][] data = new Object[listaLibri.size()][];

		for (int x = 0; x < listaLibri.size(); x++) {

			data[x] = listaLibri.get(x).getForTable();

		}

		JTable table = new JTable(data, columnNames);
		// scrfi il ibro nuobo
		// legge tutti i libri
		// ricri l'array
		// table = new JTable(data, columnNames);
		table.setBounds(0, 0, 500, 500);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(500, 550, 300, 500);
		scrollPane.setVisible(true);
		return scrollPane;

	}
}
