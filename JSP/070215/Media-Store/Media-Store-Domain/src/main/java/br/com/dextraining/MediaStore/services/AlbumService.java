package br.com.dextraining.MediaStore.services;

import br.com.dextraining.MediaStore.entities.Album;

public class AlbumService extends BaseService<Long, Album> {
	public AlbumService() {
		super(Album.class);
	}
}
