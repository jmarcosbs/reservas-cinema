package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;

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
	
}
