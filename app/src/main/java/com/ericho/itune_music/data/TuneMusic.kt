package com.ericho.itune_music.data

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by steve_000 on 2/11/2017.
 * for project iTunemusic
 * package name com.ericho.itune_music.data
 */
data class TuneMusic(
        @SerializedName("wrapperType")
        val wrapperType:String,
        @SerializedName("kind")
        val kind:String,
        @SerializedName("artistId")
        val artistId:Int,
        @SerializedName("collectionId")
        val collectionId:Int,
        @SerializedName("trackId")
        val trackId:Int,
        @SerializedName("artistName")
        val artistName:String,
        @SerializedName("collectionName")
        val collectionName:String,
        @SerializedName("trackName")
        val trackName:String,
        @SerializedName("collectionCensoredName")
        val collectionCensoredName:String,
        @SerializedName("trackCensoredName")
        val trackCensoredName:String,
        @SerializedName("artistViewUrl")
        val artistViewUrl:String,
        @SerializedName("collectionViewUrl")
        val collectionViewUrl:String,
        @SerializedName("trackViewUrl")
        val trackViewUrl:String,
        @SerializedName("previewUrl")
        val previewUrl:String,
        @SerializedName("artworkUrl30")
        val artworkUrl30: String,
        @SerializedName("artworkUrl60")
        val artworkUrl60: String,
        @SerializedName("artworkUrl100")
        val artworkUrl100: String,
        @SerializedName("collectionPrice")
        val collectionPrice: Int,
        @SerializedName("trackPrice")
        val trackPrice: Int,
        @SerializedName("releasedDate")
        val releasedDate:Date,
        @SerializedName("collectionExplicitness")
        val collectionExplicitness:String,
        @SerializedName("trackExplicitness")
        val trackExplicitness:String,
        @SerializedName("discCount")
        val discCount:Int,
        @SerializedName("discNumber")
        val discNumber:Int,
        @SerializedName("trackCount")
        val trackCount:Int,
        @SerializedName("trackNumber")
        val trackNumber:Int,
        @SerializedName("trackTimeMillis")
        val trackTimeMillis:Long,
        @SerializedName("country")
        val country:String,
        @SerializedName("currency")
        val currency:String,
        @SerializedName("primaryGenreName")
        val primaryGenreName:String,
        @SerializedName("isStreamable")
        val isStreamable:Boolean

) {
        fun getArtworkUrl():String{
                return artworkUrl100
        }
        companion object {
            fun getTemplate():TuneMusic{
                    return TuneMusic(
                            wrapperType = "track",
                            kind = "s",
                            artistId = 666,
                            collectionId = 11,
                            trackId = 11,
                            artistName = "aa mame",
                            collectionName = "collecftion name",
                            trackName = "track",
                            collectionCensoredName = "track",
                            trackCensoredName = "track",
                            artistViewUrl = "https://itunes.apple.com/hk/artist/every-little-thing/id73957328?uo=4",
                            collectionViewUrl = "https://itunes.apple.com/hk/album//id1004261653?i=1004261685&uo=4",
                            trackViewUrl = "track",
                            previewUrl = "track",
                            artworkUrl30 = "http://is3.mzstatic.com/image/thumb/Music7/v4/64/15/b0/6415b03f-3da9-51ec-3057-92d902d92917/source/30x30bb.jpg",
                            artworkUrl60 = "http://is3.mzstatic.com/image/thumb/Music7/v4/64/15/b0/6415b03f-3da9-51ec-3057-92d902d92917/source/60x60bb.jpg",
                            artworkUrl100 = "http://is3.mzstatic.com/image/thumb/Music7/v4/64/15/b0/6415b03f-3da9-51ec-3057-92d902d92917/source/100x100bb.jpg",
                            collectionPrice = 63,
                            trackPrice = 8,
                            releasedDate = Date(),
                            collectionExplicitness = "track",
                            trackExplicitness = "track",
                            discCount = 1,
                            discNumber = 1,
                            trackCount = 13,
                            trackNumber = 7,
                            trackTimeMillis = 100033,
                            country = "HKG",
                            currency = "HKD",
                            primaryGenreName = "日本流行樂",
                            isStreamable = true
                    )
            }
        }
}