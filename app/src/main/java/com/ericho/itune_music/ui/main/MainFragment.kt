package com.ericho.itune_music.ui.main

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.NetworkInfo
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
class MainFragment : Fragment(), MainPageContract.View {

    private lateinit var presenter: MainPageContract.Presenter
    private val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)

    lateinit var adapter: MainAdapter
    var items: MutableList<TuneMusic> = arrayListOf(TuneMusic.getTemplate())

    companion object {
        fun newInstance(): MainFragment {
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
        return inflater!!.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        presenter.subscribe()
    }

    fun initView() {

        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = MainAdapter(activity, items)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        recyclerView.setUpFloatingActionButton(fab)

        fab.setOnClickListener {
            presenter.requestSongList(true)
        }
        activity?.registerReceiver(myReceiver, intentFilter)
        fab.backgroundTintList = activity.resources.getColorStateList(R.color.background_floating_action_button)
    }


    override fun setPresenter(presenter: MainPageContract.Presenter) {
        this.presenter = presenter
    }

    override fun showMusics(musics: List<TuneMusic>) {
        items.clear()
        items.addAll(musics)
        adapter.notifyDataSetChanged()
        musics.forEach {
            //            println(it.)
        }
    }

    override fun showErrorMessage(e: Throwable) {
        activity.toast(e.message ?: "not error message")
        Timber.d(e)
    }

    override fun showLoading(loading: Boolean) {
        if (true) {
            items.clear()
            adapter.notifyDataSetChanged()
        } else {

        }
    }

    override fun setRefreshButton(enable: Boolean) {
        fab.isEnabled = enable
//        fab.backgroundTintList = activity.resources.getColorStateList(R.color.background_floating_action_button)
    }

    val myReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Timber.d(intent!!.action)
            when (intent.action) {
                ConnectivityManager.CONNECTIVITY_ACTION -> {
                    val cm: ConnectivityManager = context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

                    val activeNetwork: NetworkInfo? = cm.getActiveNetworkInfo();
                    val isConnected = activeNetwork != null &&
                            activeNetwork.isConnectedOrConnecting()
                    val haveNetwork = !intent.extras.getBoolean(ConnectivityManager.EXTRA_NO_CONNECTIVITY)
                    Timber.d("isConnected? $isConnected ")
                    presenter.setNetworkState(isConnected)

                }

            }
        }

    }

    override fun onDestroyView() {
        presenter.unsubscribe()
        activity.unregisterReceiver(myReceiver)
        super.onDestroyView()
    }
}