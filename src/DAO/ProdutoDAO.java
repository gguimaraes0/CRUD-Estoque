package DAO;

import Model.Produto;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileWriter; // Import the FileWriter class
import java.io.IOException; // Import the IOException class to handle errors

public class ProdutoDAO {
	public void Salvar(ArrayList<Produto> listaProdutos) {
		String estoque = "";

		for (Produto item : listaProdutos) {
			estoque += item.produtoParaString();
		}
		try {
			File myObj = new File("estoque.txt");

			if (myObj.createNewFile())
				System.out.println("Arquivo Criado: " + myObj.getName());

			FileWriter myWriter = new FileWriter("estoque.txt");
			myWriter.write(estoque);
			myWriter.close();
			System.out.println("Estoque salvo com sucesso!");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public void Deletar(String codigo, ArrayList<Produto> listaProdutos) {
		for (Produto item : listaProdutos) {
			if (item.getCodigo().equals(codigo)) {
				listaProdutos.remove(item);
				System.out.println("Produto foi removido!");
				Salvar(listaProdutos);
				return;
			}
		}
		System.out.println("Produto não foi encontrado!");
	}

	public Produto Buscar(String codigo) {
		ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
		listaProdutos = ListarTodos();
		for (Produto item : listaProdutos) {
			if (item.getCodigo().equals(codigo)) {
				return item;
			}
		}
		return null;
	}

	public ArrayList<Produto> Editar(String codigo, ArrayList<Produto> listaProdutos) {

		Produto produto = Buscar(codigo);
		if ((produto != null)) {
			produto.ImprimirProduto();
			Deletar(produto.getCodigo(),listaProdutos);
		}
		System.out.println("Nenhum código encontrado");
		return listaProdutos;
	}

	public ArrayList<Produto> ListarTodos() {
		try {
			ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
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
			return listaProdutos;
		} catch (FileNotFoundException e) {
			e.getMessage();
			System.out.println("Ocorreu um Erro " + e.toString());
			return null;
		}
	}
}
