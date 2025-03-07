package com.example.apiroom.feature_app.domain.repository

import com.example.apiroom.feature_app.data.model.UserDataImpl
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun signUp(mail: String, pass: String, userDataImpl: UserDataImpl)
    suspend fun signIn(mail: String, pass: String)

    fun getUserById(userId: String) : Flow<UserDataImpl>
    fun upsertUserData(userDataImpl: UserDataImpl)
    fun deleteUser(userDataImpl: UserDataImpl)
}