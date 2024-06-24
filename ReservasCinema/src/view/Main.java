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
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		panel.add(panelEntrar, "painelEntrar");
		panelEntrar.setLayout(null);
		
		JButton btnEntrarAvancar = new JButton("Avançar");
		btnEntrarAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CardLayout c1 = (CardLayout) panel.getLayout();
				c1.show(panel, "painelFilmes");
				btnEntrarAvancar.setEnabled(false);
				
			}
		});
		btnEntrarAvancar.setEnabled(false);
		btnEntrarAvancar.setBounds(425, 368, 89, 23);
		panelEntrar.add(btnEntrarAvancar);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//logar(retorna booleano logado ou não e avança para o próximo card layout)
				
				//boolean podeAvancar = true;
				
				//if (podeAvancar == true) {
					btnEntrarAvancar.setEnabled(true);
				//}
				
			}	
		});
		btnLogin.setBounds(180, 235, 149, 23);
		panelEntrar.add(btnLogin);
		
		textField = new JTextField();
		textField.setBounds(180, 182, 149, 20);
		panelEntrar.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(180, 126, 149, 20);
		panelEntrar.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEntrar = new JLabel("Entrar");
		lblEntrar.setBounds(35, 27, 62, 20);
		panelEntrar.add(lblEntrar);
		
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(179, 101, 46, 14);
		panelEntrar.add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(180, 157, 46, 14);
		panelEntrar.add(lblSenha);
		
		JLabel lblSemCadastro = new JLabel("Ainda não tenho cadastro");
		lblSemCadastro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				NovoCadastro telaCadastro = new NovoCadastro();
				telaCadastro.setVisible(true);
				
			}
		});
		lblSemCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lblSemCadastro.setBounds(180, 297, 149, 14);
		panelEntrar.add(lblSemCadastro);
		
		JPanel panelFilmes = new JPanel();
		panel.add(panelFilmes, "painelFilmes");
		panelFilmes.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Divertidamente");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBounds(79, 107, 130, 31);
		panelFilmes.add(lblNewLabel);
		
		JTextPane txtpnRileyUma = new JTextPane();
		txtpnRileyUma.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		txtpnRileyUma.setText("Riley é uma garota divertida de 11 anos de idade, que deve enfrentar mudanças importantes em sua vida quando seus pais decidem deixar a sua cidade natal, no estado de Minnesota, para viver em San Francisco.\r\n");
		txtpnRileyUma.setBounds(79, 135, 387, 49);
		panelFilmes.add(txtpnRileyUma);
		
		JButton btnFilmeAvancar = new JButton("Avançar");
		btnFilmeAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CardLayout c1 = (CardLayout) panel.getLayout();
				c1.show(panel, "painelAssentos");
				
			}
		});
		btnFilmeAvancar.setBounds(417, 382, 89, 23);
		panelFilmes.add(btnFilmeAvancar);
		
		JLabel lblFilmes = new JLabel("Filmes");
		lblFilmes.setBounds(27, 27, 46, 14);
		panelFilmes.add(lblFilmes);
		
		JPanel panelAssentos = new JPanel();
		panel.add(panelAssentos, "painelAssentos");
		panelAssentos.setLayout(null);
		
		JLabel lblAssentos = new JLabel("Assentos");
		lblAssentos.setBounds(43, 33, 46, 14);
		panelAssentos.add(lblAssentos);
		
		JButton btnFilmeVoltar_1 = new JButton("Voltar");
		btnFilmeVoltar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CardLayout c1 = (CardLayout) panel.getLayout();
				c1.show(panel, "painelFilmes");
				
			}
		});
		btnFilmeVoltar_1.setBounds(31, 368, 89, 23);
		panelAssentos.add(btnFilmeVoltar_1);
		
		JButton btnFilmeAvancar_1 = new JButton("Avançar");
		btnFilmeAvancar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CardLayout c1 = (CardLayout) panel.getLayout();
				c1.show(panel, "painelPagamento");
				
			}
		});
		btnFilmeAvancar_1.setBounds(421, 368, 89, 23);
		panelAssentos.add(btnFilmeAvancar_1);
		
		JPanel panelPagamento = new JPanel();
		panel.add(panelPagamento, "painelPagamento");
		panelPagamento.setLayout(null);
		
		JRadioButton rdbtnPix = new JRadioButton("Pix");
		rdbtnPix.setBounds(194, 99, 109, 23);
		panelPagamento.add(rdbtnPix);
		
		JButton btnPgAvancar = new JButton("Avançar");
		btnPgAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CardLayout c1 = (CardLayout) panel.getLayout();
				c1.show(panel, "painelFinalizar");
				
			}
		});
		btnPgAvancar.setBounds(407, 311, 89, 23);
		panelPagamento.add(btnPgAvancar);
		
		JButton btnPgVoltar = new JButton("Voltar");
		btnPgVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CardLayout c1 = (CardLayout) panel.getLayout();
				c1.show(panel, "painelAssentos");
				
			}
		});
		btnPgVoltar.setBounds(308, 311, 89, 23);
		panelPagamento.add(btnPgVoltar);
		
		JRadioButton rdbtnCredito = new JRadioButton("Credito");
		rdbtnCredito.setBounds(194, 125, 109, 23);
		panelPagamento.add(rdbtnCredito);
		
		JRadioButton rdbtnDebito = new JRadioButton("Debito");
		rdbtnDebito.setBounds(194, 156, 109, 23);
		panelPagamento.add(rdbtnDebito);
		
		JLabel lblPagamento = new JLabel("Pagamento");
		lblPagamento.setBounds(50, 49, 109, 14);
		panelPagamento.add(lblPagamento);
		
		JPanel panelFinalizar = new JPanel();
		panel.add(panelFinalizar, "painelFinalizar");
		panelFinalizar.setLayout(null);
		
		JButton btnComprarDeNovo = new JButton("Comprar Novamente");
		btnComprarDeNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c1 = (CardLayout) panel.getLayout();
				c1.show(panel, "painelFilmes");
			}
		});
		btnComprarDeNovo.setBounds(318, 309, 183, 23);
		panelFinalizar.add(btnComprarDeNovo);
		
		JLabel lblFinalizar = new JLabel("Finalizar");
		lblFinalizar.setBounds(51, 44, 46, 14);
		panelFinalizar.add(lblFinalizar);
	}
}
