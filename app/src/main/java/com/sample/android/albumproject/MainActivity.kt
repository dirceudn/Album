package com.sample.android.albumproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.sample.android.albumproject.view.AlbumsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frag_container, AlbumsFragment()).commit()
        }
    }
}
