package view;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import dao.UsuarioDao;
import entidades.Usuario;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class NovoCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JPasswordField pssSenha;
	private JPasswordField pssRepeteSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoCadastro frame = new NovoCadastro();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NovoCadastro() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 333, 427);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setBackground(new Color(217, 217, 217));
		txtNome.setBounds(63, 93, 194, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBackground(new Color(217, 217, 217));
		txtEmail.setColumns(10);
		txtEmail.setBounds(63, 149, 194, 20);
		contentPane.add(txtEmail);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setEnabled(false);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (cadastraUsuario() == true) {
					JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuario. Tente Novamente");
				}
				
			}
		});
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBackground(new Color(136, 191, 152));
		btnCadastrar.setBounds(99, 300, 124, 41);
		contentPane.add(btnCadastrar);
	
		
		
		pssSenha = new JPasswordField();
		pssSenha.setBackground(new Color(217, 217, 217));

	         
		pssSenha.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
				
				btnCadastrar.setEnabled(verificaCamposIguais(pssSenha, pssRepeteSenha));
				
			}
			
			
			
		});
		
		pssSenha.setBounds(63, 205, 194, 20);

		contentPane.add(pssSenha);
		
		pssSenha.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {

				btnCadastrar.setEnabled(verificaCamposIguais(pssSenha, pssRepeteSenha));

				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void insertUpdate(DocumentEvent e) {

				btnCadastrar.setEnabled(verificaCamposIguais(pssSenha, pssRepeteSenha));
	
				
			}
		});;
		
		
		
		JLabel lblTenhoCadastro = new JLabel("Já sou cadastrado");
		lblTenhoCadastro.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		lblTenhoCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenhoCadastro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				dispose();
				
			}
		});
		lblTenhoCadastro.setBounds(10, 363, 296, 14);
		contentPane.add(lblTenhoCadastro);
		
		JLabel lblNovoCadastro = new JLabel("Novo Cadastro");
		lblNovoCadastro.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblNovoCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovoCadastro.setBounds(74, 21, 149, 23);
		contentPane.add(lblNovoCadastro);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		lblEmail.setBounds(63, 124, 135, 14);
		contentPane.add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.LEFT);
		lblSenha.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		lblSenha.setBounds(63, 180, 46, 14);
		contentPane.add(lblSenha);
		
		JLabel lblConfirmeASenha = new JLabel("Confirme a senha:");
		lblConfirmeASenha.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmeASenha.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		lblConfirmeASenha.setBounds(63, 236, 178, 14);
		contentPane.add(lblConfirmeASenha);
		
		pssRepeteSenha = new JPasswordField();
		pssRepeteSenha.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
				
				btnCadastrar.setEnabled(verificaCamposIguais(pssSenha, pssRepeteSenha));
				
			}
		});
		pssRepeteSenha.setBounds(63, 261, 194, 20);
		pssRepeteSenha.setBackground(new Color(217, 217, 217));

		contentPane.add(pssRepeteSenha);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		lblNome.setBounds(63, 68, 46, 14);
		contentPane.add(lblNome);
		
		pssRepeteSenha.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {

				btnCadastrar.setEnabled(verificaCamposIguais(pssSenha, pssRepeteSenha));
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
		
				
			}

			@Override
			public void insertUpdate(DocumentEvent e) {

				btnCadastrar.setEnabled(verificaCamposIguais(pssSenha, pssRepeteSenha));
				
			}
		});;
		
		txtNome.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {

				btnCadastrar.setEnabled(verificaCamposIguais(pssSenha, pssRepeteSenha));
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
		
				
			}

			@Override
			public void insertUpdate(DocumentEvent e) {

				btnCadastrar.setEnabled(verificaCamposIguais(pssSenha, pssRepeteSenha));
				
			}
		});;
		
		txtEmail.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {

				btnCadastrar.setEnabled(verificaCamposIguais(pssSenha, pssRepeteSenha));
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
		
				
			}

			@Override
			public void insertUpdate(DocumentEvent e) {

				btnCadastrar.setEnabled(verificaCamposIguais(pssSenha, pssRepeteSenha));
				
			}
		});;
		
	}
	
	public boolean verificaCamposIguais(JPasswordField campo1, JPasswordField campo2) {
		
		// Função universal que verifica se os dois campos são iguais e retorna um verdadeiro ou falso.
		
		boolean ehIgual = false;
		
		String campo1Texto = new String(campo1.getPassword());
		String campo2Texto = new String(campo2.getPassword());

		
			if(!txtNome.getText().equals("") && !txtEmail.getText().equals("") && campo1Texto.equals(campo2Texto) && !(campo1Texto.equals("") || campo2Texto.equals(""))) {
				ehIgual = true;
			} else {
				ehIgual = false;
			}

		return ehIgual;


	}
	
	public boolean cadastraUsuario() {
		
		String nome = txtNome.getText();
		String email = txtEmail.getText();
		String password = new String (pssSenha.getPassword());
		UsuarioDao usuarioDao = new UsuarioDao();
		Usuario usuario = new Usuario(nome, email, password);
		
		
		if (usuarioDao.inserirUsuario(usuario) != 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
}
