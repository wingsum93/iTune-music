package com.ericho.itune_music.ui.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.ericho.itune_music.R
import com.ericho.itune_music.data.TuneMusic
import com.ericho.itune_music.extension.loadNormal
import com.ericho.itune_music.widget.BaseRecyclerAdapter

/**
 * Created by steve_000 on 2/11/2017.
 * for project iTunemusic
 * package name com.ericho.itune_music.ui.main
 */
class MainAdapter(context:Context,items:List<TuneMusic>): BaseRecyclerAdapter<TuneMusic, MainAdapter.MainViewHolder>(context, items) {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_main,parent,false )

        return MainViewHolder(view = view)
    }

    override fun onBindContentViewHolder(holder: MainViewHolder?, position: Int) {
        val z = items[position]
        holder!!
        holder.img_1.loadNormal(z.getArtworkUrl())
        holder.txv_artist_name.text = z.artistName
        holder.txv_song_name.text = z.collectionCensoredName

    }

    class MainViewHolder(view:View):RecyclerView.ViewHolder(view){
        val img_1 :ImageView = view.findViewById(R.id.img_1)
        val txv_artist_name :TextView = view.findViewById(R.id.txv_artist_name)
        val txv_song_name :TextView = view.findViewById(R.id.txv_song_name)
    }
}