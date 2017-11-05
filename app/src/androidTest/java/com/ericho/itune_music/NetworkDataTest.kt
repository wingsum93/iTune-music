package com.ericho.itune_music

import android.support.test.runner.AndroidJUnit4
import com.ericho.itune_music.data.remote.MusicRemoteDataSource
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
    private val musicRemoteDataSource = MusicRemoteDataSource()
    @Test
    fun normalSearchTest() {
        // Context of the app under test.
        val o = musicRemoteDataSource.getMusicList("top")

        val z = o.blockingFirst().list

        assertTrue("the search result is not ok", z!!.size > 0)
    }

    @Test
    fun infoTest() {
        val o = musicRemoteDataSource.getMusicList("top")
        val z = o.blockingFirst().list

        val items = z!!
        val set: MutableSet<String> = mutableSetOf()
        items.forEach {
            val str = it.trackName
            set.add(str)
        }
        val set2 = HashSet<String>(set)
        items.forEach {
            set2.remove(it.trackName)
        }

        assertTrue("collection check is not correct" +
                "a = ${items.size} , b = ${set.size}",
                items.size == set.size)
    }
}