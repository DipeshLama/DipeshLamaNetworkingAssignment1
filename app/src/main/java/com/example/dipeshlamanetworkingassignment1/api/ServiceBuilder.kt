package com.example.dipeshlamanetworkingassignment1.api

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceBuilder {
    private var universityApi: UniversityApi? = null

    private val gson = GsonBuilder().setLenient().create()

    private val retrofit : Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl("http://universities.hipolabs.com/")
        .client(getOkHttpClient())
        .build()

    private fun getOkHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
        return okHttpClient.build()
    }

    fun getApiService(): UniversityApi {
        if (universityApi == null) {
            universityApi = retrofit.create(UniversityApi::class.java)
        }
        return universityApi ?: retrofit.create(UniversityApi::class.java)
    }
}