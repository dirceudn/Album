package com.sample.android.albumproject.data.repository

import android.arch.lifecycle.LiveData
import com.sample.android.albumproject.model.Album

interface AlbumRepository {

    fun getRemoteAlbums()

    fun insertAlbums(albums: List<Album>?)

    fun getLocalAlbums(): LiveData<List<Album>>?


}