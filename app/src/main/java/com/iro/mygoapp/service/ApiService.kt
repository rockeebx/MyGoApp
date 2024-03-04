package com.iro.mygoapp.service

import co.infinum.retromock.meta.Mock
import co.infinum.retromock.meta.MockResponse
import com.iro.mygoapp.data.model.SectionModel
import retrofit2.http.GET

interface ApiService {

    @Mock
    @MockResponse(body = "response.json")
    @GET("/")
    suspend fun getHomeSections(): List<SectionModel>
}