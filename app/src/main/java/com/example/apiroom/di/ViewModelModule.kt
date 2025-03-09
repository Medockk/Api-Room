package com.example.apiroom.di

import com.example.apiroom.feature_app.presentation.Home.HomeViewModel
import com.example.apiroom.feature_app.presentation.SignIn.SignInViewModel
import com.example.apiroom.feature_app.presentation.SignUp.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moduleViewModel = module {

    viewModel<SignInViewModel>{
        SignInViewModel(get())
    }
    viewModel<SignUpViewModel>{
        SignUpViewModel(get())
    }
    viewModel<HomeViewModel>{
        HomeViewModel(get(), get(), get())
    }
}