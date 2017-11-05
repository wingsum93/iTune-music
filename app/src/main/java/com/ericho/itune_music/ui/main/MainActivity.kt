package com.ericho.itune_music.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ericho.itune_music.Injection
import com.ericho.itune_music.R

class MainActivity : AppCompatActivity() {

    private lateinit var fragment: MainFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        savedInstanceState?.let {
            fragment = supportFragmentManager.getFragment(it, MainFragment::class.java.simpleName) as MainFragment
        }?:kotlin.run {
            fragment = MainFragment.newInstance()
        }

        if(!fragment.isAdded){
            supportFragmentManager.beginTransaction()
                    .add(R.id.container, fragment, "ggg")
                    .commit()
        }
        MainPresenter(fragment,Injection.provideMusicDataSource())
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        if (fragment.isAdded) {
            supportFragmentManager.putFragment(outState, MainFragment::class.java.simpleName, fragment)
        }
    }
}
