package br.com.dextra.livraria.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="exe1Bean")
public class Exe1Bean {

	private int numero;
	private int resultado;

	public String gerar(){
		
		this.resultado = (int)(Math.random()*numero);
		System.out.println(resultado);
		return "exe1";
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	
	
}
