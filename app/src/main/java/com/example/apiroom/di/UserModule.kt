package com.example.apiroom.di

import com.example.apiroom.feature_app.data.local.UserDatabase
import com.example.apiroom.feature_app.data.repository.UserRepositoryImpl
import com.example.apiroom.feature_app.domain.repository.UserRepository
import com.example.apiroom.feature_app.domain.usecase.User.DeleteUserUseCase
import com.example.apiroom.feature_app.domain.usecase.User.GetUserByIdUseCase
import com.example.apiroom.feature_app.domain.usecase.User.SignInUseCase
import com.example.apiroom.feature_app.domain.usecase.User.SignUpUseCase
import com.example.apiroom.feature_app.domain.usecase.User.UpsertUserDataUseCase
import org.koin.dsl.module

val moduleUser = module{

    single {
        UserDatabase.createDatabase(get())
    }
    single {
        get<UserDatabase>().userDao
    }
    single<UserRepository> {
        UserRepositoryImpl(get())
    }

    factory {
        DeleteUserUseCase(get())
    }
    factory {
        GetUserByIdUseCase(get())
    }
    factory {
        SignInUseCase(get())
    }
    factory {
        SignUpUseCase(get())
    }
    factory {
        UpsertUserDataUseCase(get())
    }
}