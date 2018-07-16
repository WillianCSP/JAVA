package br.com.dextrainig.MediaStore.entidades;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private Date data;
	
	@Column
	private BigDecimal total;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "venda_id")
	private List<ItemVenda> itens;
	
	@ManyToOne
	private Cliente cliente;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {

		this.total = total;
	}

	public List<ItemVenda> getItens() {
		if(itens == null){
			itens = new ArrayList<ItemVenda>();
		}
			
			return itens;
	}

	public void setItens(List<ItemVenda> itens) {
		this.itens = itens;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", data=" + data + ", total=" + total
				+ ", itens=" + itens + ", cliente=" + cliente + "]";
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
