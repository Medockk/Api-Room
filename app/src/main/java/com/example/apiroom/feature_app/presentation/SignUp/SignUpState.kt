package com.example.apiroom.feature_app.presentation.SignUp

data class SignUpState(
    val exception: String = "",
    val showIndicator: Boolean = false,
    val isComplete: Boolean = false,

    val email: String = "",
    val password: String = "",
    val fio: String = "fio",
    val phone: String = "phone",
    val gender: String = "gender",
    val birthdayData: String = "birthdayData",
    val weight: String = "weight",
    val height: String = "height",
)
