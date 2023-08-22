package com.example.islamy.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.AdapterView.OnItemSelectedListener
import androidx.fragment.app.Fragment
import com.example.islamy.R
import com.example.islamy.databinding.ActivityHomeBinding
import com.example.islamy.ui.home.fragments.hadeth.HadethFragment
import com.example.islamy.ui.home.fragments.quran.QuranFragment
import com.example.islamy.ui.home.fragments.radio.RadioFragment
import com.example.islamy.ui.home.fragments.tasbeh.TasbehFragment
import com.google.android.material.navigation.NavigationBarView

class HomeActivity : AppCompatActivity() {

    lateinit var viewBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        viewBinding.content
            .mainNav.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.nav_quran -> {
                        showTabFragment(QuranFragment())
                    }

                    R.id.nav_hadeth -> {
                        showTabFragment(HadethFragment())
                    }

                    R.id.nav_sebha -> {
                        showTabFragment(TasbehFragment())
                    }

                    R.id.nav_radio -> {
                        showTabFragment(RadioFragment())
                    }
                }
                true
            }
        viewBinding.content.mainNav.selectedItemId = R.id.nav_quran
    }

    private fun showTabFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

}