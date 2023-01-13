package codigos.duda;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {

	List<Filme> findByGeneroContaining(String genero);
}
