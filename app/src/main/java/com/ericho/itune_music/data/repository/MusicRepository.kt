package com.ericho.itune_music.data.repository

import com.ericho.itune_music.data.TuneMusic
import com.ericho.itune_music.data.datasource.MusicDataSource
import com.ericho.itune_music.extension.saveCacheResult
import com.ericho.itune_music.widget.Log
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Response

/**
 * Created by steve_000 on 3/11/2017.
 * for project iTunemusic
 * package name com.ericho.itune_music.data.repository
 */
class MusicRepository(private val localMusicDataSource: MusicDataSource,
                      private val remoteMusicDataSource: MusicDataSource) : MusicDataSource {

    private val compositeDisposable = CompositeDisposable()

    override fun getMusicList(searchStr: String, callback: MusicDataSource.LoadMusicCallback, forceUpdate: Boolean) {
        val callbackForNetwork = object : MusicDataSource.LoadMusicCallback {
            override fun onLoadMusics(musics: List<TuneMusic>) {
                callback.onLoadMusics(musics)
                this@MusicRepository.saveCacheResult(searchStr, musics)
            }

            override fun onLoadError(e: Throwable) {
                callback.onLoadError(e)
            }

            override fun onLoadMusicFail() {
                callback.onLoadMusicFail()
            }
        }

        //normal handle
        if (!forceUpdate) {
            localMusicDataSource.getMusicList(searchStr, object : MusicDataSource.LoadMusicCallback {
                override fun onLoadMusics(musics: List<TuneMusic>) {
                    callback.onLoadMusics(musics)
                }

                override fun onLoadError(e: Throwable) {
                    Log.w(e)
                    remoteMusicDataSource.getMusicList(searchStr, callbackForNetwork, forceUpdate)
                }

                override fun onLoadMusicFail() {
                    remoteMusicDataSource.getMusicList(searchStr, callbackForNetwork, forceUpdate)
                }
            })
            return

        } else {
            remoteMusicDataSource.getMusicList(searchStr, callbackForNetwork, forceUpdate)
            return
        }

    }

    override fun ping(): Observable<Response<Any>> {
        return remoteMusicDataSource.ping()
    }


    override fun saveMusics(items: List<TuneMusic>) {
        localMusicDataSource.saveMusics(items)
    }

    override fun deleteMusics() {
        localMusicDataSource.deleteMusics()
    }

    override fun unsubscribe() {
        compositeDisposable.dispose()
    }
}