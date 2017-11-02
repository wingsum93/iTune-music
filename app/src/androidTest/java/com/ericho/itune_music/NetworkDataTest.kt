package com.ericho.itune_music

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.ericho.itune_music.data.datasource.MusicDataSource
import com.ericho.itune_music.data.remote.MusicRemoteDataSource
import com.google.gson.Gson
import org.junit.Assert
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class NetworkDataTest {
    val gson = Gson()
    @Test
    fun normalSearchTest() {
        // Context of the app under test.
        val o = MusicRemoteDataSource.getMusicList("eric")

        val z = o.blockingFirst().body()

        assertTrue("the search result is not ok",z!!.results.size>0 )
    }
    @Test
    fun infoTest(){
        val o = MusicRemoteDataSource.getMusicList("eric")
        val z = o.blockingFirst().body()

        val items = z!!.results

        items.forEach {
            println("${it.artistId} ranking ${it.trackName}")
        }
    }
}