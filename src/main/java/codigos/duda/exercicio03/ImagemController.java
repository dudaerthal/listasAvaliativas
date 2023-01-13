package codigos.duda.exercicio03;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ImagemController {

	@GetMapping(value = "/imagem/{nomeCategoria}", produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImageWithMediaType(@PathVariable(name = "nomeCategoria") String nomeCategoria)
			throws IOException {
		int random = new Random().nextInt(5);
		String path = "";
		String[] harry = new String[5];
		harry[0] = "src/main/resources/static/harry01.jpg";
		harry[1] = "src/main/resources/static/harry02.jpg";
		harry[2] = "src/main/resources/static/harry03.jpg";
		harry[3] = "src/main/resources/static/harry04.jpg";
		harry[4] = "src/main/resources/static/harry05.jpg";
		String[] niall = new String[5];
		niall[0] = "src/main/resources/static/niall01.jpg";
		niall[1] = "src/main/resources/static/niall02.jpg";
		niall[2] = "src/main/resources/static/niall03.jpg";
		niall[3] = "src/main/resources/static/niall04.jpg";
		niall[4] = "src/main/resources/static/niall05.jpg";
		String[] louis = new String[5];
		louis[0] = "src/main/resources/static/louis01.jpg";
		louis[1] = "src/main/resources/static/louis02.jpg";
		louis[2] = "src/main/resources/static/louis03.jpg";
		louis[3] = "src/main/resources/static/louis04.jpg";
		louis[4] = "src/main/resources/static/louis05.jpg";

		switch (nomeCategoria) {
		case "HarryStyles":
			path = harry[random];
			break;
		case "NiallHoran":
			path = niall[random];
			break;
		case "LouisTomlinson":
			path = louis[random];
			break;
		}
		InputStream in = new FileInputStream(new File(path));
		return in.readAllBytes();
	}
}
