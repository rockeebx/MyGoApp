package com.iro.mygoapp.repository

import android.util.Log
import com.iro.mygoapp.data.model.Response
import com.iro.mygoapp.data.model.SectionModel
import com.iro.mygoapp.service.ApiService
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class SectionRepository @Inject constructor(
    private val sectionApi: ApiService) {

    suspend fun getHomeScreenContent () : Flow<Response<List<SectionModel>>>{
        return flow {
            try {
                emit(Response.Loading())
                delay(3000)
                val data=sectionApi.getHomeSections()
                if (data.isNotEmpty()){
                    emit(Response.Success(data = data))
                }
            }catch (e:Exception){
                emit(Response.Error(message = "Error !"))
            }catch (e: TimeoutCancellationException) {
                emit(Response.Error(message = "Operation timed out !"))
            }
        }
    }

}