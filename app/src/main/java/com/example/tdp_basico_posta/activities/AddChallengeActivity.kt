package com.example.tdp_basico_posta.activities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import com.example.tdp_basico_posta.R
import com.example.tdp_basico_posta.logic.AppData
import com.example.tdp_basico_posta.logic.Challenge
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_addchallenge.*


class AddChallengeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addchallenge)
    }

    /*
    Adds a new challenge if the editTexts are not empty or blank and the description's length is <=100
    in any other case shows a message with de correct advice
     */
    fun addChallenge(view: View) {
        val descriptText = addChallenge_descriptionEditText.text
        val valueText = addChallenge_valueEditText.text
        if (descriptText.isNotEmpty() && descriptText.isNotBlank() && valueText.isNotEmpty() && valueText.isNotBlank()) {
            val description = descriptText.toString()
            val value = valueText.toString().toInt()
            val challenge = Challenge(description, value)
            if (description.length <= 100) {
                AppData.addChallenge(challenge)
                descriptText.clear()
                valueText.clear()
            } else {
                Toast.makeText(this, R.string.large_description, LENGTH_SHORT).show()
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
    Returns to the initial Activity
     */
    fun returnInitial(view: View) {
        //val intent= Intent(this, InitialActivity::class.java)
        //startActivity(intent)
        finish()
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