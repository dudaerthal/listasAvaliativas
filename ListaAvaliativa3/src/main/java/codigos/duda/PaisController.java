package codigos.duda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("paises")
public class PaisController {
	
	@Autowired
	private PaisRepository repositorio;
	
	@PostMapping
	@ResponseBody
	public String cadastrar (@RequestBody Pais[] lista) {
		for (Pais pais : lista) {
			System.out.println(pais.getName());
			repositorio.save(pais);
		}
		return "OK";
	}
	
	@GetMapping("/lingua/{lingua}")
	@ResponseBody
	public List<Pais> paisPorLingua(@PathVariable(name = "lingua") String lingua){
		final List<Pais> porLingua = repositorio.findAllByLanguageName(lingua);
		return porLingua;
	}
}
