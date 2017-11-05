package com.ericho.itune_music.data

import com.google.gson.annotations.SerializedName
import org.xutils.db.annotation.Column
import org.xutils.db.annotation.Table
import java.util.*

/**
 * Created by steve_000 on 2/11/2017.
 * for project iTunemusic
 * package name com.ericho.itune_music.data
 */
@Table(name = "music")
data class TuneMusic(
        @SerializedName("wrapperType")
        @Column(name = "wrapperType")
        val wrapperType: String = "",
        @SerializedName("kind")
        @Column(name = "kind")
        val kind: String = "",
        @SerializedName("artistId")
        @Column(name = "artistId")
        val artistId: Int = 0,
        @SerializedName("collectionId")
        @Column(name = "collectionId")
        val collectionId: Int = 0,
        @SerializedName("trackId")
        @Column(name = "trackId")
        val trackId: Int = 0,
        @SerializedName("artistName")
        @Column(name = "artistName")
        val artistName: String = "",
        @SerializedName("collectionName")
        @Column(name = "collectionName")
        val collectionName: String = "",
        @SerializedName("trackName")
        @Column(name = "trackName")
        val trackName: String = "",
        @SerializedName("collectionCensoredName")
        @Column(name = "collectionCensoredName")
        val collectionCensoredName: String = "",
        @SerializedName("trackCensoredName")
        @Column(name = "trackCensoredName")
        val trackCensoredName: String = "",
        @SerializedName("artistViewUrl")
        @Column(name = "artistViewUrl")
        val artistViewUrl: String = "",
        @SerializedName("collectionViewUrl")
        @Column(name = "collectionViewUrl")
        val collectionViewUrl: String = "",
        @SerializedName("trackViewUrl")
        @Column(name = "trackViewUrl")
        val trackViewUrl: String = "",
        @SerializedName("previewUrl")
        @Column(name = "previewUrl")
        val previewUrl: String = "",
        @SerializedName("artworkUrl30")
        @Column(name = "artworkUrl30")
        val artworkUrl30: String = "",
        @SerializedName("artworkUrl60")
        @Column(name = "artworkUrl60")
        val artworkUrl60: String = "",
        @SerializedName("artworkUrl100")
        @Column(name = "artworkUrl100")
        val artworkUrl100: String = "",
        @SerializedName("collectionPrice")
        @Column(name = "collectionPrice")
        val collectionPrice: Float = 0f,
        @SerializedName("trackPrice")
        val trackPrice: Float = 0f,
        @SerializedName("releasedDate")
        @Column(name = "releasedDate")
        val releasedDate: Date = Date(),
        @SerializedName("collectionExplicitness")
        @Column(name = "collectionExplicitness")
        val collectionExplicitness: String = "",
        @SerializedName("trackExplicitness")
        @Column(name = "trackExplicitness")
        val trackExplicitness: String = "",
        @SerializedName("discCount")
        @Column(name = "discCount")
        val discCount: Int = 0,
        @SerializedName("discNumber")
        @Column(name = "discNumber")
        val discNumber: Int = 0,
        @SerializedName("trackCount")
        @Column(name = "trackCount")
        val trackCount: Int = 0,
        @SerializedName("trackNumber")
        @Column(name = "trackNumber")
        val trackNumber: Int = 0,
        @SerializedName("trackTimeMillis")
        @Column(name = "trackTimeMillis")
        val trackTimeMillis: Long = 0L,
        @SerializedName("country")
        @Column(name = "country")
        val country: String = "",
        @SerializedName("currency")
        @Column(name = "currency")
        val currency: String = "",
        @SerializedName("primaryGenreName")
        @Column(name = "primaryGenreName")
        val primaryGenreName: String = "",
        @SerializedName("isStreamable")
        @Column(name = "isStreamable")
        val isStreamable: Boolean = false,
        @Column(name = "id", isId = true)
        val id: Long? = null

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
                            collectionPrice = 63f,
                            trackPrice = 8f,
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