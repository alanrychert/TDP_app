package com.example.tdp_basico_posta.activities

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

    /*
    Creates the activity, sets the layout and creates a new party with the names of the players and the challenges.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playing)
        party = Party(AppData.namesList, AppData.challengeList, AppData.rounds)
        nextTurn()
    }

    /*
    Add the value of the challenge to the actualPlayer points and actualize the turn
     */
    fun donePressed(view: View) {
        if (!finished()) {
            party.actualPlayer.points += party.actualChallenge.value
            nextTurn()
        } else
            gameFinished()
    }

    /*
    Actualizes the turn
     */
    fun notDonePressed(view: View) {
        if (!finished()) {
            nextTurn()
        } else {
            gameFinished()
        }

    }

    /*
    Skips the challenge without changing the turn
     */
    fun skipChallenge(view: View) {
        val newChallenge = party.nextChallenge()
        playing_challengeTextView.text = newChallenge.description
        playing_drinksNumberTextView.text = newChallenge.value.toString()
    }

    /*
    Starts a WinnerActivity passing the name of the winner to it and finishes this activity
     */
    private fun gameFinished() {
        val winner = party.getWinner()
        val intent = Intent(this, WinnerActivity::class.java)
        intent.putExtra("winner", winner.name)
        startActivity(intent)
        finish()
    }

    /*
    If the actualTurn is equal to the turnAmount returns yes, if not returns no
     */
    private fun finished(): Boolean {
        return party.turnAmount == party.actualTurn
    }

    /*
    Actualizes the turn getting the new challenge and the new player, and actualizes all the text fields
     */
    private fun nextTurn() {
        val actualChallenge = this.party.nextChallenge()
        val playerName = this.party.nextPlayer().name
        playing_challengeTextView.text = actualChallenge.description
        playing_drinksNumberTextView.text = actualChallenge.value.toString()
        playing_playerTurnTextView.text = String.format(getString(R.string.player_turn), playerName)
    }

    /*
    Prevents of returning to the last activity
     */
    override fun onBackPressed() {

    }

}