package com.iro.mygoapp.ui.screens.home.datas

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iro.mygoapp.service.WebSocketListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import javax.inject.Inject


@HiltViewModel
data class DataViewModel @Inject constructor(
     private val okHttpClient: OkHttpClient
):ViewModel(){

    private var webSocketListener: WebSocketListener
    private var webSocket: WebSocket? = null
    private val _messages = MutableStateFlow("")
    val messages: StateFlow<String> get() = _messages

    init {
        webSocketListener = WebSocketListener(this)
        webSocket = okHttpClient.newWebSocket(createRequest(), webSocketListener)
    }


    fun addMessage(message: String) = viewModelScope.launch(Dispatchers.Main) {
            _messages.update { message }
    }

    private fun createRequest(): Request {
        return Request.Builder()
            .url("wss://s12027.nyc1.piesocket.com/v3/1?api_key=ttZsKwUV091wFGOtdSYhOGa4BfrXtUtf6Evp4L35&notify_self=1")
            .build()
    }
}
