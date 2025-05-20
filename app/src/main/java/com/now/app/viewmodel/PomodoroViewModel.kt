package com.now.app.viewmodel



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PomodoroViewModel : ViewModel() {
    private val _timeLeft = MutableStateFlow(1 * 60) // 25 minutes in seconds
    val timeLeft: StateFlow<Int> = _timeLeft

    private val _isRunning = MutableStateFlow(false)
    val isRunning: StateFlow<Boolean> = _isRunning

    private var timerJob = viewModelScope.launch { }

    fun toggleTimer() {
        if (_isRunning.value) {
            _isRunning.value = false
        } else {
            _isRunning.value = true
            startTimer()
        }
    }

    fun resetTimer() {
        _isRunning.value = false
        _timeLeft.value = 25 * 60
    }

    private fun startTimer() {
        timerJob = viewModelScope.launch {
            while (_isRunning.value && _timeLeft.value > 0) {
                delay(1000)
                _timeLeft.value -= 1
            }
            _isRunning.value = false
        }
    }
}
