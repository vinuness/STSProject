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
import jakarta.validation.constraints.NotNull;
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
	
	@NotNull(message = "Nome não pode ser nulo")
	private String nome;
	
	@NotNull(message = "Ano não pode ser nulo")
	private Integer ano;
	
	@NotNull(message = "Modelo não pode ser nulo")
	private String modelo;
	
	//Many Carro para One Marca, ou seja, n carros para 1 marca
	@ManyToOne(cascade = CascadeType.ALL) //irá considerar todas as marcas em cascata
	private Marca marca;
	
	//Many Carro para Many Proprietarios, ou seja, n carros para n proprietarios
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "carro_proprietario")
	private List<Proprietario> proprietarios;
	
}
