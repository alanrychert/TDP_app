package com.example.tdp_basico_posta.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tdp_basico_posta.R
import com.example.tdp_basico_posta.logic.NamesAdapter
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val adapter = NamesAdapter()
    private lateinit var jsonChallenges: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        my_recycler_view.adapter = adapter
        my_recycler_view.layoutManager = LinearLayoutManager(this)
        my_recycler_view.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )
    }

    fun addName(view: View) {
        if (editTextTextPersonName.text.isNotEmpty() && editTextTextPersonName.text.isNotBlank()) {
            val name = editTextTextPersonName.text.toString()
            editTextTextPersonName.text.clear()
            adapter.addName(name)
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
