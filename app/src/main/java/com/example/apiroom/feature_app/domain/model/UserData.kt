package com.example.apiroom.feature_app.domain.model

interface UserData {
    val id: Int?
    val fio: String
    val userID: String
    val phone: String
    val gender: String
    val birthdayData: String
    val weight: String
    val height: String
    val notification: Boolean
    val image: String
    val purpose: String
}