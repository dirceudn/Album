package com.sample.android.albumproject

import android.app.Application
import android.arch.persistence.room.Room
import com.sample.android.albumproject.data.db.AppDatabase
import com.sample.android.albumproject.data.network.ApiService
import com.sample.android.albumproject.util.Constants
import timber.log.Timber

class App : Application() {


    companion object {
        private lateinit var albumApi: ApiService
        private lateinit var appDatabase: AppDatabase

        fun dataBaseInstace() = appDatabase
    }


    override fun onCreate() {
        super.onCreate()
        Timber.uprootAll()
        Timber.plant(Timber.DebugTree())
        albumApi = ApiService.getService()

        appDatabase = Room.databaseBuilder(applicationContext,
            AppDatabase::class.java, Constants.INSTANCE.data_base).build()


    }

}