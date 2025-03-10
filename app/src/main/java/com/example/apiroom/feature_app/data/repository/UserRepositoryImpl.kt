package com.example.apiroom.feature_app.data.repository

import android.util.Log
import com.example.apiroom.feature_app.data.local.dao.UserDao
import com.example.apiroom.feature_app.data.model.UserDataImpl
import com.example.apiroom.feature_app.data.network.Supabase.client
import com.example.apiroom.feature_app.domain.repository.UserRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.postgrest.postgrest

class UserRepositoryImpl(
    private val userDao: UserDao
) : UserRepository {


    override suspend fun signUp(
        mail: String,
        pass: String,
        userDataImpl: UserDataImpl
    ) {
        client.auth.signUpWith(Email) {
            email = mail
            password = pass
        }

        val userID = getUserID()
        upsertUserData(userDataImpl)
        client.postgrest["Users"].insert(
            mapOf(
                "userID" to userID,
                "fio" to userDataImpl.fio,
                "phone" to userDataImpl.phone,
                "gender" to userDataImpl.gender,
                "birthdayData" to userDataImpl.birthdayData,
                "weight" to userDataImpl.weight,
                "height" to userDataImpl.height,
                "purpose" to userDataImpl.purpose,
            )
        )
    }

    override suspend fun signIn(mail: String, pass: String) {
        client.auth.signInWith(Email) {
            email = mail
            password = pass
        }
    }

    override suspend fun getUserById(): UserDataImpl? {
        val userID = getUserID()
        val apiData = client.postgrest["Users"].select{filter { eq("userID", userID) }}.decodeSingle<UserDataImpl>()
        userDao.upsertUserData(apiData)
        val data = userDao.getUserById(userID)
        return data
    }

    override suspend fun upsertUserData(userDataImpl: UserDataImpl) {
        userDao.upsertUserData(userDataImpl)
        Log.e("daoUpsert", "$userDataImpl")
    }

    override suspend fun deleteUser() {
        val userID = getUserID()
        userDao.deleteUser(userID)
        Log.e("daoDelete", "delete")
    }

    private suspend fun getUserID(): String {
        client.auth.awaitInitialization()
        return client.auth.currentUserOrNull()?.id ?: ""
    }
}