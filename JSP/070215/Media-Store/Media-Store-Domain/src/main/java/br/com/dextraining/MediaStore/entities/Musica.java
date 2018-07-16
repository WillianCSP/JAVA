package br.com.dextraining.MediaStore.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "MUSICA")
public class Musica extends Produto {
	
	@Column
	private Integer duracao;

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	@Override
	public String toString() {
		return "Musica [duracao=" + duracao + ", getId()=" + getId()
				+ ", getNome()=" + getNome() + ", getPreco()=" + getPreco()
				+ "]";
	}
	
}
