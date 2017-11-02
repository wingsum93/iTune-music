package com.ericho.itune_music.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ericho.itune_music.R
import com.ericho.itune_music.data.remote.MusicRemoteDataSource

class MainActivity : AppCompatActivity() {

    lateinit var fragment :MainFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        savedInstanceState?.let {
            fragment = fragmentManager.getFragment(savedInstanceState,MainFragment::class.java.name) as MainFragment
        }?:kotlin.run {
            fragment = MainFragment.newInstance()
        }

        if(!fragment.isAdded){
            supportFragmentManager.beginTransaction()
                    .add(R.id.container,fragment,MainFragment::class.java.name)
                    .commit()
        }
        MainPresenter(fragment,MusicRemoteDataSource)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        if (fragment.isAdded) {
            supportFragmentManager.putFragment(outState, MainFragment::class.java.simpleName, fragment)
        }
    }
}
