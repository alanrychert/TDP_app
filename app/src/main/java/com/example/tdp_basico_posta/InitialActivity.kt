package com.example.tdp_basico_posta

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.tdp_basico_posta.logic.AppData
import com.example.tdp_basico_posta.logic.Challenge
import com.example.tdp_basico_posta.ui.AddChallengeActivity
import com.example.tdp_basico_posta.ui.MainActivity
import com.example.tdp_basico_posta.ui.RoundsActivity
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_SHORT
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class InitialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_initial)
        var jsonChallenges: String = ""
        try {
            val archivo = applicationContext.assets.open("Challenges.JSON")
            jsonChallenges = archivo.bufferedReader().use { it.readText() }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        val gson = Gson()
        val itemType = object : TypeToken<List<Challenge>>() {}.type
        val itemList = gson.fromJson<List<Challenge>>(jsonChallenges, itemType)

        for (challenge in itemList) {
            AppData.addChallenge(challenge)
        }
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
            val intent = Intent(this, RoundsActivity::class.java)
            startActivity(intent)
            //finish()
        } else {
            val mySnackbar = Snackbar.make(view, R.string.no_players, LENGTH_SHORT)
            mySnackbar.show()
        }
    }
}