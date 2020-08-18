package com.example.tdp_basico_posta.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.tdp_basico_posta.R

/*
This activity shows the instructions of the game
 */
class InstructionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instructions)
    }

    /**
     * Returns to the last activity
     */
    fun returnInitial(view: View) {
        finish()
    }
}