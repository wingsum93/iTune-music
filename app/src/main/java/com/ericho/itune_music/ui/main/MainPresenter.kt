package com.ericho.itune_music.ui.main

import com.ericho.itune_music.data.TuneMusic
import com.ericho.itune_music.data.datasource.MusicDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.io.IOException

/**
 * Created by steve_000 on 2/11/2017.
 * for project iTunemusic
 * package name com.ericho.itune_music.ui.main
 */
class MainPresenter(val view: MainPageContract.View, private val dataSource: MusicDataSource) : MainPageContract.Presenter {

    private val mCompositeDispose = CompositeDisposable()


    init {
        view.setPresenter(this)


    }

    override fun subscribe() {
        pingForNetwork()
        requestSongList(false)
    }

    private fun pingForNetwork() {
        val observable = dataSource.ping()
                .map {
                    Timber.d("fab enable? ${it.code()}")
                    it.code() == 200
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.setRefreshButton(it)
                }, {
                    view.setRefreshButton(false)
                })
        mCompositeDispose.add(observable)
    }

    override fun unsubscribe() {
        mCompositeDispose.dispose()
    }

    override fun requestSongList(force: Boolean) {
        view.showLoading()
        dataSource.getMusicList("top", fetchDataCallback, force)

    }

    val fetchDataCallback: MusicDataSource.LoadMusicCallback = object : MusicDataSource.LoadMusicCallback {
        override fun onLoadMusics(musics: List<TuneMusic>) {
            view.showLoading(false)
            view.showMusics(musics)
        }

        override fun onLoadError(e: Throwable) {
            view.showLoading(false)
            view.showErrorMessage(e)
        }

        override fun onLoadMusicFail() {
            view.showLoading(false)
            view.showErrorMessage(IOException("SP"))
        }
    }
    override fun setNetworkState(enable: Boolean) {
        view.setRefreshButton(enable)
    }
}