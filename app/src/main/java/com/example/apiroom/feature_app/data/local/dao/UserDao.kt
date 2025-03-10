package com.example.apiroom.feature_app.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.apiroom.feature_app.data.model.UserDataImpl
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsertUserData(userDataImpl: UserDataImpl)

    @Query("SELECT * FROM UserDataImpl WHERE userID=:userId")
    fun getUserById(userId: String) : Flow<UserDataImpl>

    @Query("DELETE FROM UserDataImpl WHERE userID=:userId")
    fun deleteUser(userId: String)
}