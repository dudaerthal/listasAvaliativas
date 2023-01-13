package codigos.duda;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer livroId;
	@Column(length = 100)
	private String titulo;
	@Column(length = 100)
	private String editora;
	@Column(precision = 10, scale = 2)
	private BigDecimal valor;
	private LocalDate dataLancamento;
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "livros")
	private Set<Autor> autores = new HashSet<>();

	public void adicionaAutor(Autor autor) {
		autores.add(autor);
	}

	public Integer getLivroId() {
		return livroId;
	}

	public void setLivroId(Integer livroId) {
		this.livroId = livroId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Set<Autor> getAutores() {
		return autores;
	}

	public void setAutores(Set<Autor> autores) {
		this.autores = autores;
	}

	public Livro() {
		super();
	}

	public Livro(Integer livroId, String titulo, String editora, BigDecimal valor, LocalDate dataLancamento,
			Set<Autor> autores) {
		super();
		this.livroId = livroId;
		this.titulo = titulo;
		this.editora = editora;
		this.valor = valor;
		this.dataLancamento = dataLancamento;
		this.autores = autores;
	}

	@Override
	public String toString() {
		return "ID: " + livroId + " | Título: " + titulo + " | Editora: " + editora + " | Valor: " + valor
				+ " | Data de lançamento: " + dataLancamento;
	}

}
