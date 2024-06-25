package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import entidades.Filme;

public class FilmeDao {

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
	
	public List<Filme> listarFilmes() {
		
		List<Filme> listaDeFilmes = new ArrayList<Filme>();
		
		String sql = "SELECT * FROM reserva_cinema.filme";
		
		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt(1);
				String titulo = rs.getString(2);
				String sinopse = rs.getString(3);
				float valorIngresso = rs.getFloat(4);
				Time horario = rs.getTime(5);

				Filme filme = new Filme(id, titulo, sinopse, valorIngresso, horario);
				listaDeFilmes.add(filme);
				System.out.println(listaDeFilmes);
				
				
			}
			
			rs.close();
			pst.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return listaDeFilmes;
		
	}
	
}
