package com.ericho.itune_music.data.remote

import com.ericho.itune_music.data.TuneMusic
import com.ericho.itune_music.data.datasource.MusicDataSource
import com.ericho.itune_music.retrofit.HSet
import com.ericho.itune_music.retrofit.MusicService
import com.ericho.itune_music.retrofit.RetrofitClient
import io.reactivex.Observable
import retrofit2.Response

/**
 * Created by steve_000 on 2/11/2017.
 * for project iTunemusic
 * package name com.ericho.itune_music.data.remote
 */
object MusicRemoteDataSource:MusicDataSource {

    private val musicService:MusicService = RetrofitClient.createService(MusicService::class.java)

    override fun getMusicList(searchStr: String, forceUpdate: Boolean): Observable<Response<HSet<TuneMusic>>> {
        return musicService.search(searchStr)
    }
}