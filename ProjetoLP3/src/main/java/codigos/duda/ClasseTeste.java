package codigos.duda;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClasseTeste {

	DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	@Autowired
	private AutorRepository repositorioAutor;

	@Autowired
	private LivroRepository repositorioLivro;

	@PostConstruct
	public void inicializa() {

//		Autor autor1 = new Autor();
//		autor1.setNome("Colleen Houck");
//		autor1.setNacionalidade("Estadunidense");
//		String dataNasc = "03/10/1969";
//		LocalDate dataNascimentoFormatada = LocalDate.parse(dataNasc, formatar);
//		autor1.setDataNascimento(dataNascimentoFormatada);
//
//		Livro livro1 = new Livro();
//		livro1.setTitulo("A Maldição do Tigre");
//		livro1.setEditora("Arqueiro");
//		double preco = 32.70;
//		BigDecimal valor = new BigDecimal(preco);
//		livro1.setValor(valor);
//		String dataLancamento = "17/10/2011";
//		LocalDate dataLancamentoFormatada = LocalDate.parse(dataLancamento, formatar);
//		livro1.setDataLancamento(dataLancamentoFormatada);
//		autor1.adicionaLivro(livro1);
//
//		Livro livro2 = new Livro();
//		livro2.setTitulo("O Resgate do Tigre");
//		livro2.setEditora("Arqueiro");
//		preco = 47.90;
//		valor = new BigDecimal(preco);
//		livro2.setValor(valor);
//		dataLancamento = "11/05/2012";
//		dataLancamentoFormatada = LocalDate.parse(dataLancamento, formatar);
//		livro2.setDataLancamento(dataLancamentoFormatada);
//		autor1.adicionaLivro(livro2);
//
//		Livro livro3 = new Livro();
//		livro3.setTitulo("A Viagem do Tigre");
//		livro3.setEditora("Arqueiro");
//		preco = 35.90;
//		valor = new BigDecimal(preco);
//		livro3.setValor(valor);
//		dataLancamento = "22/11/2012";
//		dataLancamentoFormatada = LocalDate.parse(dataLancamento, formatar);
//		livro3.setDataLancamento(dataLancamentoFormatada);
//		autor1.adicionaLivro(livro3);
//
//		Livro livro4 = new Livro();
//		livro4.setTitulo("O Destino do Tigre");
//		livro4.setEditora("Arqueiro");
//		preco = 44.90;
//		valor = new BigDecimal(preco);
//		livro3.setValor(valor);
//		dataLancamento = "01/04/2013";
//		dataLancamentoFormatada = LocalDate.parse(dataLancamento, formatar);
//		livro3.setDataLancamento(dataLancamentoFormatada);
//		autor1.adicionaLivro(livro4);
//
//		Livro livro5 = new Livro();
//		livro5.setTitulo("O Sonho do Tigre");
//		livro5.setEditora("Arqueiro");
//		preco = 54.25;
//		valor = new BigDecimal(preco);
//		dataLancamento = "19/07/2018";
//		dataLancamentoFormatada = LocalDate.parse(dataLancamento, formatar);
//		livro4.setDataLancamento(dataLancamentoFormatada);
//		autor1.adicionaLivro(livro5);
//
//		repositorioAutor.save(autor1);
//		repositorioLivro.save(livro1);
//		repositorioLivro.save(livro2);
//		repositorioLivro.save(livro3);
//		repositorioLivro.save(livro4);
//		repositorioLivro.save(livro5);
		
		
	}

}
