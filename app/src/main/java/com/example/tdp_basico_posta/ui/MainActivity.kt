package com.example.tdp_basico_posta.ui

import android.content.Intent
import com.google.gson.reflect.TypeToken
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tdp_basico_posta.logic.Challenge
import com.example.tdp_basico_posta.logic.Controller
import com.example.tdp_basico_posta.R
import com.example.tdp_basico_posta.logic.FileController
import com.example.tdp_basico_posta.logic.Player
import com.google.gson.Gson
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
        jsonChallenges=""
        try {
            val archivo = applicationContext.assets.open("Challenges.JSON")
            jsonChallenges = archivo.bufferedReader().use { it.readText() }
        }
        catch (e:IOException){
            e.printStackTrace()
        }
    }

    fun addName(view:View){
        val name= editTextTextPersonName.text.toString()
        editTextTextPersonName.text.clear()
        names.add(name)
    }

    fun pressedStart(view: View){
        controller.start(jsonChallenges)
        setContentView(R.layout.activity_playing)
        textView.text=controller.party?.nextChallenge()?.description
        textView2.text=controller.party?.nextPlayer()?.name+"'s turn"


        //val intent = Intent(this, Playing::class.java)
        //intent.putExtra("controller",controller)
        //startActivity(intent)
    }

    fun donePressed(view: View){
        val actualChallenge=controller.party!!.actualChallenge
        val nextChallenge = controller.party!!.nextChallenge()
        val actualPlayer=controller.party!!.actualPlayer
        val nextPlayer = controller.party!!.nextPlayer()
        actualPlayer.points +=actualChallenge.value
        if (nextPlayer!=null) {
            textView.text = nextChallenge.description
            textView2.text = nextPlayer.name + "'s turn"
        }
    }

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


}