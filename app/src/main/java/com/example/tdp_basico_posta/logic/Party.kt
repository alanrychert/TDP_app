package com.example.tdp_basico_posta.logic

import kotlin.random.Random

data class Party (var names : ArrayList<String>,private val challenges: List<Challenge>, val controller: Controller){
    private val players = ArrayList<Player>()
    var turnAmount:Int=0
    var actualTurn:Int=0
    var actualPlayer=Player("")
    var actualChallenge=Challenge("",0)

    init {
        names.forEach(){
            players.add(Player(it))
        }
        turnAmount=players.size*3
    }


    fun nextPlayer(): Player? {
        var next : Player? = null
        if (turnAmount > actualTurn) {
            next = players[actualTurn % players.size]
            actualTurn++
            actualPlayer=next
        } else {
            controller.finish()
        }
        return next
    }

    fun nextChallenge():Challenge{
        val random= Random
        val index= random.nextInt(challenges.size)
        actualChallenge=challenges[index]
        return actualChallenge
    }

    fun getWinner(): Player{
        var winner:Player =players.first()
        for (i in 1 until players.size){
            if (players[i].points>winner.points)
                winner=players[i]
        }
        return winner
    }
}