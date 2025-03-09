package com.example.apiroom.feature_app.presentation.Home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiroom.feature_app.domain.usecase.User.DeleteUserUseCase
import com.example.apiroom.feature_app.domain.usecase.User.GetUserByIdUseCase
import com.example.apiroom.feature_app.domain.usecase.User.UpsertUserDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getUserByIdUseCase: GetUserByIdUseCase,
    private val upsertUserDataUseCase: UpsertUserDataUseCase,
    private val deleteUserUseCase: DeleteUserUseCase
) : ViewModel() {

    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                getUserByIdUseCase()
            } catch (e: Exception) {
                _state.value = state.value.copy(exception = e.message.toString())
            }
        }
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.ChangeUserData -> {
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        upsertUserDataUseCase(event.value)
                    } catch (e: Exception) {
                        _state.value = state.value.copy(exception = e.message.toString())
                    }
                }
            }

            HomeEvent.DeleteUser -> {
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        deleteUserUseCase()
                    } catch (e: Exception) {
                        _state.value = state.value.copy(exception = e.message.toString())
                    }
                }
            }
        }
    }
}