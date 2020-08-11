package com.example.tdp_basico_posta.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.tdp_basico_posta.R
import com.example.tdp_basico_posta.logic.AppData
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val names = arrayListOf<String>()
    private lateinit var jsonChallenges: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun addName(view: View) {
        if (editTextTextPersonName.text.isNotEmpty() && editTextTextPersonName.text.isNotBlank()) {
            val name = editTextTextPersonName.text.toString()
            editTextTextPersonName.text.clear()
            AppData.addPlayer(name)
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
}
