package com.example.islamy.ui.home.fragments.hadeth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.islamy.databinding.FragmentHadethBinding
import com.example.islamy.ui.Constants
import com.example.islamy.ui.chapterDetails.ChapterDetailsActivity
import com.example.islamy.ui.hadethDetails.HadethDetailsActivity
import com.example.islamy.ui.model.Hadeth

class HadethFragment : Fragment() {

    lateinit var viewBinding:FragmentHadethBinding
    val hadethList = mutableListOf<Hadeth>()
    lateinit var adapter: HadethRecyclerView
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHadethBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        adapter = HadethRecyclerView(null)
        layoutManager = LinearLayoutManager(requireActivity() ,LinearLayoutManager.VERTICAL, false)
        viewBinding.ahadethRv.adapter = adapter
        viewBinding.ahadethRv.layoutManager = layoutManager
        adapter.onItemClickListener = HadethRecyclerView.OnItemClickListener { position, hadeth->
            showHadethDetails(hadeth)
        }
    }

    private fun showHadethDetails(hadeth: Hadeth) {
        val intent = Intent(activity, HadethDetailsActivity::class.java)
        intent.putExtra(Constants.EXTRA_HADETH, hadeth)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        loadHadethFile()
        bindHadethList()
    }

    private fun bindHadethList() {
        adapter.bindItems(hadethList)
    }

    private fun loadHadethFile() {
        val fileContent = requireActivity().assets.open("ahadeth.txt").bufferedReader().use { it.readText() }
        val singleHadethList = fileContent.trim().split("#")
        singleHadethList.forEach {
            val lines = it.trim().split("\n")
            val title = lines[0]
            val content = lines.joinToString("\n")
            val hadeth = Hadeth(title, content)
            hadethList.add(hadeth)
        }
    }

}