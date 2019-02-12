package com.sample.android.albumproject.data.repository

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import android.support.annotation.WorkerThread
import com.sample.android.albumproject.App
import com.sample.android.albumproject.data.db.AlbumDAO
import com.sample.android.albumproject.data.network.ApiService
import com.sample.android.albumproject.model.Album
import com.sample.android.albumproject.util.Constants
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class AlbumRepository {

    private val restApi: ApiService = ApiService.getService()
    private val albumDao: AlbumDAO = App.dataBaseInstace().albumDao()
    private val listLiveData: LiveData<List<Album>>



    @SuppressLint("CheckResult")
    fun getRemoteAlbums() {
        restApi.getAlbumList(Constants.INSTANCE.url).subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .subscribe({ albums ->
                //  insert
                Timber.d("oioi$albums")
                insertAlbums(albums)
            }, { error ->

            })
    }

    init {
        listLiveData = albumDao.getAlbums()

    }

    private fun insertAlbums(albums: List<Album>) {
        insertAsyncTask(albumDao).execute(albums)

    }

    @WorkerThread
    fun getLocalAlbums(): LiveData<List<Album>> {
        return listLiveData
    }

    private class insertAsyncTask internal constructor(private val mAsyncTaskDao: AlbumDAO) :
        AsyncTask<List<Album>, Void, Void>() {

        override fun doInBackground(vararg params: List<Album>): Void? {
            mAsyncTaskDao.insertAll(params[0])
            return null
        }
    }

}