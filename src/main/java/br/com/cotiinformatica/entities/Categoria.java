package br.com.cotiinformatica.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column(length = 50, nullable = false)
	private String nome;

	@Column(length = 150, nullable = false)
	private String descricao;

	@OneToMany(mappedBy = "categoria")
	private List<Produto> produtos;
}
