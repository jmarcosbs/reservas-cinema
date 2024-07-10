package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Assento;
import entidades.Compra;
import entidades.Filme;
import entidades.Ingresso;
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
	
	
	public String imprimeIngressos(Compra compra, Usuario usuario, Filme filmeSelecionado) {
		
		String insert = "SELECT * FROM reserva_cinema.ingresso WHERE FK_compra_id = ?;";
		
		String ingressosImpressos = "";
		
		AssentoDao assentoDao = new AssentoDao();
		
		try {
			
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(insert);
			pst.setInt(1, compra.getId());
			
			System.out.println("Id compra: " + compra.getId());
			
			ResultSet rs = pst.executeQuery();

			
			while (rs.next()) {
				
				ingressosImpressos += "Ingresso: " + rs.getInt(1)
									+ "\nUsuario da compra: " + usuario.getNome()
									+ "\nCompra: " + compra.getId()
									+ "\nFilme: " + filmeSelecionado.getTitulo()
									+ "\nHorário: " + filmeSelecionado.getHorario()
									+ "\nAssento: " + assentoDao.retornaCodigoAssento(rs.getInt(5))
									+ "\n-------------------------------------------\n";
				
			}
			
			ingressosImpressos += "Valor total da compra: R$" + compra.getValorCompra() + "\nForma de Pagamento: " + compra.getFormaPagamento() + "\nEnviaremos seus ingressos para o email: " + usuario.getEmail();
			
			rs.close();
			pst.close();
			con.close();
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ingressosImpressos;
	}
	
}
