package com.example.numbers_game

import android.annotation.SuppressLint
import android.content.res.Resources
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
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
        changeNumberSize()
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
                Tools.winDialog(this@PlayGameActivity, 1)
                Log.d("hjedfchcre", randomNum)
            } else {
                numberOfTrying--
                if (numberOfTrying <= 0) {
                    Tools.winDialog(this@PlayGameActivity, 0)
                }
                textViewID.setTextColor(Color.RED)
                textViewID.text = "სცადე თავიდან. დაგრჩა $numberOfTrying ცდა"
            }
        }
    }



    private fun changeNumberSize(){

        val height = Resources.getSystem().displayMetrics.heightPixels
        val width =  Resources.getSystem().displayMetrics.widthPixels
       // R.dimen.numbersSize
        Log.d("fwefe", "$width  $height")
    }

}