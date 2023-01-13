package codigos.duda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjetoComponent {
	DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	@Autowired
	private AutorRepository repositorioAutor;
	@Autowired
	private LivroRepository repositorioLivro;
	@PostConstruct
	public void test() {

		final List<Livro> lista = repositorioLivro.findByAutoresNome("Colleen Hoover");
		System.out.println("ENCONTRA TODOS OS LIVROS DE UM DETERMINADO AUTOR");
		for (Livro livro : lista) {
			System.out.println(livro);
		}

		final List<Autor> lista2 = repositorioAutor.findByNomeContaining("Colleen");
		System.out.println("\nENCONTRA TODOS OS AUTORES QUE TENHAM A STRING PASSADA COMO PARÂMETRO NO NOME");
		for (Autor autor : lista2) {
			System.out.println(autor);
		}

		final List<Livro> lista3 = repositorioLivro.findByTituloContaining("Tigre");
		System.out.println("\nENCONTRA TODOS OS LIVROS QUE POSSUAM DETETRMINADA PALAVRA NO NOME");
		for (Livro livro : lista3) {
			System.out.println(livro);
		}

		String dataInicio = "25/03/2016";
		LocalDate dataInicioFormatada = LocalDate.parse(dataInicio, formatar);
		String dataFim = "21/02/2018";
		LocalDate dataFimFormatada = LocalDate.parse(dataFim, formatar);
		Integer anoInicio = dataInicioFormatada.getYear();
		Integer anoFim = dataFimFormatada.getYear();
		final List<Livro> lista4 = repositorioLivro.findAllLivrosAnoLancamentoBetween(anoInicio, anoFim);
		System.out.println("\nENCONTRA TODOS OS LIVROS LANÇADOS ENTRE DOIS ANOS");
		for (Livro livro : lista4) {
			System.out.println(livro);
		}
	}
}
