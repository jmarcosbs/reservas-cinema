package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;

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
		frame.setBounds(100, 100, 553, 454);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 539, 415);
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
		panel.add(panelFilmes, "name_2824654620200");
		panelFilmes.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Divertidamente");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBounds(119, 19, 130, 31);
		panelFilmes.add(lblNewLabel);
		
		JTextPane txtpnRileyUma = new JTextPane();
		txtpnRileyUma.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		txtpnRileyUma.setText("Riley é uma garota divertida de 11 anos de idade, que deve enfrentar mudanças importantes em sua vida quando seus pais decidem deixar a sua cidade natal, no estado de Minnesota, para viver em San Francisco.\r\n");
		txtpnRileyUma.setBounds(119, 47, 387, 49);
		panelFilmes.add(txtpnRileyUma);
		
		JTextPane txtpnRileyUma_1 = new JTextPane();
		txtpnRileyUma_1.setText("Bad Boys: Até o Fim é o quarto filme da icônica saga de ação estrelada por Will Smith e Martin Lawrence, iniciada em 1995 com Os Bad Boys, dirigido por Michael Bay. Desta vez, o longa conta com Adil El Arbi e Bilall Fallah na direção e o roteiro fica por conta de Chris Bremnerirá.");
		txtpnRileyUma_1.setBounds(119, 125, 387, 62);
		panelFilmes.add(txtpnRileyUma_1);
		
		JLabel lblNewLabel_1 = new JLabel("Bad Boys: Até o Fim");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel_1.setBounds(119, 100, 130, 31);
		panelFilmes.add(lblNewLabel_1);
		
		JTextPane txtpnRileyUma_2 = new JTextPane();
		txtpnRileyUma_2.setText("Planeta dos Macacos: O Reinado dá continuidade à saga dos primatas inteligentes, situando-se em um futuro distante após os eventos de Guerra pelo Planeta dos Macacos de 2017.");
		txtpnRileyUma_2.setBounds(119, 224, 387, 49);
		panelFilmes.add(txtpnRileyUma_2);
		
		JLabel lblNewLabel_2 = new JLabel("Planeta dos Macacos: O Reinado\r\n");
		lblNewLabel_2.setBounds(119, 198, 245, 31);
		panelFilmes.add(lblNewLabel_2);
		
		JTextPane txtpnRileyUma_2_1 = new JTextPane();
		txtpnRileyUma_2_1.setText("Gary Johnson (Glen Powell) é o assassino profissional mais procurado de Nova Orleans. No entanto, nem tudo é o que parece: para os seus clientes, Gary passa como um assassino de aluguel comum, mas, na verdade, ele trabalha para a polícia.");
		txtpnRileyUma_2_1.setBounds(119, 309, 387, 62);
		panelFilmes.add(txtpnRileyUma_2_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Assassino por Acaso");
		lblNewLabel_2_1.setBounds(119, 284, 130, 31);
		panelFilmes.add(lblNewLabel_2_1);
		
		JButton btnFilmeAvancar = new JButton("Avançar");
		btnFilmeAvancar.setBounds(417, 382, 89, 23);
		panelFilmes.add(btnFilmeAvancar);
		
		JButton btnFilmeVoltar = new JButton("Voltar");
		btnFilmeVoltar.setBounds(27, 382, 89, 23);
		panelFilmes.add(btnFilmeVoltar);
		
		JPanel panelAssentos = new JPanel();
		panel.add(panelAssentos, "name_2853478477800");
		panelAssentos.setLayout(null);
		
		JPanel panelPagamento = new JPanel();
		panel.add(panelPagamento, "name_2894830004000");
		panelPagamento.setLayout(null);
		
		JPanel panelFinalizar = new JPanel();
		panel.add(panelFinalizar, "name_2963587884400");
		panelFinalizar.setLayout(null);
	}
}
