package com.example.tdp_basico_posta

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.tdp_basico_posta.logic.AppData
import com.example.tdp_basico_posta.ui.AddChallengeActivity
import com.example.tdp_basico_posta.ui.MainActivity
import com.example.tdp_basico_posta.ui.Playing

class InitialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_initial)
    }

    fun goAddPlayer(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun goAddChallenge(view: View) {
        val intent = Intent(this, AddChallengeActivity::class.java)
        startActivity(intent)
    }

    fun start(view: View) {
        if (AppData.namesList.isNotEmpty()) {
            val intent = Intent(this, Playing::class.java)
            startActivity(intent)
            finish()
        }
    }
}