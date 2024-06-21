package entidades;

public class Assento {

	private int id;
	private String codigoAssento;
	private int filmeId;
	private int ocupado;
	
	public Assento() {
		super();
	}

	public Assento(String codigoAssento, Filme filme, int ocupado) {
		super();
		this.codigoAssento = codigoAssento;
		this.filmeId = filme.getId();
		this.ocupado = ocupado;
	}

	public Assento(int id, String codigoAssento, Filme filme, int ocupado) {
		super();
		this.id = id;
		this.codigoAssento = codigoAssento;
		this.filmeId = filme.getId();
		this.ocupado = ocupado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigoAssento() {
		return codigoAssento;
	}

	public void setCodigoAssento(String codigoAssento) {
		this.codigoAssento = codigoAssento;
	}

	public int getFilmeId() {
		return filmeId;
	}

	public void setFilmeId(int filmeId) {
		this.filmeId = filmeId;
	}

	public int getOcupado() {
		return ocupado;
	}

	public void setOcupado(int ocupado) {
		this.ocupado = ocupado;
	}

	@Override
	public String toString() {
		return "Assento [id=" + id + ", codigoAssento=" + codigoAssento + ", filmeId=" + filmeId + ", ocupado="
				+ ocupado + "]";
	}
	
	
	
	
}
