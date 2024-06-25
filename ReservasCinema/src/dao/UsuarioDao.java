package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import entidades.Usuario;

public class UsuarioDao {

	
	public Connection getConexao() throws ClassNotFoundException {

		// Driver
		String driver = "com.mysql.cj.jdbc.Driver";
		Class.forName(driver);

		// Banco de dados
		String url = "jdbc:mysql://localhost:3306/reserva_cinema?useTimezone=true&serverTimezone=UTC";

		// Usuario
		String user = "root";

		// Senha
		String password = "root";

		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("conectado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;

	}
	
	public int inserirUsuario(Usuario usuario) {
		
		String insert = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)";
		
		try {
			
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getEmail());
			pst.setString(3, usuario.getSenha());
			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
			int chaveGerada;
			if(rs.next()) {
				chaveGerada = rs.getInt(1);	
				return chaveGerada;
			}
			
			rs.close();
			pst.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public Usuario LogarUsuario(String email, String senha) {
		
		//Função que retorna um usuário caso ele for encontrado, se não for encontrado retorna um usuário nulo
		
		String sql = "SELECT * FROM reserva_cinema.usuario WHERE email = ?";
		
		Usuario usuarioLogado;
		
		try {
			
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, email);
			
			ResultSet rs = pst.executeQuery();
			
			
			if (rs.next() == false) {
				System.out.println("Usuario não encontrado");
				usuarioLogado = null;
			} else {
				
				String senhaCadastrada = rs.getString(4);
				
				if (senhaCadastrada.equals(senha)) {
					
					int idCadastrado = rs.getInt(1);
					String nomeCadastrado = rs.getString(2);
					String emailCadastrado = rs.getString(3);
					System.out.println("Login aprovado");
					
					usuarioLogado = new Usuario(idCadastrado, nomeCadastrado, emailCadastrado, senhaCadastrada);
					
				} else {
					System.out.println("Senha incorreta.");
					usuarioLogado = null;
					
			}
			
			}
			
			rs.close();
			pst.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			usuarioLogado = null;
		}
		
		return usuarioLogado;
	
	}
	
	
}
