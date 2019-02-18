package com.sample.android.albumproject

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.sample.android.albumproject.data.db.AppDatabase
import com.sample.android.albumproject.data.network.ApiService
import com.sample.android.albumproject.util.Constants
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import timber.log.Timber


class App : Application() {


    companion object {
        private lateinit var albumApi: ApiService
        private lateinit var appDatabase: AppDatabase
        fun dataBaseInstance() = appDatabase
        fun getRefWatcher(context: Context): RefWatcher {
            val application = context.applicationContext as App
            return application.refWatcher!!
        }
    }


    override fun onCreate() {
        super.onCreate()
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this)

        Timber.uprootAll()
        Timber.plant(Timber.DebugTree())
        albumApi = ApiService.getService()

        appDatabase = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, Constants.INSTANCE.data_base
        ).build()


    }




    private val refWatcher: RefWatcher? = null

}
