package com.example.apiroom.feature_app.presentation.Home

import android.util.Log
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = koinViewModel()
) {

    val state = viewModel.state.value

    if (state.exception.isNotEmpty()){
        val context = LocalContext.current
        Toast.makeText(context, state.exception, Toast.LENGTH_SHORT).show()
    }

    AnimatedVisibility(
        visible = state.userDataImpl != null
    ) {
        Log.e("dao", "homeScreenSet")

        val labelList = remember { listOf("fio","phone","gender","birthdayData","weight","height") }
        val valueList = remember { listOf(
            state.userDataImpl!!.fio,
            state.userDataImpl.phone,
            state.userDataImpl.gender,
            state.userDataImpl.birthdayData,
            state.userDataImpl.weight,
            state.userDataImpl.height,
        ) }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(30.dp)
        ) {
            repeat(valueList.size) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = labelList[it]
                    )
                    Spacer(Modifier.width(5.dp))
                    Text(
                        text = valueList[it]
                    )
                }
                Spacer(Modifier.height(8.dp))
            }
        }
    }
}