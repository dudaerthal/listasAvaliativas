package codigos.duda;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;

	@PostMapping("/cadastro")
	public ResponseEntity<?> cadastraProduto(@RequestBody Produto p) {
		if (p.getNome().isEmpty()) {
			return new ResponseEntity<>("O campo nome é obrigatório.", HttpStatus.BAD_REQUEST);
		}
		if (p.getEstoque() < 0) {
			return new ResponseEntity<>("O estoque não pode ser negativo.", HttpStatus.BAD_REQUEST);
		}
		if (p.getPreco() < 0) {
			return new ResponseEntity<>("O preço não pode ser negativo.", HttpStatus.BAD_REQUEST);
		}
		repository.save(p);
		return new ResponseEntity<>("Produto cadastrado com sucesso! " + p.getId(), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscaPorId(@PathVariable(name = "id") Integer id) {
		Optional<Produto> produto = repository.findById(id);
		if (produto.isEmpty()) {
			return new ResponseEntity<>("Produto não encontrado.", HttpStatus.NOT_FOUND);
		}
		ModelMapper modelMapper = new ModelMapper();
		ProdutoDTO produtoDTO = modelMapper.map(produto.get(), ProdutoDTO.class);
		return new ResponseEntity<>(produtoDTO.toString(), HttpStatus.OK);
	}

}
