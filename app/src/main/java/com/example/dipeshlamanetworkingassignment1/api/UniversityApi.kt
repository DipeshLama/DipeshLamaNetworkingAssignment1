package com.example.dipeshlamanetworkingassignment1.api

import com.example.dipeshlamanetworkingassignment1.Utils.ApiConstants
import com.example.dipeshlamanetworkingassignment1.model.University
import io.reactivex.Single
import retrofit2.http.GET

interface UniversityApi {
    @GET (ApiConstants.getUniversityPath)
    fun getUniversityLists() : Single<ArrayList<University>>

    @GET (ApiConstants.getUniversityPath)
     fun getUniListsWithRetrofit() : retrofit2.Call<ArrayList<University>>
}