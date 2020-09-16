package com.xhiftcorp.lottery

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    var countDownTimer = object : CountDownTimer(100000, 50) {
        override fun onTick(p0: Long) {
            val lotteryList = arrayListOf(number11, number12, number13, number14, number15, number16)
            lotteryList.forEach {
                it.setText("${((Math.random() * 45).toInt() + 1)}");
            }
        }

        override fun onFinish() {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lotteryWhirl.setOnClickListener {
            if (lotteryWhirl.isAnimating) {
                lotteryWhirl.cancelAnimation()
                countDownTimer.cancel()
            } else {
                lotteryWhirl.playAnimation()
                countDownTimer.start()
            }
        }

        lotteryWhirl.addAnimatorListener(object: Animator.AnimatorListener {
            override fun onAnimationStart(p0: Animator?) {
            }

            override fun onAnimationEnd(p0: Animator?) {
                countDownTimer.cancel()
            }

            override fun onAnimationCancel(p0: Animator?) {
            }

            override fun onAnimationRepeat(p0: Animator?) {
            }
        })
    }
}