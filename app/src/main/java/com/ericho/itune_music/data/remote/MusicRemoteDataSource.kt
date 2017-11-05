package com.ericho.itune_music.data.remote

import com.ericho.itune_music.data.TuneMusic
import com.ericho.itune_music.data.datasource.MusicDataSource
import com.ericho.itune_music.retrofit.MusicService
import com.ericho.itune_music.retrofit.RetrofitClient
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

/**
 * Created by steve_000 on 2/11/2017.
 * for project iTunemusic
 * package name com.ericho.itune_music.data.remote
 */
class MusicRemoteDataSource:MusicDataSource {

    private val musicService:MusicService = RetrofitClient.createService(MusicService::class.java)
    private val compositeDisposable = CompositeDisposable()


    override fun getMusicList(searchStr: String, callback: MusicDataSource.LoadMusicCallback, forceUpdate: Boolean) {
        val z = musicService.search(searchStr)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.isSuccessful) {
                        callback.onLoadMusics(it.body()!!.results)
                    }else{
                        callback.onLoadError(Exception(it.message()))
                    }
                }, {
                    callback.onLoadError(it)
                })
        compositeDisposable.add(z)
    }

    override fun ping(): Observable<Response<Any>> {
        return musicService.ping()
    }

    override fun saveMusics(items: List<TuneMusic>) {
        throw UnsupportedOperationException()
    }

    override fun deleteMusics() {
        throw UnsupportedOperationException()
    }

    override fun unsubscribe() {
        compositeDisposable.dispose()
    }
}