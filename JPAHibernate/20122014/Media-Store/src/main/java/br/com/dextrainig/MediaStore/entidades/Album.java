package br.com.dextrainig.MediaStore.entidades;

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
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "album_id")
	private Set<Musica> listaMusicas;

	@Column
	private Integer quantidadeFaixas;


	@Override
	public String toString() {
		return "Album [listaMusicas=" + listaMusicas + ", quantidadeFaixas="
				+ quantidadeFaixas + "]";
	}


	public Set<Musica> getListaMusicas() {
		return listaMusicas;
	}



	public void setListaMusicas(Set<Musica> listaMusicas) {
		
		this.quantidadeFaixas = listaMusicas.size();
		this.listaMusicas = listaMusicas;
	}


	public Integer getQuantidadeFaixas() {
		return quantidadeFaixas;
	}


	public void setQuantidadeFaixas(Integer quantidadeFaixas) {
		this.quantidadeFaixas = quantidadeFaixas;
	}

}
