package com.iro.mygoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.iro.mygoapp.ui.screens.home.HomeScreen
import com.iro.mygoapp.ui.screens.splash.SplashScreen
import com.iro.mygoapp.ui.screens.splash.WalkThroughScreen
import com.iro.mygoapp.ui.screens.unauthenticated.SignInScreen
import com.iro.mygoapp.ui.screens.unauthenticated.SignUpScreen
import com.usecases.gozem_app.navigation.NavigationRoutes


@Composable
fun GoNavigation(navController: NavHostController){
    NavHost(navController = navController, startDestination = NavigationRoutes.SplashScreen.routes ){
        composable(route = NavigationRoutes.SplashScreen.routes){
            SplashScreen(navController = navController)
        }
        composable(route = NavigationRoutes.WalkThroughScreen.routes){
            WalkThroughScreen(navController = navController)
        }
        composable(route = NavigationRoutes.SignInScreen.routes){
            SignInScreen(navController = navController)
        }

        composable(route = NavigationRoutes.SignUpScreen.routes){
            SignUpScreen(navController = navController)
        }
        composable(route = NavigationRoutes.HomeScreen.routes){
            HomeScreen()
        }
    }
}