package com.example.apiroom.feature_app.presentation.SignIn

sealed class SignInEvent {

    data class EmailEnter(val value: String) : SignInEvent()
    data class PasswordEnter(val value: String) : SignInEvent()

    data object SignIn : SignInEvent()
}