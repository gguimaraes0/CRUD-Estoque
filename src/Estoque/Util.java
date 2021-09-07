package Estoque;

import java.util.Scanner;

import com.google.gson.Gson;



public class Util {
	
	public static Scanner teclado = new Scanner(System.in);
	
	public static void MenuPrincipal()
	{
		System.out.println("Controle de Estoque\n");
		System.out.println("1- Listagem");
		System.out.println("2- Adicionar");
		System.out.println("3- Atualizar");
		System.out.println("4- Excluir");
		System.out.println("0- Sair\n");
	}
	
		
	public static int ValidaMenuPrincipal() {

		int result;
		try {
			teclado = new Scanner(System.in);
			result = teclado.nextInt();
		} catch (Exception ex) {
			System.out.println("Digite um número válido");
			result = 7;
		}

		if (result == 7) {
			System.out.println("Digite um número válido");
			return 7;
		}
		switch (result) {

		case 1: {
			return result;
		}
		case 2: {
			return result;
		}
		case 3: {
			return result;
		}
		case 4: {
			return result;
		}
		case 0: {
			return result;
		}
		default: {
			System.out.println("Digite um número válido");
			return 7;
		}
		}
	}
}
