package com.sample.android.albumproject.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.sample.android.albumproject.model.Album

@Database(entities = arrayOf(Album::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun albumDao(): AlbumDAO
}