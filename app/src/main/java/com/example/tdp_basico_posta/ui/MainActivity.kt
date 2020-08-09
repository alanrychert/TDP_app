package com.example.tdp_basico_posta.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.tdp_basico_posta.R
import com.example.tdp_basico_posta.logic.AppData
import com.example.tdp_basico_posta.logic.Challenge
import com.example.tdp_basico_posta.logic.Controller
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_playing.*
import java.io.IOException


class MainActivity : AppCompatActivity() {
    val controller:Controller = Controller(this)
    val names = arrayListOf<String>()
    private lateinit var jsonChallenges: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        jsonChallenges = ""
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

    fun addName(view:View) {
        if (editTextTextPersonName.text.isNotEmpty() && editTextTextPersonName.text.isNotBlank()) {
            val name = editTextTextPersonName.text.toString()
            editTextTextPersonName.text.clear()
            AppData.addPlayer(name)
        }
        //names.add(name)
    }

    fun pressedStart(view: View){
        controller.start(jsonChallenges)
        setContentView(R.layout.activity_playing)
        textView.text = controller.party?.nextChallenge()?.description
        textView2.text = controller.party?.nextPlayer()?.name + "'s turn"


        //val intent = Intent(this, Playing::class.java)
        //intent.putExtra("controller",controller)
        //startActivity(intent)
    }

    fun returnInitial(view: View) {
        //val intent= Intent(this, InitialActivity::class.java)
        //startActivity(intent)
        finish()
    }

    fun donePressed(view: View) {
        val actualChallenge = controller.party!!.actualChallenge
        val nextChallenge = controller.party!!.nextChallenge()
        val actualPlayer = controller.party!!.actualPlayer
        val nextPlayer = controller.party!!.nextPlayer()
        actualPlayer.points += actualChallenge.value
        textView.text = nextChallenge.description
        textView2.text = nextPlayer.name + "'s turn"
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