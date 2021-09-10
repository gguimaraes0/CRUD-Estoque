package Estoque;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.ProdutoDAO;
import Model.Produto;

public class MetodosEstoque {
	
	public static Scanner teclado = new Scanner(System.in);
	
	public static void Listar() {
		System.out.println("******~~~~~~~******\nLista de Produtos\n******~~~~~~~******\n");

		ProdutoDAO ProdutoDAO = new ProdutoDAO();
		for (Produto item : ProdutoDAO.ListarTodos())
			item.ImprimirProduto();

	}

	public static void Excluir(ArrayList<Produto> listaProdutos) {
		System.out.println("******~~~~~~~******\nExcluir Produto:\nQual o código do produto que deseja excluir?");
		ProdutoDAO ProdutoDAO = new ProdutoDAO();
		var result = "";
		result = teclado.next();
		ProdutoDAO.Deletar(result, listaProdutos);

	}

	public static void Editar(ArrayList<Produto> listaProdutos) {
		System.out.println("******~~~~~~~******\nEditar Produto:\nDigite o código do produto\n");		
		ProdutoDAO ProdutoDAO = new ProdutoDAO();
		var result = "";
		result = teclado.next();
		listaProdutos = ProdutoDAO.Editar(result, listaProdutos);
		Salvar(listaProdutos);
	}

	public static void Salvar(ArrayList<Produto> listaProdutos) {		
		Produto produto= new Produto();
		var result = "";
		
		System.out.println("******~~~~~~~******\nCadastro de produto:");
		System.out.println("Código: ");
		result = teclado.next();
		produto.setCodigo(result);
		
		ProdutoDAO ProdutoDAO = new ProdutoDAO();
		if(ProdutoDAO.Buscar(result) != null)
		{
			System.out.println("Código já cadastrado, por favor cadastre com outro código !");
			Salvar(listaProdutos);
		}

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
		
		ProdutoDAO.Salvar(listaProdutos);
	}

}
