package com.iro.mygoapp.ui.screens.unauthenticated.login

data class SignInState(
    val emailOrMobile: String = "",
    val password: String = "",
    val isLoginSuccessful: Boolean = false
)
