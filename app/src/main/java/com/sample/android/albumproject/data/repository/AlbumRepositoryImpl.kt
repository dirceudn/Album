package com.sample.android.albumproject.data.repository

import android.annotation.SuppressLint
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import android.support.annotation.WorkerThread
import com.sample.android.albumproject.App
import com.sample.android.albumproject.data.db.AlbumDAO
import com.sample.android.albumproject.data.network.ApiService
import com.sample.android.albumproject.model.Album
import com.sample.android.albumproject.util.Constants
import io.reactivex.schedulers.Schedulers

class AlbumRepositoryImpl : AlbumRepository {


    private val restApi: ApiService = ApiService.getService()
    private val albumDao: AlbumDAO = App.dataBaseInstance().albumDao()
    private val listLiveData: LiveData<List<Album>>?

    init {
        listLiveData = albumDao.getAlbums()

    }

    @SuppressLint("CheckResult")
    override fun getRemoteAlbums() {
        restApi.getAlbumList(Constants.INSTANCE.url).subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .subscribe({ albums ->
                //  insert
                insertAlbums(albums)
            }, { error ->

            })
    }


    override fun insertAlbums(albums: List<Album>?) {
        InsertOnDB(albumDao).execute(albums)


    }

    @WorkerThread
    override fun getLocalAlbums(): LiveData<List<Album>>? {
        return listLiveData
    }

    private class InsertOnDB internal constructor(private val mAsyncTaskDao: AlbumDAO) :
        AsyncTask<List<Album>, Void, Void>() {

        override fun doInBackground(vararg params: List<Album>): Void? {
            mAsyncTaskDao.insertAll(params[0])
            return null
        }
    }


    companion object {
        private var INSTANCE: AlbumRepository? = null
        fun getInstance(): AlbumRepository {
            if (INSTANCE == null) {
                INSTANCE = AlbumRepositoryImpl()
            }
            return INSTANCE!!
        }
    }
}