package br.com.dextraining.MediaStore.services;

import br.com.dextraining.MediaStore.entities.Venda;

public class VendaService extends BaseService<Long, Venda> {
	public VendaService() {
		super(Venda.class);
	}
}
