package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Carro;
import app.service.CarroService;

@RestController
@RequestMapping("/api/carro")
public class CarroController {
	
	@Autowired
	CarroService carroService;
	
	@GetMapping("/findById/{Id}")
	public ResponseEntity<Carro> findById(@PathVariable Long Id){
		try {
			Carro carro = this.carroService.findById(Id);
			return new ResponseEntity<Carro>(carro, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Carro>> listarCarros(){
		try {
			List<Carro> carros = this.carroService.listarCarros();
			return new ResponseEntity<>(carros, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> salvarCarro(@RequestBody Carro carro){
		try {
			String mensagem = this.carroService.salvarCarro(carro);
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{Id}")
	public ResponseEntity<String> atualizarCarro(@PathVariable Long Id, @RequestBody Carro carro){
		try {
			String mensagem = this.carroService.atualizarCarro(Id, carro);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<String> deletarCarro(@PathVariable Long Id){
		try {
			String mensagem = this.carroService.deletarCarro(Id);
			return new ResponseEntity<String>(mensagem, HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByNome")
	public ResponseEntity<List<Carro>> findByNome(@RequestParam String nome){
		try {
			List<Carro> carros = this.carroService.findByNome(nome);
			return new ResponseEntity<>(carros, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByMarca")
	public ResponseEntity<List<Carro>> findByMarca(@RequestParam Long id_marca){
		try {
			List<Carro> carros = this.carroService.findByMarca(id_marca);
			return new ResponseEntity<>(carros, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findAcimaAno")
	public ResponseEntity<List<Carro>> findAcimaAno(@RequestParam Integer ano){
		try {
			List<Carro> carros = this.carroService.findAcimaAno(ano);
			return new ResponseEntity<List<Carro>>(carros, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
