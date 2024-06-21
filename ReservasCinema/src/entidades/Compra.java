package entidades;

import java.security.Timestamp;

public class Compra {

	private int id;
	private float valorCompra;
	private Timestamp dataCompra;
	
	public Compra() {
		super();
	}

	public Compra(float valorCompra, Timestamp dataCompra) {
		super();
		this.valorCompra = valorCompra;
		this.dataCompra = dataCompra;
	}

	public Compra(int id, float valorCompra, Timestamp dataCompra) {
		super();
		this.id = id;
		this.valorCompra = valorCompra;
		this.dataCompra = dataCompra;
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

	@Override
	public String toString() {
		return "Compra [id=" + id + ", valorCompra=" + valorCompra + ", dataCompra=" + dataCompra + "]";
	}
	
	
	
}
