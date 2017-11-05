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
class MainPresenter(val view: MainPageContract.View, private val dataSource: MusicDataSource) : MainPageContract.Presenter {

    private val mCompositeDispose = CompositeDisposable()


    init {
        view.setPresenter(this)


    }

    override fun subscribe() {
        pingForNetwork()
        requestSongList()
    }

    private fun pingForNetwork() {
        val observable = dataSource.getMusicList("eric")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.setRefreshButton(it.isSuccess())

                }, {
                    view.setRefreshButton(false)
                })
        mCompositeDispose.add(observable)
    }

    override fun unsubscribe() {
        mCompositeDispose.dispose()
    }

    override fun requestSongList() {
        view.showLoading()
        val observable = dataSource.getMusicList("top", false)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.isSuccess()) {
                        val items = it.list!!
                        view.showLoading(false)
                        view.showMusics(items)
                    } else {
                        view.showLoading(false)
                        view.showErrorMessage(it.e!!)
                    }
                }, {
                    view.showLoading(false)
                    view.showErrorMessage(it)
                })
        mCompositeDispose.add(observable)
    }

    override fun setNetworkState(enable: Boolean) {
        view.setRefreshButton(enable)
    }
}