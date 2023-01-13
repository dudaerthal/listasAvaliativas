package codigos.duda.exercicio01;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/inscricoes")
public class PessoaController {

	@Autowired
	private PessoaRepository repository;

	@PostMapping
	@ResponseBody
	public String cadastraParticipante(@RequestParam String nomeParticipante, String instituicao) {
		Pessoa i = new Pessoa(null, nomeParticipante, instituicao);
		repository.save(i);
		return "Cadastrado com sucesso!";
	}

	@GetMapping("pessoa/{nomePessoa}")
	@ResponseBody
	public String retornaInstituicao(@PathVariable(name = "nomePessoa") String nomePessoa) {
		final Pessoa l1 = repository.findByNome(nomePessoa);
		if (l1 != null) {
			return l1.getInstituicao();
		} else {
			return "Não cadastrado";
		}
	}

	@GetMapping("instituicoes/{instituicao}")
	@ResponseBody
	public String retornaPessoa(@PathVariable(name = "instituicao") String instituicao) {
		final List<Pessoa> l2 = repository.findAllByInstituicao(instituicao);
		if (!l2.isEmpty()) {
			return l2.toString();
		} else {
			return "Instituição não encontrada";
		}
	}

}
