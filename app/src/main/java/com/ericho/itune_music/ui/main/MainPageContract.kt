package com.ericho.itune_music.ui.main

import com.ericho.itune_music.data.TuneMusic
import com.ericho.itune_music.widget.BasePresenter
import com.ericho.ultradribble.mvp.BaseView

/**
 * Created by steve_000 on 2/11/2017.
 * for project iTunemusic
 * package name com.ericho.itune_music.ui.main
 */
interface MainPageContract {
    interface View :BaseView<Presenter>{
        fun showMusics(musics: List<TuneMusic>)
        fun showErrorMessage(e:Throwable)
        fun showLoading(loading:Boolean = true)

        fun setRefreshButton(enable:Boolean)
    }
    interface Presenter :BasePresenter{
        fun requestSongList(force: Boolean = false)
        fun setNetworkState(enable: Boolean)

    }

}