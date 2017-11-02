package com.ericho.itune_music.retrofit

import com.google.gson.annotations.SerializedName

/**
 * Created by steve_000 on 2/11/2017.
 * for project iTunemusic
 * package name com.ericho.itune_music.retrofit
 */
class HSet<T> {
    @SerializedName("resultCount")
    var resultCount:Int = 0
    @SerializedName("results")
    var results:List<T> = arrayListOf()
}