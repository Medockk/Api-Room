package com.example.apiroom.feature_app.presentation.Splash

import android.os.CountDownTimer
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SplashViewModel : ViewModel() {

    private val _state = mutableStateOf(SplashState())
    val state: State<SplashState> = _state

    init {
        startTimer()
    }

    private fun startTimer() {
        val timer = object : CountDownTimer(1500, 1000){
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                _state.value = state.value.copy(isComplete = true)
            }

        }
        timer.start()
    }
}