package com.sample.android.albumproject.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.sample.android.albumproject.R
import com.sample.android.albumproject.model.Album
import com.sample.android.albumproject.module.GlideApp

class AlbumAdapter(context: Context) :
    RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    private var albums: List<Album>? = null
    private var mContext = context


    override fun onCreateViewHolder(parent: ViewGroup, pposition: Int): AlbumAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_album,
            parent, false
        )
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return if (albums != null)
            albums!!.size
        else
            0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentAlbum: Album = albums?.get(position)!!
        holder.bind(currentAlbum, mContext)

    }

    fun setAlbumList(listAlbum: List<Album>) {
        albums = listAlbum
        notifyDataSetChanged()

    }

    class ViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textViewAlbumName: TextView? = itemView.findViewById(R.id.album_name)
        private val imageAlbumCover: ImageView? = itemView.findViewById(R.id.album_cover)


        fun bind(item: Album, context: Context) {
            textViewAlbumName?.text = item.title

            val url = item.thumbnailUrl
            GlideApp.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(imageAlbumCover!!)
        }

    }


}
