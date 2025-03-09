package com.example.apiroom.feature_app.presentation.SignUp

sealed class SignUpEvent {

    data class EmailEnter(val value: String) : SignUpEvent()
    data class PasswordEnter(val value: String) : SignUpEvent()
    data class FioEnter(val value: String) : SignUpEvent()
    data class PhoneEnter(val value: String) : SignUpEvent()
    data class GenderEnter(val value: String) : SignUpEvent()
    data class BirthdayDataEnter(val value: String) : SignUpEvent()
    data class WeightEnter(val value: String) : SignUpEvent()
    data class HeightEnter(val value: String) : SignUpEvent()

    data object SignUp : SignUpEvent()
}