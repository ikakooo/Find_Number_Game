package com.example.numbers_game

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.dialog_layout.*

object Tools {


    @Suppress("DEPRECATION")
    @SuppressLint("SetTextI18n")
    fun winDialog(context: Context, case: Int) {
        val dialog = Dialog(context)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_layout)

        val params: ViewGroup.LayoutParams = dialog.window!!.attributes
        params.width = ViewGroup.LayoutParams.MATCH_PARENT
        params.height = ViewGroup.LayoutParams.MATCH_PARENT
        dialog.window!!.attributes = params as WindowManager.LayoutParams
        dialog.dialogTitleTextViewID.text = "No Internet Connection"
        if (case == 0) dialog.imageViewWinOrLoseID.setImageResource(R.mipmap.gameover)
        dialog.show()

        dialog.dialogOkButton.setOnClickListener {
            CachedData.numberOfTrying = 5
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
            //overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }


    }

}