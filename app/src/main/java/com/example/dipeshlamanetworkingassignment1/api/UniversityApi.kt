package com.example.dipeshlamanetworkingassignment1.api

import com.example.dipeshlamanetworkingassignment1.model.University
import io.reactivex.Single
import retrofit2.http.GET

interface UniversityApi {
    @GET ("search?country=Nepal")
    fun getUniversityLists() : Single<ArrayList<University>>

    @GET ("search?country=Nepal")
     fun getUniListsWithRetrofit() : retrofit2.Call<ArrayList<University>>
}