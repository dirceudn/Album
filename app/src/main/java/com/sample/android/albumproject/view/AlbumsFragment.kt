package com.sample.android.albumproject.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.sample.android.albumproject.R
import com.sample.android.albumproject.adapters.AlbumAdapter
import com.sample.android.albumproject.di.Injection
import com.sample.android.albumproject.model.Album
import com.sample.android.albumproject.viewmodel.AlbumViewModel
import kotlinx.android.synthetic.main.albums_fragment.*
import com.sample.android.albumproject.viewmodel.ViewModelFactory


class AlbumsFragment : Fragment() {

    private var mAlbumViewModel: AlbumViewModel? = null
    private var albumAdapter: AlbumAdapter? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.albums_fragment, container, false)

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mAlbumViewModel =
            ViewModelProviders.of(activity!!, ViewModelFactory.getInstance()).get(AlbumViewModel::class.java)

        initAdapter()
        mAlbumViewModel?.loadAlbums()


    }


    private fun initAdapter() {
        albumAdapter = AlbumAdapter(activity!!)
        recycler_view.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        recycler_view.adapter = albumAdapter
        mAlbumViewModel?.albums?.observe(this,
            Observer<List<Album>> { t ->
                albumAdapter?.setAlbumList(t!!)

            })
    }

}



