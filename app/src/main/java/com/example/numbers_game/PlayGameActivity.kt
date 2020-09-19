package com.example.numbers_game

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ImageButton
import com.example.numbers_game.CachedData.numberOfTrying
import kotlinx.android.synthetic.main.activity_play_game.*
import kotlin.random.Random


class PlayGameActivity : AppCompatActivity() {
    private val randomNum = Random.nextInt(10).toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_game)
        init()
    }

    private fun init() {

        imageButton0.customOnClickAction()
        imageButton1.customOnClickAction()
        imageButton2.customOnClickAction()
        imageButton3.customOnClickAction()
        imageButton4.customOnClickAction()
        imageButton5.customOnClickAction()
        imageButton6.customOnClickAction()
        imageButton7.customOnClickAction()
        imageButton8.customOnClickAction()
        imageButton9.customOnClickAction()
        Log.d("hjechcre", randomNum)
    }


    @SuppressLint("ResourceAsColor", "SetTextI18n")
    fun ImageButton.customOnClickAction() {
        setOnClickListener {

            if (tag == randomNum) {
                textViewID.setTextColor(Color.GREEN)
                textViewID.text = "შენ მოიგე!!!"
                numberOfTrying = 5
                Tools.winDialog(this@PlayGameActivity,1)
                endGame()
                Log.d("hjedfchcre", randomNum)
            } else {
                numberOfTrying--
                if (numberOfTrying <= 0) {
                    Tools.winDialog(this@PlayGameActivity,0)
                    endGame()
                }
                textViewID.setTextColor(Color.RED)
                textViewID.text = "სცადე თავიდან. დაგრჩა $numberOfTrying ცდა"

            }


        }
    }
    @Suppress("DEPRECATION")
    private fun endGame() {
        Handler().postDelayed({
            val intent = Intent(this@PlayGameActivity, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }, 1500)
    }

}