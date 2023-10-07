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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import biblioteca.model.Serializzatore;
import biblioteca.model.Utenti;

public class ButtonAggiungiUtente extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private MenuBibliotecario menuBibliotecario;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	
	public ButtonAggiungiUtente(String nome, MenuBibliotecario menuBibliotecario) {
		
		super(nome);
		this.menuBibliotecario = menuBibliotecario;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(22, 152, 67, 17);
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(108, 70, 96, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(108, 112, 96, 19);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Cognome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(22, 111, 65, 17);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(23, 69, 42, 17);
		getContentPane().add(lblNewLabel);
		
		textField_3 = new JTextField();
		textField_3.setBounds(108, 202, 96, 19);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("ID:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(23, 26, 20, 17);
		getContentPane().add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(108, 27, 96, 19);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(108, 153, 96, 19);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(22, 201, 64, 17);
		getContentPane().add(lblNewLabel_3);
		

		
		JButton btnNewButton = new JButton("Crea Utente");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(285, 109, 113, 23);
		getContentPane().add(btnNewButton);
		
		
		btnNewButton.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				Utenti utenti = Utenti.fromGraphics(textField_4, textField, textField_1, textField_2, textField_3);
				
				//aggiunta utente
				List<Utenti> listaUtenti = Serializzatore.deserialize("Utenti.dat");
				listaUtenti.add(utenti);
				Serializzatore.<Utenti>serialize(listaUtenti, "Utenti.dat");
				JOptionPane.showMessageDialog(null, "Utente inserito");	
			}	
		});
		
		
		 JButton indietro = new JButton("Torna al Menù");
		 getContentPane().add(indietro);
		 indietro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 indietro.setBounds(285, 150, 113, 23);
		 getContentPane().add(btnNewButton);
		 indietro.addActionListener(new ActionListener() {
			 
			@Override
			 public void actionPerformed (ActionEvent e) {
				
				 menuBibliotecario.setVisible(true);
				 ButtonAggiungiUtente.this.setVisible(false);	 	 
			}
			
	 });
		 
		 menuBibliotecario.setVisible(false);
			contentPane.setVisible(true);
			this.setVisible(true);
	}
}
