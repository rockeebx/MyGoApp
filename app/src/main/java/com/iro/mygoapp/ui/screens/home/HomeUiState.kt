package com.iro.mygoapp.ui.screens.home

import com.iro.mygoapp.data.model.SectionModel


data class HomeUiState(
    val isLoading : Boolean=false,
    var sections : List<SectionModel> ?= null,
    val error : String ?= "",
)