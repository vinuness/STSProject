package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import app.entity.Carro;
import app.repository.CarroRepository;

@SpringBootTest
public class CarroControllerTest {

	//Teste de Integração
	
	@Autowired
	CarroController carroController;
	
	@MockitoBean
	CarroRepository carroR;
	
	@Test
	void cenario01() {
		ResponseEntity<List<Carro>> resultado = this.carroController.listarCarros();
		assertEquals(HttpStatus.OK, resultado.getStatusCode());
	}
	
	@Test
	void cenario02() {
		//Com mock
		
		List<Carro> carros = new ArrayList<>();
		carros.add(new Carro((long)1, "nome1", 1990, null, null));
		carros.add(new Carro((long)2, "nome2", 1991, null, null));
		carros.add(new Carro((long)3, "nome3", 1992, null, null));
		
		when(carroR.findAll()).thenReturn(carros);
		
		ResponseEntity<List<Carro>> retorno = this.carroController.listarCarros();
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
		assertEquals(3, retorno.getBody().size());
	}
}