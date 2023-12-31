package com.example.timercountdown

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.timercountdown.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var timer: CountDownTimer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            bStart.setOnClickListener {
                startCountdownTimer(100000)
            }
        }
    }
    private fun startCountdownTimer(timeMillis: Long){
        timer?.cancel()
        timer = object  : CountDownTimer(timeMillis, 1){
            override fun onTick(timeM: Long){
                binding.tvTimer.text = timeM.toString()
            }

            override fun onFinish() {
                binding.tvTimer.text = "Finish"

            }
        }.start()
    }
}