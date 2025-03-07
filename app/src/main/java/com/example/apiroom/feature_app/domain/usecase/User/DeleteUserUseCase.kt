package com.example.apiroom.feature_app.domain.usecase.User

import com.example.apiroom.feature_app.data.model.UserDataImpl
import com.example.apiroom.feature_app.domain.repository.UserRepository

class DeleteUserUseCase(
    private val userRepository: UserRepository
) {

    operator fun invoke(userDataImpl: UserDataImpl){
        userRepository.deleteUser(userDataImpl)
    }
}