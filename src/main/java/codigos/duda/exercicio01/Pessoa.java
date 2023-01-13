package codigos.duda.exercicio01;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String instituicao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public Pessoa(Integer id, String nome, String instituicao) {
		super();
		this.id = id;
		this.nome = nome;
		this.instituicao = instituicao;
	}

	public Pessoa() {
		super();
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", instituicao=" + instituicao + "]";
	}
	
	

}
