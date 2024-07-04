package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;

public class teste {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	
	private final ButtonGroup bgFilmes = new ButtonGroup();

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
		
		

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 537, 415);
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
	
	
		
		
		JPanel panelFinalizar = new JPanel();
        panel.add(panelFinalizar);
        panelFinalizar.setLayout(null);
        panelFinalizar.setBounds(0, 0, 500, 400);
        
        JTextArea textArea = new JTextArea(
                "----------------------------- \n"
                + "INGRESSO 1: \n"
                + "Assento: A1\n"
                + "Preço: R$ 50,00\n"
                + "----------------------------- \n"
                + "INGRESSO 2: \n"
                + "Assento: B2\n"
                + "Preço: R$ 40,00\n"
                + "----------------------------- \n"
                + "INGRESSO 3: \n"
                + "Assento: C3\n"
                + "Preço: R$ 30,00\n"
        );
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setWrapStyleWord(true);
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(42, 150, 447, 200);
        panelFinalizar.add(scrollPane);
        
        JLabel lblNewLabel_1 = new JLabel("Compra efetuada com sucesso!");
        lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 23));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(10, 92, 517, 29);
        panelFinalizar.add(lblNewLabel_1);
        
    
		
		
		
		
		
		JPanel panelAssentos = new JPanel();
		panel.add(panelAssentos, "name_500sds0699671900");
		panelAssentos.setLayout(null);
		frame.setBounds(100, 100, 553, 454);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
		

		
		
		
		
		
		
		JPanel panelFilmes = new JPanel();
		panel.add(panelFilmes, "name_500270699671900");
		panelFilmes.setLayout(null);
		frame.setBounds(100, 100, 553, 454);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblFilme1 = new JLabel("New label");
		lblFilme1.setIcon(new ImageIcon("src\\imagens\\divertidamente.png"));
		lblFilme1.setBounds(10, 68, 109, 171);
		panelFilmes.add(lblFilme1);
		
		JLabel lblFilme2 = new JLabel("");
		lblFilme2.setIcon(new ImageIcon("src\\imagens\\bad.png"));
		lblFilme2.setBounds(143, 68, 109, 171);
		panelFilmes.add(lblFilme2);
		
		JLabel lblFilme3 = new JLabel("New label");
		lblFilme3.setIcon(new ImageIcon("src\\imagens\\planeta.png"));
		lblFilme3.setBounds(282, 68, 109, 171);
		panelFilmes.add(lblFilme3);
		
		JLabel lblFilme4 = new JLabel("New label");
		lblFilme4.setIcon(new ImageIcon("src\\imagens\\assassino.png"));
		lblFilme4.setBounds(417, 68, 109, 171);
		panelFilmes.add(lblFilme4);
		
		JButton btnFilmeAvancar = new JButton("Avançar");
		btnFilmeAvancar.setEnabled(false);
		btnFilmeAvancar.setForeground(new Color(255, 255, 255));
		btnFilmeAvancar.setBackground(new Color(136, 191, 152));
		btnFilmeAvancar.setBounds(411, 361, 99, 29);
		panelFilmes.add(btnFilmeAvancar);

		
		JRadioButton rdbtnFilme1 = new JRadioButton("Divertidamente");
		
		rdbtnFilme1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (rdbtnFilme1.isSelected()) {
					btnFilmeAvancar.setEnabled(true);
				}
			}
			
		});
		
		bgFilmes.add(rdbtnFilme1);
		rdbtnFilme1.setFont(new Font("Bahnschrift", Font.BOLD, 11));
		rdbtnFilme1.setBounds(10, 250, 109, 23);
		panelFilmes.add(rdbtnFilme1);
	
		
		JRadioButton rdbtnFilme2 = new JRadioButton("Filme 2");
		
		rdbtnFilme2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnFilme2.isSelected()) {
					btnFilmeAvancar.setEnabled(true);
				} 
			}
		});
		bgFilmes.add(rdbtnFilme2);
		rdbtnFilme2.setBounds(143, 250, 109, 23);
		rdbtnFilme2.setFont(new Font("Bahnschrift", Font.BOLD, 11));
		panelFilmes.add(rdbtnFilme2);
		
		JRadioButton rdbtnFilme3 = new JRadioButton("Filme 2");
		rdbtnFilme3.setFont(new Font("Bahnschrift", Font.BOLD, 11));
		rdbtnFilme3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnFilme3.isSelected()) {
					btnFilmeAvancar.setEnabled(true);

				} 
			}
		});
		bgFilmes.add(rdbtnFilme3);
		rdbtnFilme3.setBounds(282, 250, 109, 23);
		panelFilmes.add(rdbtnFilme3);
		
		JRadioButton rdbtnFilme4 = new JRadioButton("Filme 2");
		rdbtnFilme4.setFont(new Font("Bahnschrift", Font.BOLD, 11));
		rdbtnFilme4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				if (rdbtnFilme4.isSelected()) {
					btnFilmeAvancar.setEnabled(true);
				} 
				
			}
		});
		
		bgFilmes.add(rdbtnFilme4);
		rdbtnFilme4.setBounds(417, 250, 109, 23);
		panelFilmes.add(rdbtnFilme4);

		JLabel lblPreco1 = new JLabel("Preço: R$");
		lblPreco1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPreco1.setFont(new Font("Bahnschrift", Font.BOLD, 11));
		lblPreco1.setBounds(10, 291, 109, 14);
		panelFilmes.add(lblPreco1);
		
		JLabel lblHorario1 = new JLabel("Horário:");
		lblHorario1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHorario1.setFont(new Font("Bahnschrift", Font.BOLD, 11));
		lblHorario1.setBounds(10, 316, 109, 14);
		panelFilmes.add(lblHorario1);
		
		
		JLabel lblPreco2 = new JLabel("Preço:");
		lblPreco2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPreco2.setFont(new Font("Bahnschrift", Font.BOLD, 11));
		lblPreco2.setBounds(143, 291, 109, 14);
		panelFilmes.add(lblPreco2);
		
		JLabel lblHorario2 = new JLabel("Horário:");
		lblHorario2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHorario2.setFont(new Font("Bahnschrift", Font.BOLD, 11));
		lblHorario2.setBounds(143, 316, 109, 14);
		panelFilmes.add(lblHorario2);
		
		JLabel lblPreco3 = new JLabel("Preço:");
		lblPreco3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPreco3.setFont(new Font("Bahnschrift", Font.BOLD, 11));
		lblPreco3.setBounds(282, 291, 109, 14);
		panelFilmes.add(lblPreco3);
		
		JLabel lblHorario3 = new JLabel("Horário:");
		lblHorario3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHorario3.setFont(new Font("Bahnschrift", Font.BOLD, 11));
		lblHorario3.setBounds(282, 316, 109, 14);
		panelFilmes.add(lblHorario3);
		
		JLabel lblPreco4 = new JLabel("Preço:");
		lblPreco4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPreco4.setFont(new Font("Bahnschrift", Font.BOLD, 11));
		lblPreco4.setBounds(401, 291, 109, 14);
		panelFilmes.add(lblPreco4);
		
		JLabel lblHorario4 = new JLabel("Horário:");
		lblHorario4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHorario4.setFont(new Font("Bahnschrift", Font.BOLD, 11));
		lblHorario4.setBounds(401, 316, 109, 14);
		panelFilmes.add(lblHorario4);
		
		
		
		
		
		
		JPanel panelEntrar = new JPanel();
		panel.add(panelEntrar, "name_500019798327600");
		panelEntrar.setLayout(null);
		
		JLabel lblNomeProgresso1 = new JLabel("Entrar");
		lblNomeProgresso1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeProgresso1.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblNomeProgresso1.setBounds(46, 21, 46, 28);
		panelEntrar.add(lblNomeProgresso1);
		
		JLabel lblIconProgresso1 = new JLabel("New label");
		lblIconProgresso1.setIcon(new ImageIcon("C:\\Users\\joao.silva117\\Documents\\GitHub\\reservas-cinema\\ReservasCinema\\src\\imagens\\verde.png"));
		lblIconProgresso1.setBounds(25, 25, 19, 19);
		panelEntrar.add(lblIconProgresso1);
		
		textField = new JTextField();
		textField.setBackground(new Color(217, 217, 217));
		textField.setBounds(167, 154, 196, 34);
		panelEntrar.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(217, 217, 217));
		textField_1.setBounds(167, 228, 196, 34);
		panelEntrar.add(textField_1);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(136, 191, 152));
		btnNewButton.setBounds(205, 292, 120, 42);
		panelEntrar.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Ingressos para o cinema");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 75, 537, 34);
		panelEntrar.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		lblEmail.setBounds(150, 125, 76, 34);
		panelEntrar.add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		lblSenha.setBounds(150, 201, 76, 34);
		panelEntrar.add(lblSenha);
		
		JLabel lblNomeProgresso2 = new JLabel("Filmes");
		lblNomeProgresso2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeProgresso2.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblNomeProgresso2.setBounds(141, 21, 51, 28);
		panelEntrar.add(lblNomeProgresso2);
		
		JLabel lblIconProgresso2 = new JLabel("New label");
		lblIconProgresso2.setIcon(new ImageIcon("C:\\Users\\joao.silva117\\Documents\\GitHub\\reservas-cinema\\ReservasCinema\\src\\imagens\\cinza.png"));
		lblIconProgresso2.setBounds(117, 25, 19, 19);
		panelEntrar.add(lblIconProgresso2);
		
		JLabel lblNomeProgresso3 = new JLabel("Assentos");
		lblNomeProgresso3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeProgresso3.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblNomeProgresso3.setBounds(235, 21, 57, 28);
		panelEntrar.add(lblNomeProgresso3);
		
		JLabel lblIconProgresso3 = new JLabel("New label");
		lblIconProgresso3.setIcon(new ImageIcon("C:\\Users\\joao.silva117\\Documents\\GitHub\\reservas-cinema\\ReservasCinema\\src\\imagens\\cinza.png"));
		lblIconProgresso3.setBounds(209, 25, 19, 19);
		panelEntrar.add(lblIconProgresso3);
		
		JLabel lblNomeProgresso4 = new JLabel("Pagamento");
		lblNomeProgresso4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeProgresso4.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblNomeProgresso4.setBounds(339, 21, 76, 28);
		panelEntrar.add(lblNomeProgresso4);
		
		JLabel lblIconProgresso4 = new JLabel("Pagamento");
		lblIconProgresso4.setIcon(new ImageIcon("C:\\Users\\joao.silva117\\Documents\\GitHub\\reservas-cinema\\ReservasCinema\\src\\imagens\\cinza.png"));
		lblIconProgresso4.setBounds(314, 25, 19, 19);
		panelEntrar.add(lblIconProgresso4);
		
		JLabel lblIconProgresso5 = new JLabel("Pagamento");
		lblIconProgresso5.setIcon(new ImageIcon("C:\\Users\\joao.silva117\\Documents\\GitHub\\reservas-cinema\\ReservasCinema\\src\\imagens\\cinza.png"));
		lblIconProgresso5.setBounds(429, 25, 19, 19);
		panelEntrar.add(lblIconProgresso5);
		
		JLabel lblNomeProgresso5 = new JLabel("Recibos");
		lblNomeProgresso5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeProgresso5.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblNomeProgresso5.setBounds(456, 21, 51, 28);
		panelEntrar.add(lblNomeProgresso5);
		
		JLabel lblAindaNoTem = new JLabel("Ainda não tem cadastro?");
		lblAindaNoTem.setForeground(new Color(136, 191, 152));
		lblAindaNoTem.setHorizontalAlignment(SwingConstants.CENTER);
		lblAindaNoTem.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		lblAindaNoTem.setBounds(0, 354, 537, 34);
		panelEntrar.add(lblAindaNoTem);
	
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
