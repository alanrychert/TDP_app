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
        val winnerName = intent.getStringExtra("winner")
        if (winnerName != null) {
            textView6.text = "The winner is $winnerName"
        }
    }

    fun restart(view: View) {
        val intent = Intent(this, RoundsActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun goInitial(view: View) {
        val intent = Intent(this, InitialActivity::class.java)
        AppData.resetChallengeList()
        AppData.resetNamesList()
        startActivity(intent)
        finish()

    }

    override fun onBackPressed() {

    }
}