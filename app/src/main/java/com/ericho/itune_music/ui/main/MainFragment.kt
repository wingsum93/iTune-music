package com.ericho.itune_music.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ericho.itune_music.R
import com.ericho.itune_music.data.TuneMusic
import com.ericho.itune_music.extension.toast
import kotlinx.android.synthetic.main.fragment_main.*
import timber.log.Timber

/**
 * Created by steve_000 on 2/11/2017.
 * for project iTunemusic
 * package name com.ericho.itune_music.ui.main
 */
class MainFragment:Fragment() ,MainPageContract.View {

    private lateinit var presenter:MainPageContract.Presenter

    lateinit var adapter:MainAdapter
    var items:MutableList<TuneMusic> = arrayListOf(TuneMusic.getTemplate())

    companion object {
        fun newInstance():MainFragment{
            val f = MainFragment()
            val bundle = Bundle()
            f.arguments = bundle
            return f
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        setHasOptionsMenu(true)
        return inflater!!.inflate(R.layout.fragment_main,container,false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        presenter.subscribe()
    }

    fun initView(){

        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = MainAdapter(activity, items)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)

    }


    override fun setPresenter(presenter: MainPageContract.Presenter) {
        this.presenter = presenter
    }

    override fun showMusics(comments: List<TuneMusic>) {
        items.clear()
        items.addAll(comments)
        adapter.notifyDataSetChanged()
    }

    override fun showErrorMessage(e: Throwable) {
        activity.toast(e.message?: "not error message")
        Timber.d(e)
    }

    override fun showLoading(loading: Boolean) {

    }
}