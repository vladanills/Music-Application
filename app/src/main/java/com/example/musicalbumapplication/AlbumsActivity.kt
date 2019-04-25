package com.example.musicalbumapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_album_list.*
import org.jetbrains.anko.longToast

class AlbumsActivity : AlbumsView, AppCompatActivity() {

    private lateinit var presenter: AlbumsPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_list)

        val albumsUrl = "https://gist.githubusercontent.com/vladanills/bbff79ed2bc42b77d35453f112161f5c/raw/681bcb06093e012c157ca4100277f3115cfe3f84/albums.json"
//        Log.d(javaClass.name,"products url is $albumsUrl")
        presenter = AlbumsPresenter(albumsUrl, view = this)
    }

    override fun onResume() {
        super.onResume()
        presenter.onAppear()
    }

    override fun displayAlbums(albums: List<Album>) {
        album_list.adapter =
            AlbumsAdapter(albums, this@AlbumsActivity)
    }
}