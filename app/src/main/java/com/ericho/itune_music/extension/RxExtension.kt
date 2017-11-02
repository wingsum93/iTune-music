package com.ericho.itune_music.extension

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by steve_000 on 2/11/2017.
 * for project iTunemusic
 * package name com.ericho.itune_music.extension
 */
fun <T> Observable<T>.tackle() : Observable<T>{
    return this.let {
        it.subscribeOn(Schedulers.io())
        it.observeOn(AndroidSchedulers.mainThread())
    }
}