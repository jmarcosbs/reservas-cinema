package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entidades.Assento;
import entidades.Compra;
import entidades.Filme;
import entidades.Usuario;

public class IngressoDao {

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
	
	public int inserirIngresso(Usuario usuario, Compra compra, Filme filme, Assento assento) {
		
		String insert = "INSERT INTO ingresso (FK_usuario_id, FK_compra_id, FK_filme_id, fk_assento_id) VALUES (?, ?, ?, ?)";
		
		try {
			
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, usuario.getId());
			pst.setInt(2, compra.getId());
			pst.setInt(3, filme.getId());
			pst.setInt(4, assento.getId());
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
	
	
}
