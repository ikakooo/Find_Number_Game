package com.example.numbers_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.numbers_game.CachedData.numberOfTrying
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }



    private fun init(){

        imageViewPlusID.setOnClickListener {
            if (numberOfTrying < 9 )numberOfTrying++
            textViewTryingNumberID.text = numberOfTrying.toString()
        }

        imageViewMinusID.setOnClickListener {
            if (numberOfTrying > 1 )numberOfTrying--
            textViewTryingNumberID.text = numberOfTrying.toString()
        }













        startGameID.setOnClickListener {
            val intent = Intent(this, PlayGameActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

        }


    }
}