package com.ericho.itune_music.widget

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet

/**
 * Created by steve_000 on 2/11/2017.
 * for project iTunemusic
 * package name com.ericho.itune_music.widget
 */
class MRecyclerView:RecyclerView {

    constructor(context:Context):  super(context)
    constructor(context:Context,attr:AttributeSet):  super(context,attr)
    constructor(context:Context,attr:AttributeSet,defStyle:Int):  super(context,attr,defStyle)








    class OnScrollWrapper(val listener: OnScrollListener):OnScrollListener(){


        override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
            listener.onScrolled(recyclerView, dx, dy)
        }

        override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
            listener.onScrollStateChanged(recyclerView, newState)
        }
    }
}