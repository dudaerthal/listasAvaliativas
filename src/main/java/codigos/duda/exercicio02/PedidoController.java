package codigos.duda.exercicio02;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService service;

	@PostMapping
	@ResponseBody
	public String cadastrarPedido(@RequestParam BigDecimal valorPedido, Integer idGarcom, boolean gorjeta) {
		Pedido p = new Pedido(null, valorPedido, idGarcom, gorjeta);
		service.cadastrarPedido(p);
		return "Pedido cadastrado com sucesso";
	}
	
	@GetMapping("/gorjeta")
	@ResponseBody
	public BigDecimal valorGorjeta(@RequestParam("id_garcom") Integer idGarcom) {
		BigDecimal gorjeta = service.retornaGorjeta(idGarcom);
		return gorjeta;
	}
	
	@GetMapping("/maisFaturado")
	@ResponseBody
	public BigDecimal maisFaturado() {
		return service.garcomFaturou();
	}

}
