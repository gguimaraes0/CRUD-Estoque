package Estoque;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors

import com.google.gson.Gson;

import DAO.ProdutoDAO;
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
			Listar();
			return true;

		case 2:
			Salvar(listaProdutos);
			return true;

		case 3:
			Editar(listaProdutos);
			return true;

		case 4:
			Excluir(listaProdutos);
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

		}
		
		return listaProdutos;
	}

	public static void Listar() {
		System.out.println("******~~~~~~~******\nLista de Produtos\n******~~~~~~~******\n");

		ProdutoDAO x = new ProdutoDAO();
		for (Produto a : x.ListarTodos())
			a.ImprimirProduto();

	}

	public static void Excluir(ArrayList<Produto> listaProdutos) {
		System.out.println("******~~~~~~~******\nExcluir Produto:\nQual o código do produto que deseja excluir?");
		ProdutoDAO x = new ProdutoDAO();
		var result = "";
		result = teclado.next();
		x.Deletar(result, listaProdutos);

	}

	public static void Editar(ArrayList<Produto> listaProdutos) {
		System.out.println("******~~~~~~~******\nEditar Produto:\nCadsastre o produto novamente para editar\n");
		Salvar(listaProdutos);
	}

	public static void Salvar(ArrayList<Produto> listaProdutos) {		
		Produto produto= new Produto();
		var result = "";
		
		System.out.println("******~~~~~~~******\nCadastro de produto:");
		System.out.println("Código: ");
		result = teclado.next();
		produto.setCodigo(result);

		System.out.println("Data de Entrada: ");
		result = teclado.next();
		produto.setDtEntrada(result);

		System.out.println("Local Compra: ");
		result = teclado.next();
		produto.setLocalCompra(result);

		System.out.println("Tipo: ");
		result = teclado.next();
		produto.setTipo(result);

		System.out.println("Marca: ");
		result = teclado.next();
		produto.setMarca(result);

		System.out.println("Caracteristicas: ");
		result = teclado.next();
		produto.setCaracteristicas(result);

		System.out.println("Tamanho: ");
		result = teclado.next();
		produto.setTamanho(result);

		System.out.println("Cor: ");
		result = teclado.next();
		produto.setCor(result);

		System.out.println("Valor Etiqueta: ");
		result = teclado.next();
		produto.setValorEtiqueta(result);

		System.out.println("Valor Pago: ");
		result = teclado.next();
		produto.setValorPago(result);

		System.out.println("Preço Sugerido: ");
		result = teclado.next();		
		produto.setPrecoSugerido(result);

		produto.setValorMargem(String.valueOf(Integer.valueOf(produto.getValorPago()) * 2));

		listaProdutos.add(produto);
		
		ProdutoDAO x = new ProdutoDAO();
		x.Salvar(listaProdutos);

	}
}
