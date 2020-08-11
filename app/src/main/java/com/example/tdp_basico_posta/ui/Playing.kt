package com.example.tdp_basico_posta.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
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
        party = Party(AppData.namesList, AppData.challengeList, AppData.rounds)
        nextTurn()
    }

    fun donePressed(view: View) {
        if (!finished()) {
            party.actualPlayer.points += party.actualChallenge.value
            nextTurn()
        } else
            gameFinished()
    }

    fun notDonePressed(view: View) {
        if (!finished()) {
            nextTurn()
        } else {
            gameFinished()
        }

    }

    fun skipChallenge(view: View) {
        val newChallenge = party.nextChallenge()
        textView.text = newChallenge.description
        textView4.text = newChallenge.value.toString()
    }

    private fun gameFinished() {
        val winner = party.getWinner()
        val intent = Intent(this, WinnerActivity::class.java)
        intent.putExtra("winner", winner.name)
        startActivity(intent)
        finish()
    }

    private fun finished(): Boolean {
        return party.turnAmount == party.actualTurn
    }

    private fun nextTurn() {
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