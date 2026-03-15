package app.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class CarroServiceTest {
	
	@Autowired
	CarroService carroService;
	
	//Cenario de teste com valor esperado
	@Test
	void cenario01() {
		boolean retorno =  this.carroService.verificarNomeCarro("Jeep Compass", 2006);
		assertEquals(true, retorno);
	}
	
	//Cenario de teste esperando excessao
	@Test
	void cenario02() {
		assertThrows(Exception.class, () -> {
			boolean retorno =  this.carroService.verificarNomeCarro("Jeep Compass", 1995);
		});
	}
}
