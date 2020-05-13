package com.example.countdowntimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var timer: TextView
    //    var START_MILLI_SECONDS = 60000L
    var time_in_milli_seconds = 60000L
    lateinit var countdown_timer: CountDownTimer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timer = findViewById(R.id.text_view_countdown)

        startTimer(time_in_milli_seconds)
    }

    private fun startTimer(startMilliSeconds: Long) {
        countdown_timer = object : CountDownTimer(startMilliSeconds, 1000) {
            override fun onFinish() {
                timer.text = "Click me..!"
                timer.setOnClickListener {
                    startTimer(30000)
                }
            }

            override fun onTick(millisUntilFinished: Long) {
                time_in_milli_seconds = millisUntilFinished
                updateTextUI()

            }
        }
        countdown_timer.start()
    }

    private fun updateTextUI() {
        val minute = (time_in_milli_seconds / 1000) / 60
        val seconds = (time_in_milli_seconds / 1000) % 60

        timer.text = "$minute:$seconds"
    }
}
