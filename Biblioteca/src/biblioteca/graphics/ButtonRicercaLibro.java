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

public class ButtonRicercaLibro extends JFrame {

	private static final long serialVersionUID = 1L;

	JTextField ricerca;
	MenuBibliotecario menuBibliotecario;
	JButton cerca;
	JPanel contentPane;
	JLabel label;

	public ButtonRicercaLibro(String nome, MenuBibliotecario menuBibliotecario) {

		super();
		this.menuBibliotecario = menuBibliotecario;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		label = new JLabel("Inserisci l'id, il titolo o il nome dell autore per la ricerca");
		label.setBounds(78, 28, 299, 13);
		contentPane.add(label);

		ricerca = new JTextField();
		ricerca.setBounds(88, 51, 217, 19);
		contentPane.add(ricerca);

		cerca = new JButton("Cerca");
		cerca.setBounds(121, 94, 153, 21);
		contentPane.add(cerca);
		cerca.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				List<Libri> listaLibri = Serializzatore.deserialize("Libri.dat");

				for (int i = 0; i < listaLibri.size(); i++) {

					if (ricerca.getText().equals(Integer.toString(listaLibri.get(i).getId()))) {
						JOptionPane.showMessageDialog(null, listaLibri.get(i));
					} else if (listaLibri.get(i).getTitolo().toString().equals(ricerca.getText())) {
						JOptionPane.showMessageDialog(null, listaLibri.get(i));
					} else if (listaLibri.get(i).getAutore().toString().equals(ricerca.getText())) {
						JOptionPane.showMessageDialog(null, listaLibri.get(i));
					}

				}
			}

		});

		JButton indietro = new JButton("Torna al Menù");
		getContentPane().add(indietro);
		indietro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		indietro.setBounds(143, 144, 113, 23);
		getContentPane().add(indietro);
		indietro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				menuBibliotecario.setVisible(true);
				ButtonRicercaLibro.this.setVisible(false);
			}

		});

		menuBibliotecario.setVisible(false);
		contentPane.setVisible(true);
		this.setVisible(true);

	}
}
