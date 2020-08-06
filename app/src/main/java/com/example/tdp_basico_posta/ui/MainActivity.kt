package com.example.tdp_basico_posta.ui

import com.google.gson.reflect.TypeToken
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tdp_basico_posta.logic.Challenge
import com.example.tdp_basico_posta.logic.Controller
import com.example.tdp_basico_posta.R
import com.google.gson.Gson
import java.io.IOException


class MainActivity : AppCompatActivity() {
    val controller:Controller = Controller()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var json=""
        try {
            val archivo = applicationContext.assets.open("Challenges.JSON")
            json = archivo.bufferedReader().use { it.readText() }
        }
        catch (e:IOException){
            e.printStackTrace()
        }
        val gson= Gson()
        val itemType = object : TypeToken<List<Challenge>>() {}.type
        var itemList = gson.fromJson<List<Challenge>>(json, itemType)


    }

}