package com.example.apiroom.feature_app.domain.usecase.User

import com.example.apiroom.feature_app.data.model.UserDataImpl
import com.example.apiroom.feature_app.domain.repository.UserRepository

class SignInUseCase(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(mail: String, pass: String, userDataImpl: UserDataImpl){
        userRepository.signUp(mail, pass, userDataImpl)
    }
}