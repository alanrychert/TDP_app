package com.example.tdp_basico_posta.logic

import kotlin.random.Random


class Party(
    names: ArrayList<String>,
    private val challenges: MutableList<Challenge>,
    rounds: Int = 3
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

    /*
    Returns the next player
     */
    fun nextPlayer(): Player {
        val next = players[actualTurn % players.size]
        actualTurn++
        actualPlayer = next
        return next
    }

    /*
    Returns the next challenge
     */
    fun nextChallenge(): Challenge {
        val random = Random
        val index = random.nextInt(challenges.size)
        actualChallenge = challenges[index]
        //challenges.removeAt(index)
        return actualChallenge
    }

    /*
    Returns the winner of the game
     */
    fun getWinner(): Player {
        var winner: Player = players.first()
        for (i in 1 until players.size) {
            if (players[i].points > winner.points)
                winner = players[i]
        }
        return winner
    }
}