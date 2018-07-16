package br.com.dextraining.MediaStore.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value="ALBUM")
public class Album extends Produto {

	@JoinColumn(name = "album_id")
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Set<Musica> musicas;
	
	@Column
	private Integer quantidadeFaixas;

	public Set<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(Set<Musica> musicas) {
		this.quantidadeFaixas = musicas.size();
		this.musicas = musicas;
	}

	public Integer getQuantidadeFaixas() {
		return quantidadeFaixas;
	}

	public void setQuantidadeFaixas(Integer quantidadeFaixas) {
		this.quantidadeFaixas = quantidadeFaixas;
	}

	@Override
	public String toString() {
		return "Album [quantidadeFaixas="
				+ quantidadeFaixas + ", getId()=" + getId() + ", getNome()="
				+ getNome() + ", getPreco()=" + getPreco() + "]";
	}
	
	
	
}
