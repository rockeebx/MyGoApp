package com.iro.mygoapp.ui.screens.home.datas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.iro.mygoapp.data.model.SectionModel
import com.iro.mygoapp.ui.screens.home.maps.MapViewModel
import com.iro.mygoapp.utils.extensions.boldTextStyle
import com.iro.mygoapp.utils.extensions.height
import com.iro.mygoapp.utils.extensions.primaryTextStyle

@Composable
fun DataView(section: SectionModel){
    val viewModel = hiltViewModel<DataViewModel>()
    viewModel.setWebSocketUrl(section.content.source!!)
    val uiState = viewModel.messages.collectAsState()
    val messagesList = remember { mutableStateListOf<String>() }
    LaunchedEffect(uiState.value) {
        messagesList.add(uiState.value)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()) {
            10.height()
            Text("${section.content.title}", style = boldTextStyle(fontSize = 18.sp), textAlign = TextAlign.Center)
            10.height()
            messagesList.forEach { message ->
                Text(message, style = primaryTextStyle(fontSize = 14.sp))
            }
            10.height()
        }
    }
}

