package com.ericho.itune_music.data.datasource

import com.ericho.itune_music.data.TuneMusic
import io.reactivex.Observable
import retrofit2.Response

/**
 * Created by steve_000 on 2/11/2017.
 * for project iTunemusic
 * package name com.ericho.itune_music.data.datasource
 */
interface MusicDataSource {

    fun getMusicList(searchStr: String, callback: LoadMusicCallback, forceUpdate: Boolean = false)

    fun ping(): Observable<Response<Any>>

    fun saveMusics(items:List<TuneMusic>)
    fun deleteMusics()

    fun unsubscribe()

    interface LoadMusicCallback {
        fun onLoadMusics(musics: List<TuneMusic>)
        fun onLoadError(e: Throwable)
        fun onLoadMusicFail()// for the condition of load fail
    }
}