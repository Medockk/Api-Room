package com.example.apiroom.feature_app.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.apiroom.feature_app.data.local.dao.UserDao
import com.example.apiroom.feature_app.data.model.UserDataImpl

@Database(
    entities = [UserDataImpl::class],
    version = 1
)
abstract class UserDatabase : RoomDatabase() {

    abstract val userDao: UserDao

    companion object{
        fun createDatabase(context: Context) : UserDatabase{
            return Room.databaseBuilder(context, UserDatabase::class.java, "user.db").build()
        }
    }
}