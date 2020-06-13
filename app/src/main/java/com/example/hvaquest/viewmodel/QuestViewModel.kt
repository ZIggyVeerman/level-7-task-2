package com.example.hvaquest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hvaquest.model.Question
import com.example.hvaquest.repository.QuestRepository

class QuestViewModel : ViewModel() {
    private val questRepository = QuestRepository()
    private var questionList = questRepository.getHvaQuest()
    private var questId: Int = 0
    var currentQuestId = MutableLiveData<Int>()
    var totalQuests = questionList.size
    var currentQuestion = MutableLiveData<Question>()
    var finish = MutableLiveData<Boolean>()

    init {
        resetQuestion()
    }

    fun nextQuestion() {
        questId++
        currentQuestId.value = questId
        if (questId >= totalQuests) {
            finish.value = true
        } else {
            currentQuestion.value = questionList[questId]
        }
    }

    fun resetQuestion() {
        questId = 0
        finish.value = false
        currentQuestion.value = questionList[questId]
    }

}