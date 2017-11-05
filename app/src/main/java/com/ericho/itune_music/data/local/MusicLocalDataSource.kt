package com.ericho.itune_music.data.local

import com.ericho.itune_music.data.DbConfig
import com.ericho.itune_music.data.TuneMusic
import com.ericho.itune_music.data.datasource.MusicDataSource
import com.ericho.itune_music.extension.loadCacheResult
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import org.xutils.x
import retrofit2.Response

/**
 * Created by steve_000 on 2/11/2017.
 * for project iTunemusic
 * package name com.ericho.itune_music.data.local
 */
class MusicLocalDataSource:MusicDataSource {

    private val compositeDisposable = CompositeDisposable()


    override fun getMusicList(searchStr: String, callback: MusicDataSource.LoadMusicCallback, forceUpdate: Boolean) {
        val loadDataCallback = object : MusicDataSource.LoadMusicCallback {
            override fun onLoadMusics(musics: List<TuneMusic>) {
                if (musics.isEmpty()) {
                    callback.onLoadMusicFail()
                } else {
                    callback.onLoadMusics(musics)
                }
            }

            override fun onLoadError(e: Throwable) {
                callback.onLoadError(e)
            }

            override fun onLoadMusicFail() {
                callback.onLoadMusicFail()
            }
        }
        this.loadCacheResult(searchStr, loadDataCallback)
    }

    override fun ping(): Observable<Response<Any>> {
        throw UnsupportedOperationException()
    }

    override fun saveMusics(items: List<TuneMusic>) {
        throw UnsupportedOperationException()
    }


    override fun deleteMusics() {
        val db = x.getDb(DbConfig.daoConfig)
        db.delete(TuneMusic::class.java)
    }

    override fun unsubscribe() {
        compositeDisposable.dispose()
    }
}