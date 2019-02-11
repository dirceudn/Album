package com.sample.android.albumproject.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "albums")
data class Album(
    var albumId: Int?,
    @PrimaryKey
    var id: Int?,
    var title: String?,
    var url: String?,
    var thumbnailUrl: String?
) {
    constructor() : this(0, 0, "", "", "")

}