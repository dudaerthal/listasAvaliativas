package codigos.duda;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
	// acha todos os autores pelo nome
	List<Autor> findByNomeContaining(String nome);
}
