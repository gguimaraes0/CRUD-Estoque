package Model;

public class Produto {

	private String Codigo;
	private String Data_entrada;
	private String Local_compra;
	private String Tipo;
	private String Marca;
	private String Caracteristicas;
	private String Tamanho;
	private String Cor;
	private String Valor_etiqueta;
	private String Valor_pago;
	private String Valor_margem;
	private String Preco_sugerido;
	private String[] colunas = new String[] { "codigo", "data_entrada", "local_compra", "tipo", "marca",
			"caracteristicas", "tamanho", "cor", "valor_etiqueta", "valor_pago", "valor_margem", "preco_sugerido" };

	public Produto(String codigo) {
		this.Codigo = codigo;
	}

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		this.Codigo = codigo;
	}

	public String getDtEntrada() {
		return Data_entrada;
	}

	public void setDtEntrada(String data_entrada) {
		this.Data_entrada = data_entrada;

	}

	public String getLocalCompra() {
		return Local_compra;
	}

	public void setLocalCompra(String local_compra) {
		this.Local_compra = local_compra;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		this.Tipo = tipo;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		this.Marca = marca;
	}

	public String getCaracteristicas() {
		return Caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.Caracteristicas = caracteristicas;
	}

	public String getTamanho() {
		return Tamanho;
	}

	public void setTamanho(String tamanho) {
		this.Tamanho = tamanho;
	}

	public String getCor() {
		return Cor;
	}

	public void setCor(String cor) {
		this.Cor = cor;
	}

	public String getValorEtiqueta() {
		return Valor_etiqueta;
	}

	public void setValorEtiqueta(String valor_etiqueta) {
		this.Valor_etiqueta = valor_etiqueta;
	}

	public String getValorPago() {
		return Valor_pago;
	}

	public void setValorPago(String valor_pago) {
		this.Valor_pago = valor_pago;
	}

	public String getValorMargem() {
		return Valor_margem;
	}

	public void setValorMargem(String valor_margem) {
		this.Valor_margem = valor_margem;
	}

	public String getPrecoSugerido() {
		return Preco_sugerido;
	}

	public void setPrecoSugerido(String preco_sugerido) {
		this.Preco_sugerido = preco_sugerido;
	}

	public String[] getColunas() {
		return colunas;
	}

	public void setColunas(String[] Colunas) {
		this.colunas = Colunas;
	}

	public void ImprimirProduto() {
		System.out.printf(
				"Código: %s | Data de Entrada: %s | Local da Compra: %s | Tipo: %s | Marca: %s | Caracteristicas: %s | Tamanho: %s | Cor: %s | Valor Etiqueta: %s | Valor Pago: %s | Valor Margem: %s | Preço Sugerido: %s",
				new Object[] { getCodigo(), getDtEntrada(), getLocalCompra(), getTipo(), getMarca(),
						getCaracteristicas(), getTamanho(), getCor(), getValorEtiqueta(), getValorPago(),
						getValorMargem(), getPrecoSugerido() });
	}

	public String produtoParaString() {

		String[] texto = { getCodigo(), getDtEntrada(), getLocalCompra(), getTipo(), getMarca(), getCaracteristicas(),
				getTamanho(), getCor(), getValorEtiqueta(), getValorPago(), getValorMargem(), getPrecoSugerido(),
				"\n" };
		String a = String.join(",", texto);
		return a;
	}
}
