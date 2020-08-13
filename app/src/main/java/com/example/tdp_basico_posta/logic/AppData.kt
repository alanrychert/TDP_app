package com.example.tdp_basico_posta.logic

/*
    This class contains the information of the input (players names, amount of rounds, and challenges)
    including the challenges that are extracted from the challenges file
 */
object AppData {
    val namesList = ArrayList<String>()
    val challengeList = ArrayList<Challenge>()
    var rounds = 3

    /*
    Add the name of a player to the list of names
     */
    fun addPlayer(name: String) {
        namesList.add(name)
    }

    /*
    Add a challenge to the list of challenges
     */
    fun addChallenge(challenge: Challenge) {
        challengeList.add(challenge)
    }

    /*
    Erase all the names from the list of names
     */
    fun resetNamesList() {
        namesList.clear()
    }

    /*
    Erase all the challenges from the list of challenges
     */
    fun resetChallengeList() {
        challengeList.clear()
    }

}