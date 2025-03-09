package com.example.apiroom.feature_app.domain.usecase.User

import com.example.apiroom.feature_app.domain.repository.UserRepository

class DeleteUserUseCase(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke() {
        userRepository.deleteUser()
    }
}