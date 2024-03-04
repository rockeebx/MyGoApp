package com.iro.mygoapp.ui.screens.unauthenticated.login

sealed class SignInUiEvent {
    object Submit : SignInUiEvent()
}