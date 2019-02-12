package com.sample.android.albumproject.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.sample.android.albumproject.data.repository.AlbumRepository
import com.sample.android.albumproject.model.Album

class AlbumViewModel(application: Application) : AndroidViewModel(application) {

    val albums: LiveData<List<Album>>
    private val albumRepository: AlbumRepository = AlbumRepository()

    init {

        albums = albumRepository.getLocalAlbums()
    }

    fun loadAlbums() {
        albumRepository.getRemoteAlbums()
    }

}