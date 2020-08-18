package com.example.tdp_basico_posta.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.tdp_basico_posta.R
import com.example.tdp_basico_posta.logic.AppData
import com.example.tdp_basico_posta.logic.Challenge
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_SHORT
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class InitialActivity : AppCompatActivity() {

    /*
    Reads all the challenges from the challenges JSON file and add them to AppData
    */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_initial)
        val fileName = getString(R.string.file_name)
        var jsonChallenges: String = ""
        try {
            val archivo = applicationContext.assets.open(fileName)
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

    /*
     * Starts AddPlayerActivity
     */
    fun goAddPlayer(view: View) {
        val intent = Intent(this, AddPlayerActivity::class.java)
        startActivity(intent)
    }

    /*
     * Starts AddChallengeActivity
     */
    fun goAddChallenge(view: View) {
        val intent = Intent(this, AddChallengeActivity::class.java)
        startActivity(intent)
    }

    /*
     * Starts InstructionsActivity
     */
    fun goInstructions(view: View) {
        val intent = Intent(this, InstructionsActivity::class.java)
        startActivity(intent)
    }

    /*
     * Starts RoundsActivity
     * if the user did not add at least 1 player shows a snackbar with the advice
     */
    fun start(view: View) {
        if (AppData.namesList.size >= 2) {
            val intent = Intent(this, RoundsActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            //finish()
        } else {
            val mySnackbar = Snackbar.make(
                view,
                R.string.no_players, LENGTH_SHORT
            )
            mySnackbar.show()
        }
    }
}