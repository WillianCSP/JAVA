package br.com.dextrainig.MediaStore.services;

import br.com.dextrainig.MediaStore.entidades.Album;

public class AlbumService extends BaseService<Long, Album> {

	public AlbumService(){
		
		super(Album.class);
	}
}
