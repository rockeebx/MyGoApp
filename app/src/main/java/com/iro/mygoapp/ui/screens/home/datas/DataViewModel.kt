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
    private val _socketUrl = MutableStateFlow("")
    val messages: StateFlow<String> get() = _messages

    init {
        webSocketListener = WebSocketListener(this)
        viewModelScope.launch {
            _socketUrl.collect { url ->
                if (url.isNotEmpty() && webSocket == null) {
                    webSocket = okHttpClient.newWebSocket(createRequest(url), webSocketListener)
                }
            }
        }
    }

    private fun createRequest(url: String): Request {
        return Request.Builder()
            .url(url)
            .build()
    }


    fun setWebSocketUrl(url: String) = viewModelScope.launch(Dispatchers.Main) {
        _socketUrl.update { url }
    }

    fun addMessage(message: String) = viewModelScope.launch(Dispatchers.Main) {
            _messages.update { message }
    }


}
