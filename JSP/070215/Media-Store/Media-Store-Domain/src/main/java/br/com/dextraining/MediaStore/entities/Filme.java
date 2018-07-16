package br.com.dextraining.MediaStore.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "FILME")
public class Filme extends Produto {

	@Column
	private Integer duracao;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, 
			fetch=FetchType.EAGER)
	private List<Categoria> categorias;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="filme")
	private List<FilmeAtor> atores;

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public List<Categoria> getCategorias() {
		if(categorias == null) {
			categorias = new ArrayList<Categoria>();
		}
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<FilmeAtor> getAtores() {
		if(atores == null) {
			atores = new ArrayList<FilmeAtor>();
		}
		return atores;
	}

	public void setAtores(List<FilmeAtor> atores) {
		this.atores = atores;
	}

	@Override
	public String toString() {
		return "Filme [nome=" + getNome() + "\t duracao=" + duracao
				+ "\tR$" + getPreco() + "]";
	}
	
	
}
