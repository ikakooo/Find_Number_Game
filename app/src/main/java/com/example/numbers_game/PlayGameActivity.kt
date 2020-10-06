package com.example.numbers_game

import android.annotation.SuppressLint
import android.content.res.Resources
import android.graphics.Color
import android.os.Bundle
import android.util.Log.d
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.numbers_game.CachedData.numberOfTrying
import com.example.numbers_game.Extensions.isTriedCharacter
import kotlinx.android.synthetic.main.activity_play_game.*
import kotlin.random.Random


class PlayGameActivity : AppCompatActivity() {
    private val randomNum = Random.nextInt(10).toString()
    private val triedNumbers = mutableListOf<String>()
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
    }


    @SuppressLint("ResourceAsColor", "SetTextI18n")
    fun ImageButton.customOnClickAction() {
        setOnClickListener {
            if (tag == randomNum) {
                textViewID.setTextColor(Color.GREEN)
                textViewID.text = "შენ მოიგე!!!"
                numberOfTrying = 5
                Tools.winDialog(this@PlayGameActivity, 1)
                d("hjedfchcre", randomNum)
            } else {

                if (isTriedCharacter(tag.toString(),triedNumbers)) {
                    textViewID.text = "ეს რიცხი არ ყოფილა. დაგრჩა $numberOfTrying ცდა"
                }else{
                    triedNumbers.add(tag.toString())
                    numberOfTrying--
                    textViewID.setTextColor(Color.RED)
                    textViewID.text = "სცადე თავიდან. დაგრჩა $numberOfTrying ცდა"}

                if (numberOfTrying <= 0) {
                    Tools.winDialog(this@PlayGameActivity, 0)
                }
            }
        }
    }



    private fun changeNumberSize(){

        val height = Resources.getSystem().displayMetrics.heightPixels
        val width =  Resources.getSystem().displayMetrics.widthPixels

        d("fwefe", "$width  $height")
    }

}