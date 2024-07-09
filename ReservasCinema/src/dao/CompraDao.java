package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import entidades.Compra;

public class CompraDao {

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
	
	
	public Compra inserirCompra(float valorCompra, String formaPagamento) {
		
		// Função que insere uma compra no banco de dados
		
		String insert = "INSERT INTO compra (valor_compra, forma_pagamento) VALUES (?, ?)";
		
		Compra compra;
		
		try {
			
			//Compra compra;
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
			pst.setFloat(1, valorCompra);
			pst.setString(2, formaPagamento);

			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
			
			int chaveGerada = 0;
			
			while ( rs.next() ) {
				
				chaveGerada = rs.getInt(1);
				
			}
			
			insert = "select * from reserva_cinema.compra WHERE id = ?";
			
			pst = con.prepareStatement(insert);
			pst.setInt(1, chaveGerada);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				
				int idCompraRt = rs.getInt(1);
				float valorCompraRt = rs.getFloat(2);
				java.sql.Timestamp dataCompraRt = rs.getTimestamp(3);
				String formaPagamentoRt = rs.getString(4);
				
				compra = new Compra(idCompraRt, valorCompraRt, dataCompraRt, formaPagamentoRt);
				
				return compra;
				
			}
			
			rs.close();
			pst.close();
			con.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}
