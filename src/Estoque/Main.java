package Estoque;

import java.util.ArrayList;
import Model.Produto;

public class Main {

	public static void main(String[] args) {
		Boolean loop = true;
		ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

		listaProdutos = Util.PreencheLista(listaProdutos);

		while (loop) {
			Util.MenuPrincipal();

			loop = Util.ValidaMenuPrincipal(listaProdutos);
		}
		listaProdutos = Util.PreencheLista(listaProdutos);
	}
}