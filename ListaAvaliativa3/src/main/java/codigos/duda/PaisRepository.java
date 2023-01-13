package codigos.duda;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<Pais, Integer>{

	List<Pais> findAllByLanguageName(String language);
}
