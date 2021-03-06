package com.ericho.itune_music.widget

import android.content.Context
import android.support.design.widget.FloatingActionButton
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

    private var floatingActionButton:FloatingActionButton? = null


    fun setUpFloatingActionButton(view:FloatingActionButton){
        floatingActionButton = view
        this.addOnScrollListener(object : OnScrollWrapper() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                when(newState){
                    RecyclerView.SCROLL_STATE_IDLE -> {
                        floatingActionButton?.show()
                    }
                    else -> floatingActionButton?.hide()
                }
            }
        })
    }


    open class OnScrollWrapper():OnScrollListener(){


        override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
        }

        override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
        }
    }
}