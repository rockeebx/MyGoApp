package com.iro.mygoapp.ui.screens.splash

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.iro.mygoapp.R
import com.usecases.gozem_app.navigation.NavigationRoutes
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController){


    SplashScreenContent()
    LaunchedEffect(Unit){
        delay(1000)
        navController.navigate(NavigationRoutes.WalkThroughScreen.routes)

    }
}


@Composable
fun SplashScreenContent(){
        Scaffold {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                Image(
                    painter = painterResource(id= R.drawable.ic_logo),
                    contentDescription = "",
                    modifier = Modifier.size(200.dp)
                )
            }
        }
}