package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Carro;
import app.entity.Marca;
import app.repository.CarroRepository;

@Service
public class CarroService {

	@Autowired
	CarroRepository carroRepository;
	
	public Carro findById(Long Id) {
		Optional<Carro> carro = this.carroRepository.findById(Id);
		return carro.get();
	}
	
	public List<Carro> listarCarros(){
		List<Carro> carros;
		carros = this.carroRepository.findAll();
		return carros;
	}
	
	public String salvarCarro(Carro carro) {
		
		//Regra de negócio de validação do nome do carro
		this.verificarNomeCarro(carro.getNome(), carro.getAno());
		
		this.carroRepository.save(carro);
		return "Carro salvo com sucesso";
	}
	
	public boolean verificarNomeCarro(String nome, Integer ano) {
		if(nome.equals("Jeep Compass") && ano < 2006)
			throw new RuntimeException();
		
		return true;
	}
	
	public String atualizarCarro(Long Id, Carro carro) {
		
		this.verificarNomeCarro(carro.getNome(), carro.getAno());
		
		carro.setId(Id);
		this.carroRepository.save(carro);
		return "Carro atualizado com sucesso";
	}
	
	public String deletarCarro(Long Id) {
		this.carroRepository.deleteById(Id);
		return "Carro deletado com sucesso";
	}
	
	public List<Carro> findByNome(String nome){
		List<Carro> carros = this.carroRepository.findByNome(nome);
		return carros;
	}
	
	public List<Carro> findByMarca(long id_marca){
		Marca marca = new Marca();  
		marca.setId(id_marca);
		List<Carro> carros = this.carroRepository.findByMarca(marca);
		return carros;
	}
	
	public List<Carro> findAcimaAno(Integer ano){
		List<Carro> carros = this.carroRepository.findAcimaAno(ano);
		return carros;
	}
}
