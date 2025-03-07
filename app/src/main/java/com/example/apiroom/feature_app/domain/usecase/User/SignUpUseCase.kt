package com.example.apiroom.feature_app.domain.usecase.User

import com.example.apiroom.feature_app.domain.repository.UserRepository

class SignUpUseCase(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(mail: String, pass: String){
        userRepository.signIn(mail, pass)
    }
}