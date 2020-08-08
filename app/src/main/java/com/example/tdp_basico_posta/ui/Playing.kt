package com.example.tdp_basico_posta.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tdp_basico_posta.R
import com.example.tdp_basico_posta.logic.Controller
import kotlinx.android.synthetic.main.activity_playing.*

class Playing() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playing)
        //controller= intent.extras?.get("controller") as Controller
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