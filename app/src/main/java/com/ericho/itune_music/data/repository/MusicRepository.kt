package com.ericho.itune_music.data.repository

import com.ericho.itune_music.data.TuneMusic
import com.ericho.itune_music.data.datasource.MusicDataSource
import com.ericho.itune_music.retrofit.BR
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body

/**
 * Created by steve_000 on 3/11/2017.
 * for project iTunemusic
 * package name com.ericho.itune_music.data.repository
 */
class MusicRepository(private val localMusicDataSource: MusicDataSource,
                      private val remoteMusicDataSource: MusicDataSource) : MusicDataSource {
    private val items: MutableList<TuneMusic> = arrayListOf()
    private var currentSearchStr = ""
    private var cacheCanUse = false


    override fun getMusicList(searchStr: String, forceUpdate: Boolean):Observable<BR<TuneMusic>> {
        if (!forceUpdate) {
            if (searchStr == currentSearchStr ) {
                return localMusicDataSource.getMusicList(searchStr, forceUpdate)
            } else {
                return doOnlineCache(searchStr, forceUpdate)
            }
        } else {
            return doOnlineCache(searchStr, forceUpdate)
        }
    }

    override fun ping(): Observable<Response<Body>> {
        return remoteMusicDataSource.ping()
    }

    private fun doOnlineCache(string: String, forceUpdate: Boolean): Observable<BR<TuneMusic>> {
        val xx = remoteMusicDataSource.getMusicList(string, forceUpdate)
        xx.doOnNext {
            if (it.isSuccess()){
                updateCache(string, it.list!!)
            }
        }
        return xx
    }

    private fun updateCache(cacheStr: String, list: List<TuneMusic>) {
        items.clear()
        items.addAll(list)
        currentSearchStr = cacheStr
        cacheCanUse = true
    }

    override fun saveMusics(items: List<TuneMusic>) {
        localMusicDataSource.saveMusics(items)
    }

    override fun deleteMusics() {
        localMusicDataSource.deleteMusics()
    }
}