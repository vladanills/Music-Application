package com.example.musicalbumapplication

import android.util.Log
import kotlinx.serialization.json.Json
import kotlinx.serialization.list
import org.kodein.di.direct
import org.kodein.di.generic.instance

class AlbumsPresenter (
    private val albumsUrl: String,
    private val view: AlbumsView
) {
    private val requestMaker = di.direct.instance<RequestMaker>()

    fun onAppear() {
        requestMaker.make(
            albumsUrl,
            onResult = { albumsJson ->
                val albums = Json.parse(Album.serializer().list, albumsJson)
                view.displayAlbums(albums)
            }
        )
    }

}

interface AlbumsView {
    fun displayAlbums(albums: List<Album>)
}
