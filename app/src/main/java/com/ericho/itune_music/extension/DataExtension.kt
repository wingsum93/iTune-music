package com.ericho.itune_music.extension

import android.preference.PreferenceManager
import com.ericho.itune_music.App
import com.ericho.itune_music.Constant
import com.ericho.itune_music.data.DbConfig
import com.ericho.itune_music.data.TuneMusic
import com.ericho.itune_music.data.datasource.MusicDataSource
import org.xutils.x

/**
 * Created by steve_000 on 5/11/2017.
 * for project iTunemusic
 * package name com.ericho.itune_music.extension
 */
fun MusicDataSource.saveCacheResult(string: String, musics: List<TuneMusic>) {
    val pr = PreferenceManager.getDefaultSharedPreferences(App.context)
    pr.edit().putString(Constant.DB_SEARCH_KEY, string)
            .apply()

    x.task().post {
        val db = x.getDb(DbConfig.daoConfig)
        db.delete(TuneMusic::class.java)
        db.saveBindingId(musics)
    }

}

fun MusicDataSource.loadCacheResult(string: String, callback: MusicDataSource.LoadMusicCallback) {
    val pr = PreferenceManager.getDefaultSharedPreferences(App.context)
    val result = pr.getString(Constant.DB_SEARCH_KEY, "")
    if (result.isEmpty()) {
        callback.onLoadMusicFail()
    } else {
        //for there are cache result
        val db = x.getDb(DbConfig.daoConfig)
        val list = db.findAll(TuneMusic::class.java) as? List<TuneMusic>
        list?.run {
            callback.onLoadMusics(list)
        } ?: kotlin.run {
            callback.onLoadMusicFail()
        }
    }
}