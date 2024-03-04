package com.iro.mygoapp.ui.screens.home.datas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
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

    val uiState = viewModel.messages.collectAsState()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column {
            10.height()
            Text("${section.content.title}", style = primaryTextStyle(fontSize = 18.sp), textAlign = TextAlign.Center)
            10.height()
            Text(uiState.value, style = boldTextStyle(fontSize = 18.sp))

//        LazyColumn(content = {
//            items(
//                count = tickerFlow.size,
//                key = { tickerFlow[it].s },
//                itemContent = {
//                    CryptoPriceItem(tickerFlow[it])
//                })
//        })
        }
    }
}