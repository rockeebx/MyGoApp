package com.usecases.gozem_app.navigation

sealed class NavigationRoutes(val routes:String) {
    object SplashScreen : NavigationRoutes("splash_screen")
    object WalkThroughScreen : NavigationRoutes("walkThrough_screen")
    object SignInScreen : NavigationRoutes("SignInScreen")
    object SignUpScreen : NavigationRoutes("SignUpScreen")
    object HomeScreen : NavigationRoutes("HomeScreen")
}