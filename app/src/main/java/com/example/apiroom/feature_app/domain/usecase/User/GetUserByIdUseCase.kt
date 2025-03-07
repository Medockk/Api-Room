package com.example.apiroom.feature_app.domain.usecase.User

import com.example.apiroom.feature_app.data.model.UserDataImpl
import com.example.apiroom.feature_app.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetUserByIdUseCase(
    private val userRepository: UserRepository
) {
    operator fun invoke(userId: String) : Flow<UserDataImpl>{
        return userRepository.getUserById(userId)
    }
}