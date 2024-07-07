package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entidades.Assento;
import entidades.Filme;

public class AssentoDao {
	
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
	
	public List<Assento> listaAssentos(Filme filmeSelecionado) {
		
		// Função que gera uma lista de Assento a partir do filme selecionado recebido como parâmetro
		
		List<Assento> listaAssentos = new ArrayList<Assento>();
		
		String sql = "SELECT * FROM reserva_cinema.assento WHERE FK_filme_id = ?;";
		
		try {
			
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, filmeSelecionado.getId());
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				
				int idAssento = rs.getInt(1);
				String codigoAssento = rs.getString(2);
				int ocupado = rs.getInt(4);
				
				// Gera um novo Assento a partir do retorno da query SQL
				Assento assento = new Assento(idAssento, codigoAssento, filmeSelecionado, ocupado);
				
				listaAssentos.add(assento);
				
			}
		
		
		rs.close();
		pst.close();
		con.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		return listaAssentos;
		
	}
	
	public void atualizarOcupado(Assento assento) {
		
		// Altera o valor "ocupado" da tabela assento do respective assento recebido para 1, ou seja, o assento fica ocupado
		
		try {
			
			String sql = "UPDATE reserva_cinema.assento SET ocupado = 1 WHERE id = ?";
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, assento.getId());
			pst.executeUpdate();
			
			
			pst.close();
			con.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public String retornaCodigoAssento(int idAssento) {
		
		// Função que retorna o código do assento que é em formato texto. Ex: A1, B2...
		
		String insert = "SELECT codigo_assento FROM reserva_cinema.assento WHERE id = ?;";
		
		String codigoAssento = null;
		
		try {
			
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(insert);
			pst.setInt(1, idAssento);
			
			ResultSet rs = pst.executeQuery();

			
			if (rs.next()) {
				
				codigoAssento = rs.getString(1);
				
			}
			
			rs.close();
			pst.close();
			con.close();
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return codigoAssento;
	}
	
}
