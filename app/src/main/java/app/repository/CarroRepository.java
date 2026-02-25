package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Carro;
import app.entity.Marca;

public interface CarroRepository extends JpaRepository<Carro, Long>{
	
	//Metodos sem JPQL, automatizados
	//devem ter filtros em seus nomes, ou seja, 'findBy'+'atributo', que com isso, já será reconhecido o metodo
	//Caso coloque por exemplo, findByMarcaNome, Carro deve conter Marca que deve conter Nome
	

	public List<Carro> findByNome(String nome);
	
	public List<Carro> findByMarca(Marca marca);
	
	//Metodos com JPQL explicitos, porem convertidos em SQL nativo em tempo de execução
	
	@Query("FROM Carro c WHERE c.ano > :ano")
	public List<Carro> findAcimaAno(Integer ano);
	
}
