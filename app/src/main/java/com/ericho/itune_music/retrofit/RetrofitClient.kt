package com.ericho.itune_music.retrofit

import android.content.Context
import com.google.gson.GsonBuilder
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.text.DateFormat

/**
 * Created by steve_000 on 2/11/2017.
 * for project iTunemusic
 * package name com.ericho.itune_music.retrofit
 */
object RetrofitClient {
    // The latest token
    private var mLastToken: String? = null
    // The [retrofit2.Retrofit] instance for whole app.
    private var mRetrofit: Retrofit? = null

    private var cache: Cache? = null

    fun init(context: Context) {
        cache?.let {
            throw IllegalStateException("Retrofit cache already initialized.")
        }
        cache = Cache(context.cacheDir, 20 * 1024 * 1024)
    }

    fun <T> createService(serviceClass: Class<T>): T {

        if (mRetrofit == null) {

            // Custom the http client.
            val httpClientBuilder = OkHttpClient.Builder()
            httpClientBuilder.addInterceptor(DefaultInterceptor())
            //custom gson
            val gson = GsonBuilder()
                    .setDateFormat(DateFormat.LONG)
                    .create()

            // Set the corresponding convert factory and call adapter factory.
            val retrofitBuilder = Retrofit.Builder()
                    .baseUrl(ApiConstants.ITUNE_SEARCH_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

            mRetrofit = retrofitBuilder
                    .client(httpClientBuilder.build())
                    .build()
        }

        return mRetrofit!!.create(serviceClass)
    }
}