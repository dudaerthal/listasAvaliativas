package codigos.duda;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer autorId;
	@Column(length = 100)
	private String nome;
	@Column(length = 100)
	private String nacionalidade;
	@Column
	private LocalDate dataNascimento;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "autor_livro", joinColumns = @JoinColumn(name = "autor_id"), inverseJoinColumns = @JoinColumn(name = "livro_id"))
	private Set<Livro> livros = new HashSet<>();

	public void adicionaLivro(Livro livro) {
		livros.add(livro);
		livro.adicionaAutor(this);
	}

	public Integer getId() {
		return autorId;
	}

	public void setId(Integer id) {
		this.autorId = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Set<Livro> getLivros() {
		return livros;
	}

	public void setLivros(Set<Livro> livros) {
		this.livros = livros;
	}

	public Autor(Integer id, String nome, String nacionalidade, LocalDate dataNascimento, Set<Livro> livros) {
		super();
		this.autorId = id;
		this.nome = nome;
		this.nacionalidade = nacionalidade;
		this.dataNascimento = dataNascimento;
		this.livros = livros;
	}

	public Autor() {
		super();
	}

	@Override
	public String toString() {
		return "ID: " + autorId + " | Nome: " + nome + " | Nacionalidade: " + nacionalidade + " | Data de nascimento: "
				+ dataNascimento;
	}

}
