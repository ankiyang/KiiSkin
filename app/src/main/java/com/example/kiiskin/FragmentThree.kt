package com.example.kiiskin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import kotlinx.android.synthetic.main.fragment_support.*


class FragmentThree : Fragment() {
//onViewCreated在onCreateView执行完后立即执行。
//onCreateView返回的就是fragment要显示的view。
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_support, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        SendStoryButton.setOnClickListener {
//            Toast.makeText(content, "Advices Send", Toast.LENGTH_SHORT).show()
//            val mes: String = AdviceInput.text.toString()
        }


    }


}
