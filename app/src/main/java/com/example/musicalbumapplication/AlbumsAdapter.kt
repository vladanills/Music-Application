package com.example.musicalbumapplication

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.album_list_item.view.*
import org.jetbrains.anko.layoutInflater


class AlbumsAdapter(
    private val albums: List<Album>,
    private val context: Context
) : RecyclerView.Adapter<AlbumsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(recyclerView: ViewGroup, viewType: Int) = run {
        val view = context.layoutInflater.inflate(
            R.layout.album_list_item,
            recyclerView,
            false
        )
        ViewHolder(view)
    }

    override fun getItemCount(): Int = albums.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val al = albums[position]
        holder.itemView.vTextAlbumName.text = al.album
        holder.itemView.vTextArtist.text = al.artist
//        holder.itemView.price.text = al.price
        Picasso.get()
            .load(al.imageUrl)
            .into(holder.itemView.vImageAlbum)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}