package biblioteca.graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import biblioteca.model.Libri;
import biblioteca.model.Serializzatore;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

public class ButtonAggiungiLibro extends JFrame {

	private static final long serialVersionUID = 1L;

	private MenuBibliotecario menuBibliotecario;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public ButtonAggiungiLibro(String nome, MenuBibliotecario menuBibliotecario) {

		super(nome);
		this.menuBibliotecario = menuBibliotecario;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID: ");
		lblNewLabel.setBounds(22, 49, 71, 13);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(101, 46, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("TITOLO:");
		lblNewLabel_1.setBounds(22, 84, 71, 13);
		contentPane.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBounds(101, 81, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("AUTORE:");
		lblNewLabel_2.setBounds(22, 120, 71, 13);
		contentPane.add(lblNewLabel_2);

		textField_2 = new JTextField();
		textField_2.setBounds(101, 117, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("PRENOTATO:");
		lblNewLabel_3.setBounds(22, 160, 90, 13);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setVisible(false);

		textField_3 = new JTextField();
		textField_3.setBounds(101, 157, 96, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setVisible(false);

		JButton btnNewButton = new JButton("AGGIUNGI LIBRO");
		btnNewButton.setBounds(245, 93, 153, 21);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Libri libri = Libri.fromGraphics(textField, textField_1, textField_2, textField_3);

				// aggiunta libro
				List<Libri> listaLibri = Serializzatore.deserialize("Libri.dat");
				listaLibri.add(libri);
				Serializzatore.<Libri>serialize(listaLibri, "Libri.dat");
				JOptionPane.showMessageDialog(null, "Libro inserito");

			}

		});

		JButton indietro = new JButton("Torna al Menù");
		getContentPane().add(indietro);
		indietro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		indietro.setBounds(269, 148, 113, 23);
		getContentPane().add(btnNewButton);
		indietro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				menuBibliotecario.setVisible(true);
				ButtonAggiungiLibro.this.setVisible(false);
			}

		});

		menuBibliotecario.setVisible(false);
		contentPane.setVisible(true);
		this.setVisible(true);

	}
}
