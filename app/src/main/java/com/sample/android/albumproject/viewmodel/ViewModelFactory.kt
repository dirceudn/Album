package com.sample.android.albumproject.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.sample.android.albumproject.di.Injection

class ViewModelFactory  : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == AlbumViewModel::class.java) {
            return AlbumViewModel(
                Injection.provideDataSource()) as T
        }
        throw IllegalArgumentException("unknown model class $modelClass")

    }

    companion object {
        private var INSTANCE: ViewModelFactory? = null
        fun getInstance(): ViewModelFactory {
            if (INSTANCE == null) {
                INSTANCE = ViewModelFactory()
            }
            return INSTANCE!!
        }
    }
}