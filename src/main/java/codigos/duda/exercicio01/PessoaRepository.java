package codigos.duda.exercicio01;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

	public Pessoa findByNome(String nome);
	@Query(
			  value = "SELECT * FROM pessoa WHERE instituicao = ?1", 
			  nativeQuery = true)
	List<Pessoa> findAllByInstituicao(String instituicao);
}
