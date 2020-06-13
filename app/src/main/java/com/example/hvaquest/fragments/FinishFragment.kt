package com.example.hvaquest.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.example.hvaquest.R
import com.example.hvaquest.viewmodel.QuestViewModel
import kotlinx.android.synthetic.main.fragment_finish.*

class FinishFragment : Fragment() {

    private lateinit var questViewModel: QuestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_finish, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btFinish.setOnClickListener {
            questViewModel.resetQuestion()
            findNavController().navigate(R.id.action_FinishFragment_to_FirstFragment)
        }
    }
}
