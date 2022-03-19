package com.example.dipeshlamanetworkingassignment1.repository

import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.example.dipeshlamanetworkingassignment1.api.ServiceBuilder
import com.example.dipeshlamanetworkingassignment1.listener.SuccessOrFailureListener
import com.example.dipeshlamanetworkingassignment1.model.University
import com.google.android.material.snackbar.Snackbar
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class UniversityRepository {

    fun getDataUsingRx() : Single<ArrayList<University>>{
        val university = ServiceBuilder.getApiService().getUniversityLists()
        return university
    }

    fun getUniversityUsingRetrofitOnly(listener : SuccessOrFailureListener){
        val getUniversities = ServiceBuilder.getApiService().getUniListsWithRetrofit()
        getUniversities.enqueue(object : Callback<ArrayList<University>> {
            override fun onResponse(
                call: Call<ArrayList<University>>,
                response: Response<ArrayList<University>>
            ) {
                listener.onSuccess(response.body()!!)
            }

            override fun onFailure(call: Call<ArrayList<University>>, t: Throwable) {

            }
        })
    }
}