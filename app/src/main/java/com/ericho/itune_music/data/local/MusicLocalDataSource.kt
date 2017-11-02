package com.ericho.itune_music.data.local

import com.ericho.itune_music.data.TuneMusic
import com.ericho.itune_music.data.datasource.MusicDataSource
import com.ericho.itune_music.retrofit.HSet
import io.reactivex.Observable
import retrofit2.Response

/**
 * Created by steve_000 on 2/11/2017.
 * for project iTunemusic
 * package name com.ericho.itune_music.data.local
 */
object MusicLocalDataSource:MusicDataSource {
    override fun getMusicList(searchStr: String, forceUpdate: Boolean): Observable<Response<HSet<TuneMusic>>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}