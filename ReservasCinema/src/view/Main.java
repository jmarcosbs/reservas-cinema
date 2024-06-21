package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class Main {

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
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 555, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 539, 361);
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JPanel panelEntrar = new JPanel();
		panel.add(panelEntrar, "name_2824621832500");
		panelEntrar.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(195, 207, 149, 23);
		panelEntrar.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(195, 154, 149, 20);
		panelEntrar.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(195, 98, 149, 20);
		panelEntrar.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panelFilmes = new JPanel();
		panel.add(panelFilmes, "painelFilmes");
		panelFilmes.setLayout(null);
		
		JPanel panelAssentos = new JPanel();
		panel.add(panelAssentos, "painelAssentos");
		panelAssentos.setLayout(null);
		
		JPanel panelPagamento = new JPanel();
		panel.add(panelPagamento, "painelPagamento");
		panelPagamento.setLayout(null);
		
		JRadioButton rdbtnPix = new JRadioButton("Pix");
		rdbtnPix.setBounds(194, 99, 109, 23);
		panelPagamento.add(rdbtnPix);
		
		JButton btnPgAvancar = new JButton("Avançar");
		btnPgAvancar.setBounds(407, 311, 89, 23);
		panelPagamento.add(btnPgAvancar);
		
		JButton btnPgVoltar = new JButton("Voltar");
		btnPgVoltar.setBounds(308, 311, 89, 23);
		panelPagamento.add(btnPgVoltar);
		
		JRadioButton rdbtnCredito = new JRadioButton("Credito");
		rdbtnCredito.setBounds(194, 125, 109, 23);
		panelPagamento.add(rdbtnCredito);
		
		JRadioButton rdbtnDebito = new JRadioButton("Debito");
		rdbtnDebito.setBounds(194, 156, 109, 23);
		panelPagamento.add(rdbtnDebito);
		
		JPanel panelFinalizar = new JPanel();
		panel.add(panelFinalizar, "painelFinalizar");
		panelFinalizar.setLayout(null);
		
		JButton btnComprarDeNovo = new JButton("Comprar Novamente");
		btnComprarDeNovo.setBounds(318, 309, 183, 23);
		panelFinalizar.add(btnComprarDeNovo);
	}
}
