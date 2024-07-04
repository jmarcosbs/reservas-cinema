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
import dao.CompraDao;
import dao.FilmeDao;
import dao.IngressoDao;
import dao.UsuarioDao;
import entidades.Usuario;
import entidades.Assento;
import entidades.Compra;
import entidades.Filme;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {

	private JFrame frame;
	private JTextField txtEmail;
	private JPasswordField pssSenha;
	private UsuarioDao usuarioDao = new UsuarioDao();
	private AssentoDao assentoDao = new AssentoDao();
	private IngressoDao ingressoDao = new IngressoDao();
	private CompraDao compraDao = new CompraDao();
	private FilmeDao filmeDao = new FilmeDao();
	private Usuario usuarioLogado;
	private List<Filme> listaDeFilmes = filmeDao.listarFilmes();
	private final ButtonGroup bgFilmes = new ButtonGroup();
	private final ButtonGroup bgPagamento = new ButtonGroup();
	private Filme filmeSelecionado = null;
	private List<Assento> listaAssentos;
	private JToggleButton[][] botoesAssento = new JToggleButton[4][4];
	private JPanel panel = new JPanel();
	private JPanel panelEntrar = new JPanel();
	private JPanel panelFilmes = new JPanel();
	private JPanel panelAssentos = new JPanel();
	private JPanel panelPagamento = new JPanel();
	private JPanel panelFinalizar = new JPanel();
	private Compra compra;
	private String formaPagamento;
	private List<Assento> assentosSelecionados;

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
		frame.setBounds(100, 100, 560, 480);
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel.setBounds(0, 0, 539, 415);
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));

		panel.add(panelEntrar, "painelEntrar");
		panelEntrar.setLayout(null);
		panelEntrar.setBackground(new Color(255, 255, 255));

		panel.add(panelFilmes, "painelFilmes");
		panelFilmes.setLayout(null);
		panelEntrar.setBackground(new Color(255, 255, 255));

		panel.add(panelAssentos, "painelAssentos");
		panelAssentos.setLayout(null);
		
		JLabel lblLegenda = new JLabel("Legenda:");
		lblLegenda.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		lblLegenda.setBounds(223, 313, 126, 14);
		panelAssentos.add(lblLegenda);
		
		JLabel lblOcupado = new JLabel("Ocupado");
		lblOcupado.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		lblOcupado.setBounds(270, 344, 79, 14);
		panelAssentos.add(lblOcupado);
		
		JLabel lblDisponivel = new JLabel("Disponível");
		lblDisponivel.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		lblDisponivel.setBounds(270, 364, 79, 14);
		panelAssentos.add(lblDisponivel);
		
		JButton btnOcupado = new JButton("");
		Color vermelho = Color.decode("#fd4d4d");
		btnOcupado.setBackground(vermelho);
		btnOcupado.setBounds(223, 335, 43, 23);
		panelAssentos.add(btnOcupado);
		
		JButton btnDisponivel = new JButton("");
		Color verde = Color.decode("#33ff66");		
		btnDisponivel.setBackground(verde);
		btnDisponivel.setBounds(223, 359, 43, 23);
		panelAssentos.add(btnDisponivel);

		panel.add(panelPagamento, "painelPagamento");
		panelPagamento.setLayout(null);
		panelEntrar.setBackground(new Color(255, 255, 255));

		panel.add(panelFinalizar, "painelFinalizar");
		panelFinalizar.setLayout(null);
		panelEntrar.setBackground(new Color(255, 255, 255));

		criarEntrar();

	}

	public void criarEntrar() {

		adicionarCabecalho(panelEntrar, 1);

		JButton btnLogin = new JButton("Entrar");
		btnLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	                    btnLogin.doClick();
	                }
			}
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Transformando char[] senha em String
				String senha = new String(pssSenha.getPassword());

				// Obtendo texto do campo email
				String email = txtEmail.getText();

				usuarioLogado = usuarioDao.LogarUsuario(email, senha);
				if (usuarioLogado != null) {
					JOptionPane.showMessageDialog(null, "Bem-vindo(a), " + usuarioLogado.getNome() + "!");
					CardLayout c1 = (CardLayout) panel.getLayout();
					c1.show(panel, "painelFilmes");
					criarFilmes();
				} else {
					JOptionPane.showMessageDialog(null, "Informações inválidas");
				}

			}
		});
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(136, 191, 152));
		btnLogin.setBounds(205, 292, 120, 42);
		panelEntrar.add(btnLogin);

		txtEmail = new JTextField();
//		txtEmail.setText("admin");
		txtEmail.setBackground(new Color(217, 217, 217));
		txtEmail.setBounds(167, 154, 196, 34);
		txtEmail.setColumns(10);
		panelEntrar.add(txtEmail);

		JLabel titulo = new JLabel("Ingressos para o cinema");
		titulo.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(0, 75, 537, 34);
		panelEntrar.add(titulo);

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

		JLabel lblSemCadastro = new JLabel("Criar cadastro");
		lblSemCadastro.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		lblSemCadastro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				NovoCadastro telaCadastro = new NovoCadastro();
				telaCadastro.setVisible(true);

			}
		});
		lblSemCadastro.setForeground(new Color(0, 0, 0));
		lblSemCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lblSemCadastro.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		lblSemCadastro.setBounds(0, 354, 537, 34);
		panelEntrar.add(lblSemCadastro);

		pssSenha = new JPasswordField();
//		pssSenha.setText("admin");
		pssSenha.setColumns(10);
		pssSenha.setBackground(new Color(217, 217, 217));
		pssSenha.setBounds(167, 228, 196, 34);
		panelEntrar.add(pssSenha);

	}

	public void criarFilmes() {

		adicionarCabecalho(panelFilmes, 2);

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
		btnFilmeAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CardLayout c1 = (CardLayout) panel.getLayout();
				c1.show(panel, "painelAssentos");
				criarAssentos();

			}
		});

		btnFilmeAvancar.setForeground(new Color(255, 255, 255));
		btnFilmeAvancar.setBackground(new Color(136, 191, 152));
		btnFilmeAvancar.setBounds(411, 361, 99, 29);
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

		bgFilmes.add(rdbtnFilme1);
		rdbtnFilme1.setFont(new Font("Bahnschrift", Font.BOLD, 11));
		rdbtnFilme1.setBounds(10, 250, 109, 23);
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
		bgFilmes.add(rdbtnFilme2);
		rdbtnFilme2.setBounds(143, 250, 109, 23);
		rdbtnFilme2.setFont(new Font("Bahnschrift", Font.BOLD, 11));
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
		bgFilmes.add(rdbtnFilme3);
		rdbtnFilme3.setFont(new Font("Bahnschrift", Font.BOLD, 11));
		rdbtnFilme3.setBounds(282, 250, 109, 23);
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

		bgFilmes.add(rdbtnFilme4);
		rdbtnFilme4.setBounds(417, 250, 109, 23);
		rdbtnFilme4.setFont(new Font("Bahnschrift", Font.BOLD, 11));
		panelFilmes.add(rdbtnFilme4);

		JLabel lblPreco1 = new JLabel("Preço: R$" + listaDeFilmes.get(0).getValorIngresso());
		lblPreco1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPreco1.setFont(new Font("Bahnschrift", Font.BOLD, 11));
		lblPreco1.setBounds(10, 291, 109, 14);
		panelFilmes.add(lblPreco1);

		JLabel lblHorario1 = new JLabel("Horário: " + listaDeFilmes.get(0).getHorario());
		lblHorario1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHorario1.setFont(new Font("Bahnschrift", Font.BOLD, 11));
		lblHorario1.setBounds(10, 316, 109, 14);
		panelFilmes.add(lblHorario1);

		JLabel lblPreco2 = new JLabel("Preço: R$" + listaDeFilmes.get(1).getValorIngresso());
		lblPreco2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPreco2.setFont(new Font("Bahnschrift", Font.BOLD, 11));
		lblPreco2.setBounds(143, 291, 109, 14);
		panelFilmes.add(lblPreco2);

		JLabel lblHorario2 = new JLabel("Horário: " + listaDeFilmes.get(1).getHorario());
		lblHorario2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHorario2.setFont(new Font("Bahnschrift", Font.BOLD, 11));
		lblHorario2.setBounds(143, 316, 109, 14);
		panelFilmes.add(lblHorario2);

		JLabel lblPreco3 = new JLabel("Preço: R$" + listaDeFilmes.get(2).getValorIngresso());
		lblPreco3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPreco3.setFont(new Font("Bahnschrift", Font.BOLD, 11));
		lblPreco3.setBounds(282, 291, 109, 14);
		panelFilmes.add(lblPreco3);

		JLabel lblHorario3 = new JLabel("Horário: " + listaDeFilmes.get(2).getHorario());
		lblHorario3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHorario3.setFont(new Font("Bahnschrift", Font.BOLD, 11));
		lblHorario3.setBounds(282, 316, 109, 14);
		panelFilmes.add(lblHorario3);

		JLabel lblPreco4 = new JLabel("Preço: R$" + listaDeFilmes.get(3).getValorIngresso());
		lblPreco4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPreco4.setFont(new Font("Bahnschrift", Font.BOLD, 11));
		lblPreco4.setBounds(401, 291, 109, 14);
		panelFilmes.add(lblPreco4);

		JLabel lblHorario4 = new JLabel("Horário: " + listaDeFilmes.get(3).getHorario());
		lblHorario4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHorario4.setFont(new Font("Bahnschrift", Font.BOLD, 11));
		lblHorario4.setBounds(401, 316, 109, 14);
		panelFilmes.add(lblHorario4);

	}

	public void criarAssentos() {

		adicionarCabecalho(panelAssentos, 3);

		if (filmeSelecionado != null) {
			listaAssentos = assentoDao.listaAssentos(filmeSelecionado);

			// Adiciona os botões representando os assentos
			int k = 0;

			for (int i = 0; i < 4; i++) {

				for (int j = 0; j < 4; j++) {

					String nomeAssento = String.valueOf(listaAssentos.get(k++).getCodigoAssento());
					JToggleButton btn = new JToggleButton(nomeAssento);
					btn.setFont(new Font("Tahoma", Font.PLAIN, 8));
					btn.setBounds(162 + (55 * j), 80 + (i * 56), 45, 45);
					botoesAssento[i][j] = btn;
					panelAssentos.add(btn);

						
					}
				}

			}

			desabilitaAssentosOcupados();

			JButton btnFilmeVoltar_1 = new JButton("Voltar");
			btnFilmeVoltar_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					CardLayout c1 = (CardLayout) panel.getLayout();
					c1.show(panel, "painelFilmes");

				}
			});
			btnFilmeVoltar_1.setBounds(31, 368, 89, 23);
			btnFilmeVoltar_1.setForeground(new Color(255, 255, 255));
			btnFilmeVoltar_1.setBackground(new Color(192, 192, 192));
			panelAssentos.add(btnFilmeVoltar_1);

			JButton btnFilmeAvancar_1 = new JButton("Avançar");
			btnFilmeAvancar_1.setEnabled(true);
			btnFilmeAvancar_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					CardLayout c1 = (CardLayout) panel.getLayout();
					c1.show(panel, "painelPagamento");
					assentosSelecionados = assentosSelecionado();
					criarPagamento();
				}
			});

			btnFilmeAvancar_1.setForeground(new Color(255, 255, 255));
			btnFilmeAvancar_1.setBackground(new Color(136, 191, 152));
			btnFilmeAvancar_1.setBounds(421, 368, 89, 23);
			panelAssentos.add(btnFilmeAvancar_1);

		}

	

	public void criarPagamento() {

		adicionarCabecalho(panelPagamento, 4);

		JRadioButton rdbtnPix = new JRadioButton("Pix");
		rdbtnPix.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		rdbtnPix.setBounds(194, 150, 109, 23);
		panelPagamento.add(rdbtnPix);
		bgPagamento.add(rdbtnPix);

		JRadioButton rdbtnCredito = new JRadioButton("Cartão de Crédito");
		rdbtnCredito.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		rdbtnCredito.setBounds(194, 175, 150, 30);
		panelPagamento.add(rdbtnCredito);
		bgPagamento.add(rdbtnCredito);

		JRadioButton rdbtnDebito = new JRadioButton("Cartão de Débito");
		rdbtnDebito.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		rdbtnDebito.setBounds(194, 200, 150, 30);
		panelPagamento.add(rdbtnDebito);
		bgPagamento.add(rdbtnDebito);

		JButton btnPgAvancar = new JButton("Avançar");
		btnPgAvancar.setEnabled(false);
		btnPgAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CardLayout c1 = (CardLayout) panel.getLayout();
				c1.show(panel, "painelFinalizar");

				if (rdbtnPix.isSelected()) {
					formaPagamento = "pix";
				} else if (rdbtnCredito.isSelected()) {
					formaPagamento = "credito";
				} else if (rdbtnDebito.isSelected()) {
					formaPagamento = "debito";
				} else {
					formaPagamento = null;
				}

				finalizarCompra();

				criarFinalizar();

			}
		});

		btnPgAvancar.setForeground(new Color(255, 255, 255));
		btnPgAvancar.setBackground(new Color(136, 191, 152));
		btnPgAvancar.setBounds(407, 311, 89, 23);
		btnPgAvancar.setEnabled(false);
		panelPagamento.add(btnPgAvancar);

		rdbtnPix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnPix.isSelected()) {
					btnPgAvancar.setEnabled(true);
					filmeSelecionado = listaDeFilmes.get(1);
				}
			}
		});

		rdbtnCredito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnCredito.isSelected()) {
					btnPgAvancar.setEnabled(true);
					filmeSelecionado = listaDeFilmes.get(1);
				}
			}
		});

		rdbtnDebito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnDebito.isSelected()) {
					btnPgAvancar.setEnabled(true);
					filmeSelecionado = listaDeFilmes.get(1);
				}
			}
		});

		JButton btnPgVoltar = new JButton("Voltar");
		btnPgVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CardLayout c1 = (CardLayout) panel.getLayout();
				c1.show(panel, "painelAssentos");

			}
		});

		btnPgVoltar.setForeground(new Color(255, 255, 255));
		btnPgVoltar.setBackground(new Color(192, 192, 192));
		btnPgVoltar.setBounds(308, 311, 89, 23);
		panelPagamento.add(btnPgVoltar);
	}

	public void criarFinalizar() {

		adicionarCabecalho(panelFinalizar, 5);

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

	public List<Assento> assentosSelecionado() {

		List<Assento> assentosSelecionado = new ArrayList<Assento>();

		for (int i = 0; i < botoesAssento.length; i++) {

			for (int j = 0; j < botoesAssento.length; j++) {

				JToggleButton botao = botoesAssento[i][j];

				if (botao.isSelected()) {

					String codigoAssento = botoesAssento[i][j].getText();

					for (Assento assento : listaAssentos) {

						if (assento.getCodigoAssento() == codigoAssento) {

							assentosSelecionado.add(assento);

						}

					}

				}

			}

		}

		return assentosSelecionado;

	}

	public void desabilitaAssentosOcupados() {

		for (Assento assento : listaAssentos) {

			if (assento.getOcupado() == 1) {

				for (int i = 0; i < botoesAssento.length; i++) {

					for (int j = 0; j < botoesAssento.length; j++) {

						JToggleButton botao = botoesAssento[i][j];

						if (botao.getText() == assento.getCodigoAssento()) {

							botao.setEnabled(false);
							Color vermelho = Color.decode("#fd4d4d");
							botao.setBackground(vermelho);
						} 
	                    }

					}

				} else if (assento.getOcupado() == 0) {

					for (int i = 0; i < botoesAssento.length; i++) {

						for (int j = 0; j < botoesAssento.length; j++) {
					JToggleButton botao = botoesAssento[i][j];
					Color verde = Color.decode("#33ff66");
					botao.setBackground(verde);
			} 


			}

		}
		}
	}
	

	public void finalizarCompra() {

		float valorIngresso = filmeSelecionado.getValorIngresso();
		int quantidadeIngressos = assentosSelecionados.size();
		float valorCompra = valorIngresso * quantidadeIngressos;

		compra = compraDao.inserirCompra(valorCompra, formaPagamento);

		for (Assento assento : assentosSelecionados) {

			ingressoDao.inserirIngresso(usuarioLogado, compra, filmeSelecionado, assento);
			assentoDao.atualizarOcupado(assento);

		}

	}

	public void adicionarCabecalho(JPanel panel, int posicaoVerde) {

		JLabel lblNomeProgresso1 = new JLabel("Entrar");
		lblNomeProgresso1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeProgresso1.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblNomeProgresso1.setBounds(46, 21, 46, 28);
		panel.add(lblNomeProgresso1);

		JLabel lblIconProgresso1 = new JLabel("New label");
		lblIconProgresso1.setIcon(new ImageIcon(
				"C:\\Users\\joao.silva117\\Documents\\GitHub\\reservas-cinema\\ReservasCinema\\src\\imagens\\cinza.png"));
		lblIconProgresso1.setBounds(25, 25, 19, 19);
		panel.add(lblIconProgresso1);

		JLabel lblNomeProgresso2 = new JLabel("Filmes");
		lblNomeProgresso2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeProgresso2.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblNomeProgresso2.setBounds(141, 21, 51, 28);
		panel.add(lblNomeProgresso2);

		JLabel lblIconProgresso2 = new JLabel("New label");
		lblIconProgresso2.setIcon(new ImageIcon(
				"C:\\Users\\joao.silva117\\Documents\\GitHub\\reservas-cinema\\ReservasCinema\\src\\imagens\\cinza.png"));
		lblIconProgresso2.setBounds(117, 25, 19, 19);
		panel.add(lblIconProgresso2);

		JLabel lblNomeProgresso3 = new JLabel("Assentos");
		lblNomeProgresso3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeProgresso3.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblNomeProgresso3.setBounds(235, 21, 57, 28);
		panel.add(lblNomeProgresso3);

		JLabel lblIconProgresso3 = new JLabel("New label");
		lblIconProgresso3.setIcon(new ImageIcon(
				"C:\\Users\\joao.silva117\\Documents\\GitHub\\reservas-cinema\\ReservasCinema\\src\\imagens\\cinza.png"));
		lblIconProgresso3.setBounds(209, 25, 19, 19);
		panel.add(lblIconProgresso3);

		JLabel lblNomeProgresso4 = new JLabel("Pagamento");
		lblNomeProgresso4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeProgresso4.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblNomeProgresso4.setBounds(339, 21, 76, 28);
		panel.add(lblNomeProgresso4);

		JLabel lblIconProgresso4 = new JLabel("Pagamento");
		lblIconProgresso4.setIcon(new ImageIcon(
				"C:\\Users\\joao.silva117\\Documents\\GitHub\\reservas-cinema\\ReservasCinema\\src\\imagens\\cinza.png"));
		lblIconProgresso4.setBounds(314, 25, 19, 19);
		panel.add(lblIconProgresso4);

		JLabel lblIconProgresso5 = new JLabel("Pagamento");
		lblIconProgresso5.setIcon(new ImageIcon(
				"C:\\Users\\joao.silva117\\Documents\\GitHub\\reservas-cinema\\ReservasCinema\\src\\imagens\\cinza.png"));
		lblIconProgresso5.setBounds(429, 25, 19, 19);
		panel.add(lblIconProgresso5);

		JLabel lblNomeProgresso5 = new JLabel("Recibos");
		lblNomeProgresso5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeProgresso5.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblNomeProgresso5.setBounds(456, 21, 51, 28);
		panel.add(lblNomeProgresso5);

		switch (posicaoVerde) {
		case 1: {
			lblIconProgresso1.setIcon(new ImageIcon(
					"C:\\Users\\joao.silva117\\Documents\\GitHub\\reservas-cinema\\ReservasCinema\\src\\imagens\\verde.png"));
			break;
		}
		case 2: {
			lblIconProgresso2.setIcon(new ImageIcon(
					"C:\\Users\\joao.silva117\\Documents\\GitHub\\reservas-cinema\\ReservasCinema\\src\\imagens\\verde.png"));
			break;
		}
		case 3: {
			lblIconProgresso3.setIcon(new ImageIcon(
					"C:\\Users\\joao.silva117\\Documents\\GitHub\\reservas-cinema\\ReservasCinema\\src\\imagens\\verde.png"));
			break;
		}
		case 4: {
			lblIconProgresso4.setIcon(new ImageIcon(
					"C:\\Users\\joao.silva117\\Documents\\GitHub\\reservas-cinema\\ReservasCinema\\src\\imagens\\verde.png"));
			break;
		}
		case 5: {
			lblIconProgresso5.setIcon(new ImageIcon(
					"C:\\Users\\joao.silva117\\Documents\\GitHub\\reservas-cinema\\ReservasCinema\\src\\imagens\\verde.png"));
			break;
		}

		default:
			throw new IllegalArgumentException("Unexpected value: " + posicaoVerde);
		}

	}
}
