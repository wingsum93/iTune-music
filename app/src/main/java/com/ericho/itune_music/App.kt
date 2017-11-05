package com.ericho.itune_music

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.crashlytics.android.Crashlytics
import com.facebook.stetho.Stetho
import io.fabric.sdk.android.Fabric
import org.xutils.x
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
        Stetho.initializeWithDefaults(applicationContext)
        x.Ext.init(this)

        context = applicationContext
    }

    override fun onTerminate() {
        super.onTerminate()
        context = null
    }

    companion object {
        val appConfig = AppConfig()
        @SuppressLint("StaticFieldLeak")
        var context: Context? = null

    }

}