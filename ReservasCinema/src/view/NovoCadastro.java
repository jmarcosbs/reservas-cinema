package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class NovoCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JPasswordField pssSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoCadastro frame = new NovoCadastro();
					frame.setVisible(true);
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
		setBounds(100, 100, 322, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setText("Nome");
		txtNome.setBounds(54, 66, 194, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setText("Email");
		txtEmail.setColumns(10);
		txtEmail.setBounds(54, 108, 194, 20);
		contentPane.add(txtEmail);
		
		pssSenha = new JPasswordField();
		pssSenha.setBounds(54, 155, 194, 20);
		contentPane.add(pssSenha);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//cadastraUsuario
				
			}
		});
		btnCadastrar.setBounds(109, 212, 89, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblTenhoCadastro = new JLabel("Já tenho cadastro");
		lblTenhoCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenhoCadastro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				dispose();
				
			}
		});
		lblTenhoCadastro.setBounds(0, 273, 296, 14);
		contentPane.add(lblTenhoCadastro);
		
		JLabel lblNovoCadastro = new JLabel("Novo Cadastro");
		lblNovoCadastro.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNovoCadastro.setBounds(54, 21, 149, 23);
		contentPane.add(lblNovoCadastro);
	}
}
