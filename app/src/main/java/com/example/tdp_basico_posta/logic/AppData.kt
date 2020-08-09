package com.example.tdp_basico_posta.logic

object AppData {
    val namesList = ArrayList<String>()
    val challengeList = ArrayList<Challenge>()

    fun addPlayer(name: String) {
        namesList.add(name)
    }

    fun addChallenge(challenge: Challenge) {
        challengeList.add(challenge)
    }


}