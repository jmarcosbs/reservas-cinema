package view;

import dao.AssentoDao;
import entidades.Filme;

public abstract class teste {

	public static void main(String[] args) {
		
		Filme filmeSelecionado = new Filme(1, null, null, 0, null);
		AssentoDao assentoDao = new AssentoDao();
		assentoDao.listaAssentos(filmeSelecionado).toString();

	}

}
