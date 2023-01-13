package codigos.duda;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

	// pesquisar livros por titulo
	List<Livro> findByTituloContaining(String titulo);
	// pesquisar livros por autor
	List<Livro> findByAutoresNome(String nome);
	// pesquisar por livros no intervalo de ano de lançamento
	@Query(
			  value = "Select * from livro where year(data_lancamento) between ?1 and ?2", 
			  nativeQuery = true)
			List<Livro> findAllLivrosAnoLancamentoBetween(Integer anoInicio, Integer anoFim);

}
