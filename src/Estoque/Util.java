package Estoque;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import Model.Produto;

public class Util {

	public static Scanner teclado = new Scanner(System.in);

	public static void MenuPrincipal() {
		System.out.println("Controle de Estoque\n");
		System.out.println("1- Listagem");
		System.out.println("2- Adicionar");
		System.out.println("3- Atualizar");
		System.out.println("4- Excluir");
		System.out.println("0- Sair\n");
	}

	public static Boolean ValidaMenuPrincipal(ArrayList<Produto> listaProdutos) {

		int result;
		try {
			teclado = new Scanner(System.in);
			result = teclado.nextInt();
		} catch (Exception ex) {
			System.out.println("Digite um número");
			return true;
		}

		switch (result) {
		case 1:
			MetodosEstoque.Listar();
			return true;
		case 2:
			MetodosEstoque.Salvar(listaProdutos);
			return true;
		case 3:
			MetodosEstoque.Editar(listaProdutos);
			return true;
		case 4:
			MetodosEstoque.Excluir(listaProdutos);
			return true;
		case 0:
			return false;
		default:
			System.out.println("Digite um número válido");
			return true;
		}
	}
	public static ArrayList<Produto> PreencheLista(ArrayList<Produto> listaProdutos) {
		try {
			Produto produto;
			File myObj = new File("estoque.txt");
			@SuppressWarnings("resource")
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data[] = myReader.nextLine().split(",");
				produto = new Produto(data[0]);
				produto.setDtEntrada(data[1]);
				produto.setLocalCompra(data[2]);
				produto.setTipo(data[3]);
				produto.setMarca(data[4]);
				produto.setCaracteristicas(data[5]);
				produto.setTamanho(data[6]);
				produto.setCor(data[7]);
				produto.setValorEtiqueta(data[8]);
				produto.setValorPago(data[9]);
				produto.setValorMargem(data[10]);
				produto.setPrecoSugerido(data[11]);
				listaProdutos.add(produto);
			}
		} catch (FileNotFoundException e) {
				System.out.println("Ocorreu um erro " + e);
		}		
		return listaProdutos;
	}
}
