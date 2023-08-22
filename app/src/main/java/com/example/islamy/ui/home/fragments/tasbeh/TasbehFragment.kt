package com.example.islamy.ui.home.fragments.tasbeh

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamy.databinding.FragmentTasbehBinding

class TasbehFragment: Fragment() {

    lateinit var viewBinding:FragmentTasbehBinding
    var counter: Int = 0
    var currentCounter = 0
    val tasbehList = mutableListOf<String>("سبحان الله", "الحمد لله", "لا إله الا الله", "الله أكبر")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentTasbehBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.tasbeehTv.text = tasbehList[0]
        viewBinding.tasbeehTv.setOnClickListener {
            onTasbehClick()
        }
    }

    private fun onTasbehClick(){
        viewBinding.sebha.rotation = 10F
        counter++
        currentCounter++
        viewBinding.counterTv.text = currentCounter.toString()
        if(counter == 132) {
            counter = 0
            currentCounter = 0
        }
        if (counter % 33 == 0) {
            currentCounter = 0
            viewBinding.counterTv.text = currentCounter.toString()
            viewBinding.tasbeehTv.text = tasbehList[counter / 33]
        }
    }

}