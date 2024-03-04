package com.iro.mygoapp.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iro.mygoapp.data.model.Response
import com.iro.mygoapp.repository.SectionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: SectionRepository
) : ViewModel(){

    private val _marketDataState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> get() = _marketDataState

    init {
        getSectionsData()
    }

    fun getSectionsData() = viewModelScope.launch(Dispatchers.IO) {
        repository.getHomeScreenContent().collect { response ->
            when (response) {
                is Response.Loading -> {
                    _marketDataState.update {
                        it.copy(isLoading = true, error = "", sections = null)
                    }
                }
                is Response.Error -> {
                    _marketDataState.update {
                        it.copy(error = response.message, isLoading = false, sections = null)
                    }
                }
                else->{
                    _marketDataState.update {
                        it.copy(sections = response.data,isLoading = false, error = "")
                    }
                }
            }
        }
    }

}