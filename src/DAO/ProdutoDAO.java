package DAO;

import Model.Produto;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

import com.google.gson.Gson;

import java.io.FileWriter; // Import the FileWriter class
import java.io.IOException; // Import the IOException class to handle errors

public class ProdutoDAO {
	public void Salvar(ArrayList<Produto> listaProdutos) {
		String estoque = "";

		for (Produto item : listaProdutos) {
			estoque = estoque + item.produtoParaString();
		}
		try {
			File myObj = new File("C:\\Users\\gusta\\eclipse-workspace\\CRUD-Estoque\\src\\estoque.txt");

			if (myObj.createNewFile())
				System.out.println("Arquivo Criado: " + myObj.getName());

			FileWriter myWriter = new FileWriter("C:\\Users\\gusta\\eclipse-workspace\\CRUD-Estoque\\src\\estoque.txt");
			myWriter.write(estoque);
			myWriter.close();
			System.out.println("Estoque salvo com sucesso!");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public void SalvarProduto(Produto produto) {

		ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

		if (Buscar(produto.getCodigo()) == null) {
			listaProdutos.add(produto);
			Salvar(listaProdutos);
		}
	}

	public void Deletar(Produto produto) {

		ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
		listaProdutos = ListarTodos();

		for (Produto item : listaProdutos) {
			if (item.getCodigo().equals(produto.getCodigo())) {
				listaProdutos.remove(item);
			}
			Salvar(listaProdutos);

			System.out.println("Produto foi removido!");
			return;
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

	public ArrayList<Produto> editar(Produto objProd) {

		ArrayList<Produto> dado = new ArrayList<Produto>();
		dado = ListarTodos();

		int i;

		for (Produto a : dado) {
			if (a.getCodigo().equals(Buscar(objProd.getCodigo()).getCodigo()))
				dado.remove(dado.indexOf(a));
			break;
		}

		dado.add(objProd);

		return dado;
	}

	public ArrayList<String> listaProdutosString = new ArrayList<String>();
	
	public ArrayList<Produto> ListarTodos() {
		try {
			ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
			Produto produto;			
			
			File myObj = new File("C:\\Users\\gusta\\eclipse-workspace\\CRUD-Estoque\\src\\estoque.txt");
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
				
			//	Gson json = new Gson();
				//String result = json.toJson(produto);
				
			//	listaProdutosString.add(result);
						
				//var c = a.fromJson(b, Produto.class);
				
				
				listaProdutos.add(produto);
			}

			return listaProdutos;
		} catch (FileNotFoundException e) {
			e.getMessage();
			System.out.println("Ocorreu um Erro, retornando... é aqui "+e.toString());
			return null;
		}
	}

}
