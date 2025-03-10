package com.example.apiroom.feature_app.presentation.SignUp

import android.util.Patterns
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiroom.feature_app.data.model.UserDataImpl
import com.example.apiroom.feature_app.domain.usecase.User.SignUpUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val signUpUseCase: SignUpUseCase
) : ViewModel() {

    private val _state = mutableStateOf(SignUpState())
    val state: State<SignUpState> = _state

    fun onEvent(event: SignUpEvent){
        when (event){
            is SignUpEvent.BirthdayDataEnter -> {_state.value = state.value.copy(birthdayData = event.value)}
            is SignUpEvent.EmailEnter -> {_state.value = state.value.copy(email = event.value)}
            is SignUpEvent.FioEnter -> {_state.value = state.value.copy(fio = event.value)}
            is SignUpEvent.GenderEnter -> {_state.value = state.value.copy(gender = event.value)}
            is SignUpEvent.HeightEnter -> {_state.value = state.value.copy(height = event.value)}
            is SignUpEvent.PasswordEnter -> {_state.value = state.value.copy(password = event.value)}
            is SignUpEvent.PhoneEnter -> {_state.value = state.value.copy(phone = event.value)}
            is SignUpEvent.WeightEnter -> {_state.value = state.value.copy(weight = event.value)}
            SignUpEvent.SignUp -> {
                if (
                    Patterns.EMAIL_ADDRESS.matcher(_state.value.email).matches() &&
                    _state.value.password.length >= 6 &&
                    _state.value.fio.isNotBlank() &&
                    _state.value.phone.isNotBlank() &&
                    _state.value.gender.isNotBlank() &&
                    _state.value.weight.isNotBlank() &&
                    _state.value.height.isNotBlank() &&
                    _state.value.birthdayData.isNotBlank()
                ){
                    viewModelScope.launch(Dispatchers.IO) {
                        try {
                            signUpUseCase(
                                _state.value.email,
                                _state.value.password,
                                UserDataImpl(
                                    fio = _state.value.fio,
                                    phone = _state.value.phone,
                                    gender = _state.value.gender,
                                    birthdayData = _state.value.birthdayData,
                                    weight = _state.value.weight,
                                    height = _state.value.height
                                )
                            )
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