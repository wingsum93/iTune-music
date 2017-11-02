package com.ericho.itune_music.ui.main

import com.ericho.itune_music.data.datasource.MusicDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by steve_000 on 2/11/2017.
 * for project iTunemusic
 * package name com.ericho.itune_music.ui.main
 */
class MainPresenter(val view:MainPageContract.View,val dataSource: MusicDataSource):MainPageContract.Presenter {

    private val mCompositeDispose = CompositeDisposable()

    init {
        view.setPresenter(this)
    }

    override fun subscribe() {
        requestSongList()
    }

    override fun unsubscribe() {
        mCompositeDispose.dispose()
    }

    override fun requestSongList() {
        view.showLoading()
        val observable = dataSource.getMusicList("eric")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val items = it.body()!!.results
                    view.showLoading(false)
                    view.showMusics(items)
                },{
                    view.showLoading(false)
                    view.showErrorMessage(it)
                })
        mCompositeDispose.add(observable)
    }
}