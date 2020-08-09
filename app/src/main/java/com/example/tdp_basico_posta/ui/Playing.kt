package com.example.tdp_basico_posta.ui

import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import androidx.appcompat.app.AppCompatActivity
import com.example.tdp_basico_posta.R
import com.example.tdp_basico_posta.logic.AppData
import com.example.tdp_basico_posta.logic.Party
import kotlinx.android.synthetic.main.activity_playing.*

class Playing : AppCompatActivity() {
    lateinit var party: Party
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playing)
        party = Party(AppData.namesList, AppData.challengeList)
        fillTexts()
    }

    fun donePressed(view: View) {
        if (!finished()) {
            party.actualPlayer.points += party.actualChallenge.value
            fillTexts()
        } else
            gameFinished()
    }

    fun notDonePressed(view: View) {
        if (!finished()) {
            fillTexts()
        } else {
            gameFinished()
        }

    }

    private fun gameFinished() {
        val winner = party.getWinner()
        textView2.setText(R.string.blank)
        textView.text = "The winner is " + winner.name
        button5.visibility = INVISIBLE
        button6.visibility = INVISIBLE
        textView5.visibility = INVISIBLE
        textView4.visibility = INVISIBLE

    }

    private fun finished(): Boolean {
        return party.turnAmount == party.actualTurn
    }

    private fun fillTexts() {
        val actualChallenge = this.party.nextChallenge()
        textView.text = actualChallenge.description
        textView4.text = actualChallenge.value.toString()
        textView2.text = party.nextPlayer().name + "'s turn"
    }

    override fun onBackPressed() {

    }
/*
    fun donePressed(view: View){
        textView.text=controller?.party?.nextChallenge()!!.description
        controller?.party?.nextPlayer()?.points =
            controller?.party?.nextPlayer()?.points?.plus(controller?.party?.nextChallenge()!!.value)!!
    }

    fun notDonePressed(view:View){
        textView.text=controller?.party?.nextChallenge()!!.description
        controller?.party?.nextPlayer()
    }

 */
}