package com.ericho.itune_music.extension

import android.widget.ImageView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.ericho.itune_music.widget.GlideApp

/**
 * Created by steve_000 on 2/11/2017.
 * for project iTunemusic
 * package name com.ericho.itune_music.extension
 */
fun ImageView.loadNormal(url:String){
    GlideApp.with(this.context)
            .load(url)
            .skipMemoryCache(false)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .into(this)
}