package br.com.dextrainig.MediaStore.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value="FILME")
public class Filme extends Produto{

	/**
	 * 
	 */
	@Column
	private Integer duracao;
	
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	private List<Categoria> categorias; 

	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="filme")
	private List<FilmeAtor> atores;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((categorias == null) ? 0 : categorias.hashCode());
		result = prime * result + ((duracao == null) ? 0 : duracao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		if (categorias == null) {
			if (other.categorias != null)
				return false;
		} else if (!categorias.equals(other.categorias))
			return false;
		if (duracao == null) {
			if (other.duracao != null)
				return false;
		} else if (!duracao.equals(other.duracao))
			return false;
		return true;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}
	
	public List<Categoria> getCategorias() {
		if(categorias == null){
			categorias = new ArrayList<Categoria>();
		}
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<FilmeAtor> getAtores() {
		if(atores == null){
			this.atores = new ArrayList<FilmeAtor>();
		}
		return atores;
	}

	public void setAtores(List<FilmeAtor> atores) {
		this.atores = atores;
	}

	@Override
	public String toString() {
		return "Filme: "+super.toString()+ "[duracao=" + duracao + "]";
	}
}
