package com.sample.android.albumproject.di

import com.sample.android.albumproject.data.repository.AlbumRepository
import com.sample.android.albumproject.data.repository.AlbumRepositoryImpl

object Injection {

    fun provideDataSource(): AlbumRepository = AlbumRepositoryImpl.getInstance()

}
