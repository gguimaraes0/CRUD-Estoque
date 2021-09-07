package Estoque;

public class Produto {
	public int Cod;
	public String Data;
	public String local;

	public enum tipo{
	        Vestido,
	        Saia,
	        Camiseta,
	        Calça,
	        Short,
	        Meia
	    };

	public enum marca {
		Nike, Adidas, Puma, Kappa, Penalty
	};

	public enum tamanho {
		P, M, G, GG
	};

	public String cor;
	public float valorEtiqueta;
	public float valorCompra;
	public float valorMargem;
	public float Preco;

}
