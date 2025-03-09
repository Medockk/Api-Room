package com.example.apiroom.feature_app.presentation.SignIn

data class SignInState(
    val exception: String = "",
    val showIndicator: Boolean = false,
    val isComplete: Boolean = false,

    val email: String = "",
    val password: String = "",
)
