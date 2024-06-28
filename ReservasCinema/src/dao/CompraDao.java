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
			System.out.println("conectado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;

	}
	
	
	public int inserirCompra(float valorCompra, String formaPagamento) {
		
		Compra compra;
		
		String insert = "INSERT INTO compra (valor_compra, forma_pagamento) VALUES (?, ?)";
		
		try {
			
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
			pst.setFloat(1, valorCompra);
			pst.setString(2, formaPagamento);

			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
	        int chaveGerada = 0;
	        if (rs.next()) {
	            chaveGerada = rs.getInt(1);
	        }
			
			rs.close();
			pst.close();
			con.close();
			
			return chaveGerada;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
}
