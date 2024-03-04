package com.iro.mygoapp.ui.screens.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.iro.mygoapp.data.model.SectionType
import com.iro.mygoapp.data.model.toSectionType
import com.iro.mygoapp.ui.screens.home.components.ShimmerEffectUi
import com.iro.mygoapp.ui.screens.home.components.TopBar
import com.iro.mygoapp.ui.screens.home.datas.DataView
import com.iro.mygoapp.ui.screens.home.maps.MapView
import com.iro.mygoapp.ui.screens.home.profil.ProfilView
import com.iro.mygoapp.ui.theme.MyGoAppTheme
import com.iro.mygoapp.utils.extensions.height

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun HomeScreen() {
    val viewModel = hiltViewModel<HomeViewModel>()
    val uiState = viewModel.uiState.collectAsState()

    Scaffold(
        topBar = { TopBar() },
        content = {

            if (uiState.value.isLoading){
                ShimmerEffectUi()
            }else{
                10.height()
            LazyColumn(modifier = Modifier
                .padding(it)
                .fillMaxSize(),
                content = {
                item {
                    uiState.value.sections?.forEach { section ->
                           when (section.type.toSectionType()){
                               SectionType.PROFILE->ProfilView(section)
                               SectionType.MAP->MapView(section)
                               SectionType.DATA->DataView(section)
                               else -> {}
                           }
                    }
                }
            }) }
        },
    )
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    MyGoAppTheme {
        HomeScreen()
    }
}
