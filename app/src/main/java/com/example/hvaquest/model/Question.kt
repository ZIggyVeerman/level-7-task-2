package com.example.hvaquest.model

data class Question(
    var question: String,
    var choices: Array<String>,
    var correctAnswer: String,
    var clue: Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Question

        if (question != other.question) return false
        if (!choices.contentEquals(other.choices)) return false
        if (correctAnswer != other.correctAnswer) return false
        if (clue != other.clue) return false

        return true
    }

    override fun hashCode(): Int {
        var result = question.hashCode()
        result = 31 * result + choices.contentHashCode()
        result = 31 * result + correctAnswer.hashCode()
        result = 31 * result + clue
        return result
    }
}
