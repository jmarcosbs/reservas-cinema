package entidades;

public class Ingresso {

	private int id;
	private int usuarioId;
	private int compraId;
	private int filmeId;
	private int assentoId;
	
	public Ingresso() {
		super();
	}

	public Ingresso(Usuario usuarioId, Compra compraId, Filme filmeId, Assento assentoId) {
		super();
		this.usuarioId = usuarioId.getId();
		this.compraId = compraId.getId();
		this.filmeId = filmeId.getId();
		this.assentoId = assentoId.getId();
	}

	public Ingresso(int id, Usuario usuarioId, Compra compraId, Filme filmeId, Assento assentoId) {
		super();
		this.id = id;
		this.usuarioId = usuarioId.getId();
		this.compraId = compraId.getId();
		this.filmeId = filmeId.getId();
		this.assentoId = assentoId.getId();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public int getCompraId() {
		return compraId;
	}

	public void setCompraId(int compraId) {
		this.compraId = compraId;
	}

	public int getFilmeId() {
		return filmeId;
	}

	public void setFilmeId(int filmeId) {
		this.filmeId = filmeId;
	}

	public int getAssentoId() {
		return assentoId;
	}

	public void setAssentoId(int assentoId) {
		this.assentoId = assentoId;
	}

	@Override
	public String toString() {
		return "Ingresso [id=" + id + ", usuarioId=" + usuarioId + ", compraId=" + compraId + ", filmeId=" + filmeId
				+ ", assentoId=" + assentoId + "]";
	}
	
	
	
	
}
