package com.ericho.itune_music

import com.ericho.itune_music.data.datasource.MusicDataSource
import com.ericho.itune_music.data.local.MusicLocalDataSource
import com.ericho.itune_music.data.remote.MusicRemoteDataSource
import com.ericho.itune_music.data.repository.MusicRepository

/**
 * Created by steve_000 on 4/11/2017.
 * for project iTunemusic
 * package name com.ericho.itune_music
 */
object Injection {

    fun provideMusicDataSource():MusicDataSource{
        return MusicRepository(MusicLocalDataSource(),MusicRemoteDataSource())
    }
}