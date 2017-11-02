package com.ericho.itune_music

import android.app.Application
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric
import timber.log.Timber


/**
 * Created by steve_000 on 2/11/2017.
 * for project iTunemusic
 * package name com.ericho.itune_music
 */
class App: Application() {




    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics())
        Timber.plant(Timber.DebugTree())

    }
    companion object {
        val appConfig = AppConfig()

    }

}