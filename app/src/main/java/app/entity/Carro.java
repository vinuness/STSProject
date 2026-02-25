package app.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Carro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Integer ano;
	
	//Many Carro para One Marca, ou seja, n carros para 1 marca
	@ManyToOne(cascade = CascadeType.ALL) //irá considerar todas as marcas em cascata
	private Marca marca;
	
	//Many Carro para Many Proprietarios, ou seja, n carros para n proprietarios
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "carro_proprietario")
	private List<Proprietario> proprietarios;
	
}
