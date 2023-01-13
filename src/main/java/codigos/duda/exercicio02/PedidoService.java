package codigos.duda.exercicio02;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;

	public void cadastrarPedido(Pedido p) {
		repository.save(p);
	}

	public BigDecimal retornaGorjeta(Integer idGarcom) {
		BigDecimal bd = repository.gorjetaPorGarcom(idGarcom);
		BigDecimal a = bd.divide(BigDecimal.valueOf(100.00));
		BigDecimal gorjeta = a.multiply(BigDecimal.valueOf(10.0));
		return gorjeta;
	}
	
	public BigDecimal garcomFaturou() {
		return repository.garcomMaisFaturado();
	}

}
