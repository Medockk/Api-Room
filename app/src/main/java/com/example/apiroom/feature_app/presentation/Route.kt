package com.example.apiroom.feature_app.presentation

sealed class Route(val route: String) {

    data object SplashScreen : Route("SplashScreen")
    data object SignInScreen : Route("SignInScreen")
    data object SignUpScreen : Route("SignUpScreen")
    data object HomeScreen : Route("HomeScreen")
}