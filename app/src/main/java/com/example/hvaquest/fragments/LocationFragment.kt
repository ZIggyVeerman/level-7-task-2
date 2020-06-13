package com.example.hvaquest.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.hvaquest.R
import com.example.hvaquest.viewmodel.QuestViewModel
import kotlinx.android.synthetic.main.fragment_location.*

class LocationFragment : Fragment() {

    private lateinit var questViewModel: QuestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflate viewmodel
        questViewModel =
            ViewModelProvider(activity as AppCompatActivity).get(QuestViewModel::class.java)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }

    private fun observeViewModel() {
        questViewModel.currentQuestion.observe(viewLifecycleOwner, Observer { questionValue ->
            ivLocation.setImageResource(questionValue.clue)
            onclick()
        })
    }

    private fun onclick() {
        btNext.setOnClickListener {
            questViewModel.nextQuestion()
            if (questViewModel.finish.value!!) {
                findNavController().navigate(R.id.action_LocationFragment_to_FinishFragment)
            } else {
                findNavController().navigate(R.id.action_LocationFragment_to_QuestFragment)
            }
        }
    }
}
