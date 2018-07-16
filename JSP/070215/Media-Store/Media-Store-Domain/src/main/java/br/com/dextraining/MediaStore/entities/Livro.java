package br.com.dextraining.MediaStore.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value="LIVRO")
public class Livro extends Produto {

	@Column(nullable = false, length = 13, unique = true)
	private String isbn;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Editora editora;
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	@Override
	public String toString() {
		return "Id: "+getId() + "\tisbn=" + isbn + "\tnome="
				+ getNome() + "\tpreco=" + getPreco();
	}
	
}
