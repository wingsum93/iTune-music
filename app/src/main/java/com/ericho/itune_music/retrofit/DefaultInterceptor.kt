package com.ericho.itune_music.retrofit

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by steve_000 on 5/11/2017.
 * for project iTunemusic
 * package name com.ericho.itune_music.retrofit
 */
class DefaultInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response {
        val original = chain!!.request()

        // Custom the request header.
        val requestBuilder = original.newBuilder()
                .header("Accept", "application/json")
//                        .header("Authorization", "Bearer" + " " + mLastToken)
                .header("User-agent", "iTune Client ( iTune music android prototype ) by eric ho")
                .method(original.method(), original.body())
        val request = requestBuilder.build()

        val response = chain.proceed(request)

        val p = request.url() to response.code().toString()

        Log.d("DefaultInterceptor", "$p  ")
        return response
    }
}