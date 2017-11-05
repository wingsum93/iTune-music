package com.ericho.itune_music.data.remote

import com.ericho.itune_music.data.TuneMusic
import com.ericho.itune_music.data.datasource.MusicDataSource
import com.ericho.itune_music.retrofit.BR
import com.ericho.itune_music.retrofit.HSet
import com.ericho.itune_music.retrofit.MusicService
import com.ericho.itune_music.retrofit.RetrofitClient
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body

/**
 * Created by steve_000 on 2/11/2017.
 * for project iTunemusic
 * package name com.ericho.itune_music.data.remote
 */
class MusicRemoteDataSource:MusicDataSource {

    private val musicService:MusicService = RetrofitClient.createService(MusicService::class.java)

    override fun getMusicList(searchStr: String, forceUpdate: Boolean): Observable<BR<TuneMusic>> {
        val z = musicService.search(searchStr)
                .map {
                    val tmp = BR<TuneMusic>()
                    if (it.isSuccessful) {
                        tmp.list = it.body()!!.results
                    }else{
                        tmp.e = Exception(it.message())
                    }
                    return@map tmp
                }
        return z
    }

    override fun ping(): Observable<Response<Body>> {
        return musicService.ping()
    }

    override fun saveMusics(items: List<TuneMusic>) {
        throw UnsupportedOperationException()
    }

    override fun deleteMusics() {
        throw UnsupportedOperationException()
    }
}