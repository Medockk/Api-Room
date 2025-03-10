package com.example.apiroom.feature_app.presentation.Home

import com.example.apiroom.feature_app.domain.model.UserData

data class HomeState(
    val exception: String = "",
    val showIndicator: Boolean = false,

    val userDataImpl: UserData? = null,
)
