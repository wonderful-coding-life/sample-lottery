package com.xhiftcorp.lottery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    var countDownTimer = object : CountDownTimer(2000, 100) {
        override fun onTick(p0: Long) {
            val lotteryList = arrayListOf(number11, number12, number13, number14, number15, number16)
            lotteryList.forEach {
                it.setText("" + ((Math.random() * 45).toInt() + 1));
            }
            Log.i(TAG, "onTick: " + p0)
        }

        override fun onFinish() {
            Log.i(TAG, "onFinish: ")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        lotteryWhirl.setOnClickListener {
            if (!lotteryWhirl.isAnimating) {
                lotteryWhirl.playAnimation();
                countDownTimer.start()
                //shuffleLotteryNumber()
            }
        }


    }

//    fun shuffleLotteryNumber() {
//        lotteryList.forEach {
//            it.setText("TEST")
//        }
//    }
}