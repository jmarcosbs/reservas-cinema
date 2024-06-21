package entidades;

import java.sql.Time;

public class Filme {

	private int id;
	private String titulo;
	private String sinopse;
	private float valorIngresso;
	private Time horario;
	
	public Filme() {
		super();
	}

	public Filme(String titulo, String sinopse, float valorIngresso, Time horario) {
		super();
		this.titulo = titulo;
		this.sinopse = sinopse;
		this.valorIngresso = valorIngresso;
		this.horario = horario;
	}

	public Filme(int id, String titulo, String sinopse, float valorIngresso, Time horario) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.sinopse = sinopse;
		this.valorIngresso = valorIngresso;
		this.horario = horario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public float getValorIngresso() {
		return valorIngresso;
	}

	public void setValorIngresso(float valorIngresso) {
		this.valorIngresso = valorIngresso;
	}

	public Time getHorario() {
		return horario;
	}

	public void setHorario(Time horario) {
		this.horario = horario;
	}

	@Override
	public String toString() {
		return "Filme [id=" + id + ", titulo=" + titulo + ", sinopse=" + sinopse + ", valorIngresso=" + valorIngresso
				+ ", horario=" + horario + "]";
	}
	
	
}
