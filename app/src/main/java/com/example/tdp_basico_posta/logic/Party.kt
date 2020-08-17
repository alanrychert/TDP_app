package com.example.tdp_basico_posta.logic

import kotlin.random.Random


class Party(
    private val names: ArrayList<String>,
    private val challenges: MutableList<Challenge>,
    private val rounds: Int = 3
) {
    private val players = ArrayList<Player>()
    var turnAmount: Int = names.size * rounds
    var actualTurn: Int = 0
    var actualPlayer = Player("")
    var actualChallenge = challenges[Random.nextInt(challenges.size)]

    init {
        names.forEach {
            players.add(Player(it))
        }
        actualPlayer = players.first()
    }


    fun nextPlayer(): Player {
        val next = players[actualTurn % players.size]
        actualTurn++
        actualPlayer = next
        return next
    }

    fun nextChallenge(): Challenge {
        val random = Random
        val index = random.nextInt(challenges.size)
        actualChallenge = challenges[index]
        //challenges.removeAt(index)
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