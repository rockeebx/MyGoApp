package com.iro.mygoapp.di

import android.content.Context
import co.infinum.retromock.Retromock
import com.iro.mygoapp.service.ApiService
import com.iro.mygoapp.utils.Api.baseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient() = OkHttpClient
            .Builder()
            .build()


    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .build()


    @Singleton
    @Provides
    fun provideRetromock(retrofit: Retrofit,
                         @ApplicationContext context: Context
    ) : Retromock = Retromock.Builder()
        .retrofit(retrofit)
        .defaultBodyFactory(context.assets::open)
        .build()


    @Provides
    @Singleton
    fun provideApiService(retromock: Retromock): ApiService =
        retromock.create(ApiService::class.java)

}