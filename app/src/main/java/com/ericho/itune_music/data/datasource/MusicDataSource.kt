package com.ericho.itune_music.data.datasource

import com.ericho.itune_music.data.TuneMusic
import com.ericho.itune_music.retrofit.HSet
import io.reactivex.Observable
import retrofit2.Response

/**
 * Created by steve_000 on 2/11/2017.
 * for project iTunemusic
 * package name com.ericho.itune_music.data.datasource
 */
interface MusicDataSource {

    fun getMusicList(searchStr: String,forceUpdate:Boolean = false): Observable<Response<HSet<TuneMusic>>>

}