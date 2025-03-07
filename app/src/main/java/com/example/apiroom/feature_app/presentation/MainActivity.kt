package com.example.apiroom.feature_app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.apiroom.feature_app.presentation.Splash.SplashScreen
import com.example.apiroom.feature_app.presentation.ui.theme.ApiRoomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            ApiRoomTheme {
                NavHost(navController, startDestination =  Route.SplashScreen.route){
                    composable(Route.SplashScreen.route){
                        SplashScreen(navController)
                    }
                    composable(Route.SignInScreen.route){

                    }
                    composable(Route.SignUpScreen.route){

                    }
                    composable(Route.HomeScreen.route){

                    }
                }
            }
        }
    }
}