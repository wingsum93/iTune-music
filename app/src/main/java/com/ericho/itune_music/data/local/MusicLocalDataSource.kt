package com.ericho.itune_music.data.local

import com.ericho.itune_music.data.TuneMusic
import com.ericho.itune_music.data.datasource.MusicDataSource
import com.ericho.itune_music.retrofit.BR
import com.ericho.itune_music.retrofit.HSet
import com.orm.SugarRecord
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body

/**
 * Created by steve_000 on 2/11/2017.
 * for project iTunemusic
 * package name com.ericho.itune_music.data.local
 */
class MusicLocalDataSource:MusicDataSource {

    override fun getMusicList(searchStr: String, forceUpdate: Boolean): Observable<BR<TuneMusic>> {
        val list = SugarRecord.findAll(TuneMusic::class.java) as List<TuneMusic>
        val tmp = BR<TuneMusic>()
        tmp.list = list
        return Observable.just(tmp)
    }

    override fun ping(): Observable<Response<Body>> {
        throw UnsupportedOperationException()
    }

    override fun saveMusics(items: List<TuneMusic>) {
        items.forEach {
            it.save()
        }
    }

    override fun deleteMusics() {
        SugarRecord.deleteAll(TuneMusic::class.java)
    }
}