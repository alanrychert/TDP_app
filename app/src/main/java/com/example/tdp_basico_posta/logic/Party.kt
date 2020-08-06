package com.example.tdp_basico_posta.logic

data class Party (private val challenges: List<Challenge>){
    private var players : MutableList<Player>? =null
    private var turnAmount:Int=0

    fun nextPlayer(){

    }

}