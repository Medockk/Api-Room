package com.example.apiroom.feature_app.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.apiroom.feature_app.presentation.Home.HomeScreen
import com.example.apiroom.feature_app.presentation.SignIn.SignInScreen
import com.example.apiroom.feature_app.presentation.SignUp.SignUpScreen
import com.example.apiroom.feature_app.presentation.Splash.SplashScreen
import com.example.apiroom.feature_app.presentation.ui.theme.ApiRoomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            window.decorView.apply {
                this.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            }
            val navController = rememberNavController()
            ApiRoomTheme(
                false,
                false
            ) {
                NavHost(navController, startDestination =  Route.SplashScreen.route){
                    composable(Route.SplashScreen.route){
                        SplashScreen(navController)
                    }
                    composable(Route.SignInScreen.route){
                        SignInScreen(navController)
                    }
                    composable(Route.SignUpScreen.route){
                        SignUpScreen(navController)
                    }
                    composable(Route.HomeScreen.route){
                        HomeScreen(navController)
                    }
                }
            }
        }
    }
}