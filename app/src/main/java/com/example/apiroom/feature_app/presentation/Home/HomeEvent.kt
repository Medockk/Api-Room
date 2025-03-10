package com.example.apiroom.feature_app.presentation.Home

import com.example.apiroom.feature_app.data.model.UserDataImpl

sealed class HomeEvent {

    data class ChangeUserData(val value: UserDataImpl) : HomeEvent()
    data object DeleteUser : HomeEvent()
}