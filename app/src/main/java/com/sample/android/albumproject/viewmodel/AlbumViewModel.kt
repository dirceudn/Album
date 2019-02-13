package com.sample.android.albumproject.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.sample.android.albumproject.data.repository.AlbumRepository
import com.sample.android.albumproject.data.repository.AlbumRepositoryImpl
import com.sample.android.albumproject.model.Album

class AlbumViewModel(albumRepository: AlbumRepository) : ViewModel() {

    val albums: LiveData<List<Album>> = albumRepository.getLocalAlbums()!!
    private val albumRepositoryImpl: AlbumRepository = AlbumRepositoryImpl()

    fun loadAlbums() {
        albumRepositoryImpl.getRemoteAlbums()
    }

}