package com.example.tdp_basico_posta.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.tdp_basico_posta.InitialActivity
import com.example.tdp_basico_posta.R
import com.example.tdp_basico_posta.logic.AppData
import kotlinx.android.synthetic.main.activity_winner.*

class WinnerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winner)
        val winnerNameText = intent.getStringExtra("winner")
        if (winnerNameText != null) {
            textView6.text = String.format(getString(R.string.winner_is), winnerNameText)
        }
    }

    /*
    Start a roundsActivity and finishes this activity without erasing the list of names players and challenges
    and finishes this activity
     */
    fun restart(view: View) {
        val intent = Intent(this, RoundsActivity::class.java)
        startActivity(intent)
        finish()
    }

    /*
    Start a InitialActivity and erases the list of names and the list of challenges
    and finishes this activity
     */
    fun goInitial(view: View) {
        val intent = Intent(this, InitialActivity::class.java)
        AppData.resetChallengeList()
        AppData.resetNamesList()
        startActivity(intent)
        finish()

    }

    /*
    prevents of returning to the last activity
     */
    override fun onBackPressed() {

    }
}