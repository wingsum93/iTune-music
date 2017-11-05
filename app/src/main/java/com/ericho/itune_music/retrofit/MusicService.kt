package com.ericho.itune_music.retrofit

import com.ericho.itune_music.data.TuneMusic
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by steve_000 on 2/11/2017.
 * for project iTunemusic
 * package name com.ericho.itune_music.retrofit
 */
interface MusicService {

    @GET("/search")
    fun search(@Query("term") term:String ,
                @Query("entity") entity:String = "song",
                @Query("country") country:String = "US",
                @Query("media") media:String = "music"
                ): Observable<Response<HSet<TuneMusic>>>


    //2. Lookup Examples
    @GET("/lookup")
    fun lookup(

    )
    @GET("/")
    fun ping():Observable<Response<Body>>

    @GET("/search")
    fun searchPopular(@Query("term") term:String ,
               @Query("attribute") attribute:String = "ratingIndex",
               @Query("entity") entity:String = "song",
               @Query("country") country:String = "US",
               @Query("media") media:String = "music"
    ): Observable<Response<HSet<TuneMusic>>>

}