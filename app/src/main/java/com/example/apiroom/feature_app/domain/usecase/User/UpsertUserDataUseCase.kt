package com.example.apiroom.feature_app.domain.usecase.User

import com.example.apiroom.feature_app.data.model.UserDataImpl
import com.example.apiroom.feature_app.domain.repository.UserRepository

class UpsertUserDataUseCase(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(userDataImpl: UserDataImpl){
        userRepository.upsertUserData(userDataImpl)
    }
}