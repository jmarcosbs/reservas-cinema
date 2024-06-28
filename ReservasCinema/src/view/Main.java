package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import dao.AssentoDao;
import dao.FilmeDao;
import dao.UsuarioDao;
import entidades.Usuario;
import entidades.Assento;
import entidades.Filme;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Main {

	private JFrame frame;
	private JTextField txtEmail;
	private JPasswordField pssSenha;
	private UsuarioDao usuarioDao = new UsuarioDao();
	private AssentoDao assentoDao = new AssentoDao();
	private FilmeDao filmeDao = new FilmeDao();
	private Usuario usuarioLogado;
	private List<Filme> listaDeFilmes = filmeDao.listarFilmes();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Filme filmeSelecionado = null;
	private List<Assento> listaAssentos;
	private JPanel panel = new JPanel();
	private JPanel panelEntrar = new JPanel();
	private JPanel panelFilmes = new JPanel();
	private JPanel panelAssentos = new JPanel();
	private JPanel panelPagamento = new JPanel();
	private JPanel panelFinalizar = new JPanel();


	

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
		
		panel.setBounds(0, 0, 539, 415);
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		
		panel.add(panelEntrar, "painelEntrar");
		panelEntrar.setLayout(null);
		
		panel.add(panelFilmes, "painelFilmes");
		panelFilmes.setLayout(null);
		
		panel.add(panelAssentos, "painelAssentos");
		panelAssentos.setLayout(null);
		
		panel.add(panelPagamento, "painelPagamento");
		panelPagamento.setLayout(null);
		
		panel.add(panelFinalizar, "painelFinalizar");
		panelFinalizar.setLayout(null);
		
		criarEntrar();
		

		


	}

	
	public Assento retornaAssento(List<Assento> listaDeAssentos, Filme filmeSelecionado, int indice) {
		
		Assento assento = null;
		
		if (filmeSelecionado != null) {
			
			assento = listaDeAssentos.get(indice);
			
		}
		
		return assento;
		
	}
	
	public void criarEntrar() {
		
		
		JLabel lblEntrar = new JLabel("Entrar");
		lblEntrar.setBounds(35, 27, 62, 20);
		panelEntrar.add(lblEntrar);
		
		
		JButton btnEntrarAvancar = new JButton("Avançar");
		btnEntrarAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CardLayout c1 = (CardLayout) panel.getLayout();
				c1.show(panel, "painelFilmes");
				criarFilmes();
				
			}
		});
		btnEntrarAvancar.setBounds(425, 368, 89, 23);
		panelEntrar.add(btnEntrarAvancar);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Transformando char[] senha em String
				String senha = new String (pssSenha.getPassword());
				
				// Obtendo texto do campo email
				String email = txtEmail.getText();
				
				usuarioLogado = usuarioDao.LogarUsuario(email, senha);
				
				if (usuarioLogado != null) {
					JOptionPane.showMessageDialog(null, "Bem-vindo");
					btnEntrarAvancar.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Informações inválidas");
				}
			

			}	
		});
		btnLogin.setBounds(180, 235, 149, 23);
		panelEntrar.add(btnLogin);
		
		
		
		txtEmail = new JTextField();
		txtEmail.setBounds(180, 126, 149, 20);
		panelEntrar.add(txtEmail);
		txtEmail.setColumns(10);
		
		
		
		
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
		
		pssSenha = new JPasswordField();
		pssSenha.setBounds(180, 192, 149, 20);
		panelEntrar.add(pssSenha);
		
	}
	
	
	public void criarFilmes() {
		
		
		JLabel lblFilmes = new JLabel("Filmes");
		lblFilmes.setBounds(27, 27, 46, 14);
		panelFilmes.add(lblFilmes);
		
		JLabel lblFilme1 = new JLabel("New label");
		lblFilme1.setIcon(new ImageIcon("src\\imagens\\divertidamente.png"));
		lblFilme1.setBounds(10, 88, 109, 171);
		panelFilmes.add(lblFilme1);
		
		JLabel lblFilme2 = new JLabel("");
		lblFilme2.setIcon(new ImageIcon("src\\imagens\\bad.png"));
		lblFilme2.setBounds(143, 88, 109, 171);
		panelFilmes.add(lblFilme2);
		
		JLabel lblFilme3 = new JLabel("New label");
		lblFilme3.setIcon(new ImageIcon("src\\imagens\\planeta.png"));
		lblFilme3.setBounds(282, 88, 109, 171);
		panelFilmes.add(lblFilme3);
		
		JLabel lblFilme4 = new JLabel("New label");
		lblFilme4.setIcon(new ImageIcon("src\\imagens\\assassino.png"));
		lblFilme4.setBounds(417, 88, 109, 171);
		panelFilmes.add(lblFilme4);
		
		JButton btnFilmeAvancar = new JButton("Avançar");
		btnFilmeAvancar.setEnabled(false);
		btnFilmeAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CardLayout c1 = (CardLayout) panel.getLayout();
				c1.show(panel, "painelAssentos");
				criarAssentos();

				
			}
		});
	
		
		btnFilmeAvancar.setBounds(417, 382, 89, 23);
		panelFilmes.add(btnFilmeAvancar);

		
		JRadioButton rdbtnFilme1 = new JRadioButton(listaDeFilmes.get(0).getTitulo());
		rdbtnFilme1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (rdbtnFilme1.isSelected()) {
					btnFilmeAvancar.setEnabled(true);
					filmeSelecionado = listaDeFilmes.get(0);
				}
			}
			
		});
		
		buttonGroup.add(rdbtnFilme1);
		
		rdbtnFilme1.setBounds(20, 270, 109, 23);
		panelFilmes.add(rdbtnFilme1);
	
		
		JRadioButton rdbtnFilme2 = new JRadioButton(listaDeFilmes.get(1).getTitulo());
		rdbtnFilme2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnFilme2.isSelected()) {
					btnFilmeAvancar.setEnabled(true);
					filmeSelecionado = listaDeFilmes.get(1);
				} 
			}
		});
		buttonGroup.add(rdbtnFilme2);
		rdbtnFilme2.setBounds(143, 270, 109, 23);
		panelFilmes.add(rdbtnFilme2);
		
		JRadioButton rdbtnFilme3 = new JRadioButton(listaDeFilmes.get(2).getTitulo());
		rdbtnFilme3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnFilme3.isSelected()) {
					btnFilmeAvancar.setEnabled(true);
					filmeSelecionado = listaDeFilmes.get(2);

				} 
			}
		});
		buttonGroup.add(rdbtnFilme3);
		rdbtnFilme3.setBounds(282, 270, 109, 23);
		panelFilmes.add(rdbtnFilme3);
		
		JRadioButton rdbtnFilme4 = new JRadioButton(listaDeFilmes.get(3).getTitulo());
		rdbtnFilme4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				if (rdbtnFilme4.isSelected()) {
					btnFilmeAvancar.setEnabled(true);
					filmeSelecionado = listaDeFilmes.get(3);
				} 
				
			}
		});
		
		buttonGroup.add(rdbtnFilme4);
		rdbtnFilme4.setBounds(417, 270, 109, 23);
		panelFilmes.add(rdbtnFilme4);

		JLabel lblPreço = new JLabel("R$34");
		lblPreço.setBounds(27, 300, 46, 14);
		panelFilmes.add(lblPreço);
	}
	
	
	public void criarAssentos() {
		
		
		JToggleButton[][] botoesAssento = new JToggleButton[4][4];
		
		if (filmeSelecionado != null) {
			listaAssentos = assentoDao.listaAssentos(filmeSelecionado);
			System.out.println(filmeSelecionado.getTitulo());
			
			
			//Adiciona os botões representando os assentos
			int k = 0;
			
			for (int i = 0; i < 4; i++) {
				
				
				for (int j = 0; j < 4; j++) {

					String nomeAssento = String.valueOf(listaAssentos.get(k++).getCodigoAssento());
					JToggleButton btn = new JToggleButton(nomeAssento);
					btn.setFont(new Font("Tahoma", Font.PLAIN, 8));
					btn.setBounds(131 + (55*j), 80 + (i*56), 45, 45);
					botoesAssento[i][j] = btn;
					panelAssentos.add(btn);

				}

				
			}
			
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
					criarPagamento();
				}
			});
			btnFilmeAvancar_1.setBounds(421, 368, 89, 23);
			panelAssentos.add(btnFilmeAvancar_1);
			

				
		}
			

	}	
	
	public void criarPagamento() {
	
		
		JRadioButton rdbtnPix = new JRadioButton("Pix");
		rdbtnPix.setBounds(194, 99, 109, 23);
		panelPagamento.add(rdbtnPix);
		
		JButton btnPgAvancar = new JButton("Avançar");
		btnPgAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CardLayout c1 = (CardLayout) panel.getLayout();
				c1.show(panel, "painelFinalizar");
				
				criarFinalizar();
				
				
				
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
		
		
	}
	
	public void criarFinalizar() {
	
		
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
	
