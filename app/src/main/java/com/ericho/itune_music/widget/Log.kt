package com.ericho.itune_music.widget

import timber.log.Timber

/**
 * Created by steve_000 on 5/11/2017.
 * for project iTunemusic
 * package name com.ericho.itune_music.widget
 */
object Log {
    fun w(t: Throwable) {
        Timber.w(t)
    }

    fun e(t: Throwable) {
        Timber.e(t)
    }
}