package com.iro.mygoapp.ui.screens.unauthenticated.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel



class SignInViewModel : ViewModel() {

    var loginState = mutableStateOf(SignInState())
        private set

    /**
     * Function called on any login event [SignInUiEvent]
     */
    fun onUiEvent(loginUiEvent: SignInUiEvent) {
        when (loginUiEvent) {
            // Submit Login
            is SignInUiEvent.Submit -> {
                    loginState.value = loginState.value.copy(isLoginSuccessful = true)
            }
        }
    }
}