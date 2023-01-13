package codigos.duda.exercicio02;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

	@Query(value = "SELECT SUM(p.valor_pedido) FROM pedido p WHERE p.id IN (SELECT id FROM pedido WHERE id_garcom = ?1 AND gorjeta = true);", nativeQuery = true)
	BigDecimal gorjetaPorGarcom(Integer idGarcom);

	@Query(value = "SELECT id_garcom, SUM(valor_pedido) AS soma FROM pedido GROUP BY id_garcom ORDER BY soma DESC LIMIT 1;", nativeQuery = true)
	BigDecimal garcomMaisFaturado();

}
