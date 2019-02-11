package com.sample.android.albumproject.data.repository

import android.app.Application
import com.sample.android.albumproject.data.network.ApiService

class AlbumRepository (aplication: Application) {

    private val restApi: ApiService = ApiService.getService()

}