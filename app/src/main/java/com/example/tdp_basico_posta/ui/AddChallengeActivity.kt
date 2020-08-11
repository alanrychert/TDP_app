package com.example.tdp_basico_posta.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.tdp_basico_posta.R
import com.example.tdp_basico_posta.logic.AppData
import com.example.tdp_basico_posta.logic.Challenge
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_addchallenge.*
import kotlinx.android.synthetic.main.activity_main.editTextTextPersonName
import java.io.IOException


class AddChallengeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addchallenge)
    }

    fun chargeFile(fileName: String) {
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


    fun addChallenge(view: View) {
        if (editTextTextPersonName.text.isNotEmpty() && editTextTextPersonName.text.isNotBlank() && editTextNumberDecimal.text.isNotEmpty() && editTextNumberDecimal.text.isNotBlank()) {
            val description = editTextTextPersonName.text.toString()
            val value = editTextNumberDecimal.text.toString().toInt()
            val challenge = Challenge(description, value)
            AppData.addChallenge(challenge)
            editTextTextPersonName.text.clear()
            editTextNumberDecimal.text.clear()
        } else {
            val mySnackbar = Snackbar.make(
                view, R.string.incomplete_info,
                BaseTransientBottomBar.LENGTH_SHORT
            )
            mySnackbar.show()
        }
    }


    fun returnInitial(view: View) {
        //val intent= Intent(this, InitialActivity::class.java)
        //startActivity(intent)
        finish()
    }

/*
    fun notDonePressed(view:View){
        val nextChallenge = controller.party!!.nextChallenge()
        val nextPlayer = controller.party!!.nextPlayer()
        if (nextPlayer!=null) {
            textView.text = nextChallenge.description
            textView2.text = nextPlayer.name + "'s turn"
        }
    }

    fun gameFinished( winner:Player){
        textView2.setText(R.string.blank)
        textView.text= "The winner is "+winner.name
        button5.visibility=View.INVISIBLE
        button6.visibility=View.INVISIBLE
    }

 */


}