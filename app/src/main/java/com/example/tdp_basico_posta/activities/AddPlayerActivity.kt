package com.example.tdp_basico_posta.activities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tdp_basico_posta.R
import com.example.tdp_basico_posta.logic.NamesAdapter
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_addplayer.*


class AddPlayerActivity : AppCompatActivity() {
    val adapter = NamesAdapter()

    /*
    Creates the activity, sets the layout and initialize the recyclerview adapter and layoutManager
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addplayer)

        my_recycler_view.adapter = adapter
        my_recycler_view.layoutManager = LinearLayoutManager(this)
        my_recycler_view.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )
    }

    /*
    Adds a name to the list of names in AppData if the editText is not blank or empty and the length of the input is <20
    in other case shows a message with de correct advice
     */
    fun addName(view: View) {
        val nameText = addPlayer_nameEditText.text
        if (nameText.isNotEmpty() && nameText.isNotBlank()) {
            if (addPlayer_nameEditText.text.length < 20) {
                val name = nameText.toString()
                    .trim() //Returns the name having leading and trailing whitespace removed.
                if (adapter.alreadyExists(name)) {
                    Toast.makeText(this, R.string.same_name, LENGTH_SHORT).show()
                } else {
                    adapter.addName(name)
                }
                nameText.clear()
            } else {
                Toast.makeText(this, R.string.large_name, LENGTH_SHORT).show()
            }
        } else {
            val mySnackbar = Snackbar.make(
                view, R.string.incomplete_info,
                BaseTransientBottomBar.LENGTH_SHORT
            )
            mySnackbar.show()
        }
    }

    /*
    Returns to the initial activity
     */
    fun returnInitial(view: View) {
        //val intent= Intent(this, InitialActivity::class.java)
        //startActivity(intent)
        finish()
    }


}
