package com.ericho.itune_music.retrofit

/**
 * for the wrapper for data tune music
 */
class BR<T> {
    var e: Throwable? = null
    var list: List<T>? = null
    fun isSuccess() = e == null
}