package br.com.dextraining.MediaStore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class TesteIdSequence {

	@Id
	@SequenceGenerator(name="GEN_SEQ_TESTE", sequenceName="teste_sequencia", allocationSize=10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="GEN_SEQ_TESTE")
	private Long id;
	
	@Column
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
