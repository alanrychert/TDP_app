package com.example.tdp_basico_posta.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.tdp_basico_posta.R
import com.example.tdp_basico_posta.logic.AppData
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_rounds.*

class RoundsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rounds)
    }

    /**
     * Gets the amount of rounds from the editText and set that amount of rounds in AppData
     * if the input is 0 shows a snackbar with the advice, and if the input is blank or
     *  null sets 3
     */
    fun setRoundsAmount(view: View) {
        val intent = Intent(this, Playing::class.java)
        val input = editTextNumber.text
        if (!input.isNullOrBlank() and !input.isEmpty()) {
            if (input.toString().toInt() == 0) {
                val mySnackbar = Snackbar.make(
                    view,
                    R.string.input_0,
                    BaseTransientBottomBar.LENGTH_SHORT
                )
                mySnackbar.show()
            } else {
                AppData.rounds = editTextNumber.text.toString().toInt()
                startActivity(intent)
                finish()
            }
        } else {
            startActivity(intent)
            finish()
        }
    }
}