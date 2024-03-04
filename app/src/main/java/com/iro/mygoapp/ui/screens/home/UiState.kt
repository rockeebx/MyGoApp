package com.iro.mygoapp.ui.screens.home

import com.iro.mygoapp.data.model.SectionModel


data class UiState(
    val isLoading : Boolean=false,
    var sections : List<SectionModel> ?= null,
    val error : String ?= "",
)