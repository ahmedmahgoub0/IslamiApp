package com.example.islamy.ui.hadethDetails

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.islamy.R
import com.example.islamy.databinding.ActivityHadethDetailsBinding
import com.example.islamy.ui.Constants
import com.example.islamy.ui.model.Hadeth

class HadethDetailsActivity : AppCompatActivity() {

    lateinit var viewBinding: ActivityHadethDetailsBinding
    var hadeth: Hadeth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initViews()
        initParams()
        bindHadeth()
    }

    private fun initViews() {
        setSupportActionBar(viewBinding.toolBar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }

    private fun initParams() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            hadeth = intent.getParcelableExtra(Constants.EXTRA_HADETH, Hadeth::class.java)
        } else {
            hadeth = intent.getParcelableExtra(Constants.EXTRA_HADETH,) as Hadeth?
        }

    }

    private fun bindHadeth() {
        viewBinding.hadethName.text = hadeth?.title
        viewBinding.hadethcontent.hadethContent.text = hadeth?.content
    }

}