package com.example.tdp_basico_posta.logic

import com.example.tdp_basico_posta.ui.MainActivity


class Controller (private val main: MainActivity){
    var party:Party? = null

    fun start(toParse: String) {
        //val gson= Gson()
        //val itemType = object : TypeToken<List<Challenge>>() {}.type
        //val itemList = gson.fromJson<List<Challenge>>(toParse, itemType)

        //party=Party(main.names,itemList)
    }

    fun finish(){
        //main.gameFinished(party!!.getWinner())
    }
}