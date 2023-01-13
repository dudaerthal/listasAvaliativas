package codigos.duda;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFilme;
	private String titulo;
	private Integer anoLancamento;
	private Integer duracaoMinutos;
	private String genero;
	private LocalDateTime dataInsercao = LocalDateTime.now();

	public Integer getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(Integer idFilme) {
		this.idFilme = idFilme;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(Integer anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public Integer getDuracaoMinutos() {
		return duracaoMinutos;
	}

	public void setDuracaoMinutos(Integer duracaoMinutos) {
		this.duracaoMinutos = duracaoMinutos;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDateTime getDataInsercao() {
		return dataInsercao;
	}

	public void setDataInsercao(LocalDateTime dataInsercao) {
		this.dataInsercao = dataInsercao;
	}

	public Filme(Integer idFilme, String titulo, Integer anoLancamento, Integer duracaoMinutos, String genero) {
		super();
		this.idFilme = idFilme;
		this.titulo = titulo;
		this.anoLancamento = anoLancamento;
		this.duracaoMinutos = duracaoMinutos;
		this.genero = genero;
	}

	public Filme() {
		super();
	}

	@Override
	public String toString() {
		return "Filme [idFilme=" + idFilme + ", titulo=" + titulo + ", anoLancamento=" + anoLancamento
				+ ", duracaoMinutos=" + duracaoMinutos + ", genero=" + genero + ", dataInsercao=" + dataInsercao + "]";
	}

}
