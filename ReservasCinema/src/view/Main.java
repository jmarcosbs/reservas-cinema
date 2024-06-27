package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
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
	UsuarioDao usuarioDao = new UsuarioDao();
	AssentoDao assentoDao = new AssentoDao();
	FilmeDao filmeDao = new FilmeDao();
	Usuario usuarioLogado;
	List<Filme> listaDeFilmes = filmeDao.listarFilmes();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private static Filme filmeSelecionado = null;
	List<Assento> listaAssentos;
	private JPanel panelEntrar;
	

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
		
		panelEntrar = new JPanel();
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
		
		pssSenha = new JPasswordField();
		pssSenha.setBounds(180, 192, 149, 20);
		panelEntrar.add(pssSenha);
		
		JPanel panelFilmes = new JPanel();
		panel.add(panelFilmes, "painelFilmes");
		panelFilmes.setLayout(null);
		
		
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
		
		JPanel panelAssentos = new JPanel();
		panelAssentos.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
				
				
			}
		});
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
		
		
		
		panelAssentos.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				if (filmeSelecionado != null) {
				listaAssentos = assentoDao.listaAssentos(filmeSelecionado);
				System.out.println(filmeSelecionado.getTitulo());
				
				JToggleButton tglbtnA1 = new JToggleButton(listaAssentos.get(0).getCodigoAssento());
				tglbtnA1.setFont(new Font("Tahoma", Font.PLAIN, 8));
				tglbtnA1.setBounds(131, 80, 45, 45);
				panelAssentos.add(tglbtnA1);
				
				JToggleButton tglbtnA2 = new JToggleButton("A2");
				tglbtnA2.setFont(new Font("Tahoma", Font.PLAIN, 8));
				tglbtnA2.setBounds(186, 80, 45, 45);
				panelAssentos.add(tglbtnA2);
				
				JToggleButton tglbtnA3 = new JToggleButton("A3");
				tglbtnA3.setFont(new Font("Tahoma", Font.PLAIN, 8));
				tglbtnA3.setBounds(241, 80, 45, 45);
				panelAssentos.add(tglbtnA3);
				
				JToggleButton tglbtnA4 = new JToggleButton("A4");
				tglbtnA4.setFont(new Font("Tahoma", Font.PLAIN, 8));
				tglbtnA4.setBounds(296, 80, 45, 45);
				panelAssentos.add(tglbtnA4);
				
				JToggleButton tglbtnB1 = new JToggleButton("B1");
				tglbtnB1.setFont(new Font("Tahoma", Font.PLAIN, 8));
				tglbtnB1.setBounds(131, 136, 45, 45);
				panelAssentos.add(tglbtnB1);
				
				JToggleButton tglbtnB2 = new JToggleButton("B2");
				tglbtnB2.setFont(new Font("Tahoma", Font.PLAIN, 8));
				tglbtnB2.setBounds(186, 136, 45, 45);
				panelAssentos.add(tglbtnB2);
				
				JToggleButton tglbtnB3 = new JToggleButton("B3");
				tglbtnB3.setFont(new Font("Tahoma", Font.PLAIN, 8));
				tglbtnB3.setBounds(241, 136, 45, 45);
				panelAssentos.add(tglbtnB3);
				
				JToggleButton tglbtnB4 = new JToggleButton("B4");
				tglbtnB4.setFont(new Font("Tahoma", Font.PLAIN, 8));
				tglbtnB4.setBounds(296, 136, 45, 45);
				panelAssentos.add(tglbtnB4);
				
				JToggleButton tglbtnC1 = new JToggleButton("C1");
				tglbtnC1.setFont(new Font("Tahoma", Font.PLAIN, 8));
				tglbtnC1.setBounds(131, 192, 45, 45);
				panelAssentos.add(tglbtnC1);
				
				JToggleButton tglbtnC2 = new JToggleButton("C2");
				tglbtnC2.setFont(new Font("Tahoma", Font.PLAIN, 8));
				tglbtnC2.setBounds(186, 192, 45, 45);
				panelAssentos.add(tglbtnC2);
				
				JToggleButton tglbtnC3 = new JToggleButton("C3");
				tglbtnC3.setFont(new Font("Tahoma", Font.PLAIN, 8));
				tglbtnC3.setBounds(241, 192, 45, 45);
				panelAssentos.add(tglbtnC3);
				
				JToggleButton tglbtnC4 = new JToggleButton("C4");
				tglbtnC4.setFont(new Font("Tahoma", Font.PLAIN, 8));
				tglbtnC4.setBounds(296, 192, 45, 45);
				panelAssentos.add(tglbtnC4);
				
				JToggleButton tglbtnD1 = new JToggleButton("D1");
				tglbtnD1.setFont(new Font("Tahoma", Font.PLAIN, 8));
				tglbtnD1.setBounds(131, 248, 45, 45);
				panelAssentos.add(tglbtnD1);
				
				JToggleButton tglbtnD2 = new JToggleButton("D2");
				tglbtnD2.setFont(new Font("Tahoma", Font.PLAIN, 8));
				tglbtnD2.setBounds(186, 248, 45, 45);
				panelAssentos.add(tglbtnD2);
				
				JToggleButton tglbtnD3 = new JToggleButton("D3");
				tglbtnD3.setFont(new Font("Tahoma", Font.PLAIN, 8));
				tglbtnD3.setBounds(241, 248, 45, 45);
				panelAssentos.add(tglbtnD3);
				
				JToggleButton tglbtnD4 = new JToggleButton("D4");
				tglbtnD4.setFont(new Font("Tahoma", Font.PLAIN, 8));
				tglbtnD4.setBounds(296, 248, 45, 45);
				panelAssentos.add(tglbtnD4);
				
				}
				
			
			}
		});
		

		
		
				
		
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
	
	public Filme getFilmeSelecionado(JRadioButton rdbtnFilme1, JRadioButton rdbtnFilme2, JRadioButton rdbtnFilme3, JRadioButton rdbtnFilme4) {
		
		Filme filmeSelecionado;
		
		if(rdbtnFilme1.isSelected()) {
			filmeSelecionado = listaDeFilmes.get(0);
		} else if(rdbtnFilme2.isSelected()) {
			filmeSelecionado = listaDeFilmes.get(1);
		} else if(rdbtnFilme3.isSelected()) {
			filmeSelecionado = listaDeFilmes.get(2);
		} else if(rdbtnFilme4.isSelected()) {
			filmeSelecionado = listaDeFilmes.get(3);
		} else {
			filmeSelecionado = null;
		}
		
		return filmeSelecionado;
		
	}
	
	public Assento retornaAssento(List<Assento> listaDeAssentos, Filme filmeSelecionado, int indice) {
		
		Assento assento = null;
		
		if (filmeSelecionado != null) {
			
			assento = listaDeAssentos.get(indice);
			
		}
		
		return assento;
		
	}
	public JPanel getPanelEntrar() {
		return panelEntrar;
	}
}
