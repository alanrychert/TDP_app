package com.example.tdp_basico_posta.logic

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class FileController(private val context: Context, private val fileName: String) {

    fun parseJSON() :  List<Challenge> {
        var json = ""
        try {
            val archivo = context.assets.open(fileName)
            json = archivo.bufferedReader().use { it.readText() }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        val gson = Gson()
        val itemType = object : TypeToken<List<Challenge>>() {}.type
        val itemList = gson.fromJson<List<Challenge>>(json, itemType)

        return itemList
    }

}