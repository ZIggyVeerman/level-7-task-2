package com.example.hvaquest.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.hvaquest.R
import com.example.hvaquest.model.Question
import com.example.hvaquest.viewmodel.QuestViewModel
import kotlinx.android.synthetic.main.fragment_quest.*

class QuestFragment : Fragment() {

    private lateinit var questViewModel: QuestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflate viewmode
        questViewModel =
            ViewModelProvider(activity as AppCompatActivity).get(QuestViewModel::class.java)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quest, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }

    private fun observeViewModel() {
        questViewModel.currentQuestId.observe(viewLifecycleOwner, Observer { questionValue ->
            updateValueInt(questionValue)
        })

        questViewModel.currentQuestion.observe(viewLifecycleOwner, Observer { newQuestion ->
            updateQuestion(newQuestion)
        })
    }

    private fun updateValueInt(questionValue: Int) {
        tvQuestionCounter.text = "$questionValue/ ${questViewModel.totalQuests}"
    }

    private fun updateQuestion(question: Question) {
        tvQuestion.text = question.question
        radioButton1.text = question.choices[0]
        radioButton2.text = question.choices[1]
        radioButton3.text = question.choices[2]

        btConfirm.setOnClickListener {
            val clicked = groupRadioButtons.checkedRadioButtonId
            if (clicked == -1) {
                Toast.makeText(context, "Pick one", Toast.LENGTH_SHORT).show()
            } else {
                val clickedRadioButton = groupRadioButtons.findViewById<RadioButton>(clicked)
                if (clickedRadioButton.text == question.correctAnswer) {
                    findNavController().navigate(R.id.action_QuestFragment_to_LocationFragment)
                } else {
                    Toast.makeText(context, "Incorrects", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }


}
