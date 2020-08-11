package com.example.tdp_basico_posta.logic

object AppData {
    val namesList = ArrayList<String>()
    val challengeList = ArrayList<Challenge>()
    var rounds = 3

    fun addPlayer(name: String) {
        namesList.add(name)
    }

    fun addChallenge(challenge: Challenge) {
        challengeList.add(challenge)
    }

    fun resetNamesList() {
        namesList.clear()
    }

    fun resetChallengeList() {
        challengeList.clear()
    }

}