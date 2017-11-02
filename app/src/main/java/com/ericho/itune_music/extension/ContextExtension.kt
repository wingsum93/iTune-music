package com.ericho.itune_music.extension

import android.content.Context
import android.widget.Toast

/**
 * Created by steve_000 on 2/11/2017.
 * for project iTunemusic
 * package name com.ericho.itune_music.extension
 */
fun Context.toast(string: String){
    Toast.makeText(this,string,Toast.LENGTH_SHORT).show()
}