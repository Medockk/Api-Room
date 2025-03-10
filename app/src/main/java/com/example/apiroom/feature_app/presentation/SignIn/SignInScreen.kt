package com.example.apiroom.feature_app.presentation.SignIn

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.apiroom.feature_app.presentation.Route
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignInScreen(
    navController: NavController,
    viewModel: SignInViewModel = koinViewModel()
) {

    val state = viewModel.state.value
    if (state.exception.isNotEmpty()){
        val context = LocalContext.current
        Toast.makeText(context, state.exception, Toast.LENGTH_SHORT).show()
    }

    LaunchedEffect(!state.isComplete) {
        if (state.isComplete){
            navController.navigate(Route.HomeScreen.route){
                popUpTo(Route.SignInScreen.route){
                    inclusive = true
                }
            }
        }
    }

    val list = listOf(state.email, state.password)
    val actionList = listOf(
        {it: String -> viewModel.onEvent(SignInEvent.EmailEnter(it))},
        {it: String -> viewModel.onEvent(SignInEvent.PasswordEnter(it))},
    )
    val labelList = listOf("email", "password")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        repeat(list.size) {
            TextField(
                value = list[it],
                onValueChange = actionList[it],
                modifier = Modifier
                    .fillMaxWidth(),
                singleLine = true,
                enabled = !state.showIndicator,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Gray,
                    unfocusedContainerColor = Color.Gray,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                shape = RoundedCornerShape(20.dp),
                label = { Text(labelList[it]) }
            )
            Spacer(Modifier.height(30.dp))
        }
        Spacer(Modifier.weight(1f))
        Button(
            onClick = {
                viewModel.onEvent(SignInEvent.SignIn)
            },
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(Color.Blue)
        ) {
            Text(
                text = "sign in"
            )
        }
        Spacer(Modifier.height(10.dp))
        TextButton(
            onClick = {
                navController.navigate(Route.SignUpScreen.route){
                    popUpTo(Route.SignInScreen.route){
                        inclusive = true
                    }
                }
            }
        ) {
            Text(
                text = "no have an account?"
            )
        }
    }
}