package codigos.duda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

	@Autowired
	public FilmeRepository repo;

	@PostMapping
	@ResponseBody
	public ResponseEntity<Filme> teste(@RequestBody Filme filmeJSON) {

		if (filmeJSON.getTitulo().length() < 2) {
			return new ResponseEntity<>(filmeJSON, HttpStatus.BAD_REQUEST);
		}
		if (filmeJSON.getGenero().length() < 2) {
			return new ResponseEntity<>(filmeJSON, HttpStatus.BAD_REQUEST);
		}
		if ((!(filmeJSON.getAnoLancamento() >= 1890)) && (!(filmeJSON.getAnoLancamento() <= 2032))) {
			return new ResponseEntity<>(filmeJSON, HttpStatus.BAD_REQUEST);
		}
		if (!(filmeJSON.getDuracaoMinutos() > 0)) {
			return new ResponseEntity<>(filmeJSON, HttpStatus.BAD_REQUEST);
		}
		repo.save(filmeJSON);
		return new ResponseEntity<>(filmeJSON, HttpStatus.OK);
	}

	@GetMapping("/{genero}")
	@ResponseBody
	public List<Filme> filmePorGenero(@PathVariable(name = "genero") String genero) {
		final List<Filme> filmePorGenero = repo.findByGeneroContaining(genero);
		return filmePorGenero;
	}

	@GetMapping
	@ResponseBody
	public List<Filme> tituloEmOrdem(@RequestParam(name = "ordem") String ordem) {
		List<Filme> tituloEmOrdem = null;
		if (ordem.equalsIgnoreCase("asc")) {
			tituloEmOrdem = repo.findAll(Sort.by(Direction.ASC, "titulo"));
		} else if (ordem.equalsIgnoreCase("desc")) {
			tituloEmOrdem = repo.findAll(Sort.by(Direction.DESC, "titulo"));
		}
		return tituloEmOrdem;
	}
}
