package entidades;

import java.security.Timestamp;

public class Compra {

	private int id;
	private float valorCompra;
	private Timestamp dataCompra;
	private String formaPagamento;
	
	public Compra() {
		super();
	}

	public Compra(float valorCompra, String formaPagamento) {
		super();
		this.valorCompra = valorCompra;
		this.formaPagamento = formaPagamento;
	}

	public Compra(int id, float valorCompra, Timestamp dataCompra, String formaPagamento) {
		super();
		this.id = id;
		this.valorCompra = valorCompra;
		this.dataCompra = dataCompra;
		this.formaPagamento = formaPagamento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(float valorCompra) {
		this.valorCompra = valorCompra;
	}

	public Timestamp getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Timestamp dataCompra) {
		this.dataCompra = dataCompra;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", valorCompra=" + valorCompra + ", dataCompra=" + dataCompra + ", formaPagamento="
				+ formaPagamento + "]";
	}
	
	
	
}