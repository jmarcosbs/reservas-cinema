package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class teste {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					teste window = new teste();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public teste() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(new Color(217, 217, 217));
		textField.setBounds(162, 188, 196, 34);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(217, 217, 217));
		textField_1.setBounds(162, 262, 196, 34);
		frame.getContentPane().add(textField_1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(136, 191, 152));
		btnNewButton.setBounds(202, 327, 120, 42);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Ingressos");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(58, 75, 398, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblParaOCinema = new JLabel("para o Cinema");
		lblParaOCinema.setHorizontalAlignment(SwingConstants.CENTER);
		lblParaOCinema.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblParaOCinema.setBounds(58, 106, 398, 34);
		frame.getContentPane().add(lblParaOCinema);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		lblEmail.setBounds(145, 159, 76, 34);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		lblSenha.setBounds(145, 235, 76, 34);
		frame.getContentPane().add(lblSenha);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\joao.silva117\\Documents\\GitHub\\reservas-cinema\\ReservasCinema\\src\\imagens\\circulo.png"));
		lblNewLabel_1.setBounds(29, 25, 28, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblEntrar = new JLabel("Entrar");
		lblEntrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrar.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblEntrar.setBounds(58, 25, 46, 28);
		frame.getContentPane().add(lblEntrar);
		frame.setBounds(100, 100, 553, 454);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
