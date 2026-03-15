package app.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/*Testes Unitarios
 * são feitos para testar e analisar metodos unicos, sem integrações entre outros objetos
 * */




//Usando o Junit como executor, posso verificar a coerencia dos dados, fazendo uma analise

@SpringBootTest
public class CarroServiceTest {
	
	@Autowired
	CarroService carroService;
	
	
	@Test
	void cenario01() {
		
		/*Caso queira uma verificacao sem erro
		 *
		 *uso assertEquals(valor esperado, valor retornado)
		 *Exemplo:
		 *
		 * List<Integer> lista = new ArrayList<>();
		 * lista.add(1);
		 * lista.add(4);
		 * lista.add(5);
		 * 
		 * int retorno = somar(lista);
		 * assertEquals(10, retorno);
		 * */
	}
	
	@Test
	void cenario02() {
		
		/*Caso queira uma verificacao esperando erro
		 *
		 *uso assertThrows(excessao, açao para ativação da excessao)
		 *
		 *Exemplo:
		 *
		 * List<Integer> lista = new ArrayList<>();
		 * lista.add(null);
		 * lista.add(4);
		 * lista.add(5);
		 * 
		 * assertThrows(Exception.class, () -> {
		 * 		this.soma(lista);
		 * });
		 * */
	}
}
