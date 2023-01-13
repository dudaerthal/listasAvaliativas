package codigos.duda;

public class ProdutoDTO {

	private String nome;
	private int estoque;
	private double preco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public ProdutoDTO(String nome, int estoque, double preco) {
		super();
		this.nome = nome;
		this.estoque = estoque;
		this.preco = preco;
	}

	public ProdutoDTO() {
		super();
	}

	@Override
	public String toString() {
		return "ProdutoDTO [nome=" + nome + ", estoque=" + estoque + ", preco=" + preco + "]";
	}

}
