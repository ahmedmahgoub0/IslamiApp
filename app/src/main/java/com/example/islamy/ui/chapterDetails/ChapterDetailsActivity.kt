package com.example.islamy.ui.chapterDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.islamy.databinding.ActivityChapterDetailsBinding
import com.example.islamy.ui.Constants

class ChapterDetailsActivity : AppCompatActivity() {

    lateinit var viewBinding: ActivityChapterDetailsBinding
    lateinit var chapterName: String
    var chapterPosition: Int = 0
    lateinit var adapter: VersesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityChapterDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initParams()
        initViews()
        loadChapterFile()
    }

    private fun initViews() {
        viewBinding.suraNameTv.text = chapterName
        setSupportActionBar(viewBinding.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = ""
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }


    private fun initParams() {
        chapterName = intent.getStringExtra(Constants.EXTRA_CHAPTER_NAME)?:""
        chapterPosition = intent.getIntExtra(Constants.EXTRA_CHAPTER_POSITION, 0)
    }

    private fun loadChapterFile() {
        val fileContent = assets.open("$chapterPosition.txt").bufferedReader().use { it.readText() }
        val lines = fileContent.trim().split("\n")
        bindVerses(lines)
    }


    private fun bindVerses(lines: List<String>) {
        adapter = VersesAdapter(lines)
        viewBinding.contentSuraDetails.versesRv.adapter = adapter
    }
}