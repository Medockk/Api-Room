package com.example.apiroom.feature_app.presentation.SignIn

import android.util.Patterns
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiroom.feature_app.domain.usecase.User.SignInUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignInViewModel(
    private val signInUseCase: SignInUseCase
) : ViewModel() {

    private val _state = mutableStateOf(SignInState())
    val state: State<SignInState> = _state

    fun onEvent(event: SignInEvent) {
        when (event) {
            is SignInEvent.EmailEnter -> {
                _state.value = state.value.copy(email = event.value)
            }

            is SignInEvent.PasswordEnter -> {
                _state.value = state.value.copy(password = event.value)
            }

            SignInEvent.SignIn -> {
                if (
                    Patterns.EMAIL_ADDRESS.matcher(_state.value.email).matches() &&
                    _state.value.password.length >= 6
                ) {
                    viewModelScope.launch(Dispatchers.IO) {
                        try {
                            signInUseCase(_state.value.email, _state.value.password)
                            _state.value = state.value.copy(isComplete = true)
                        } catch (e: Exception) {
                            _state.value = state.value.copy(exception = e.message.toString())
                        }
                    }
                }
            }
        }
    }
}