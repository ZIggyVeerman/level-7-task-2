package com.example.hvaquest.viewmodel

import androidx.lifecycle.ViewModel
import com.example.hvaquest.repository.QuestRepository

class QuestViewModel : ViewModel() {
    private val questRepository = QuestRepository()
    private var questionList = questRepository.getHvaQuest()


    fun nextQuestion() {

    }

    fun resetQuestion() {

    }

}