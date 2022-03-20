package com.example.dipeshlamanetworkingassignment1.presenter

import android.content.Context
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.dipeshlamanetworkingassignment1.api.ServiceBuilder
import com.example.dipeshlamanetworkingassignment1.api.UniversityApi
import com.example.dipeshlamanetworkingassignment1.listener.SuccessOrFailureListener
import com.example.dipeshlamanetworkingassignment1.model.University
import com.example.dipeshlamanetworkingassignment1.repository.UniversityRepository
import com.example.dipeshlamanetworkingassignment1.view.MainView
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import java.security.AccessController.getContext

class MainPresenter () : MvpBasePresenter<MainView>() {

    fun getUniversityWithRx () {
        UniversityRepository().getDataUsingRx()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<ArrayList<University>> {
                override fun onSubscribe(d: Disposable) {
                }

                override fun onSuccess(university: ArrayList<University>) {
                    handleSuccess(university)
                }

                override fun onError(e: Throwable) {
                    handleFailure()
                }
            })
    }


    fun getUniversityListWithRetrofit(){
        UniversityRepository().getUniversityUsingRetrofitOnly(object : SuccessOrFailureListener{
            override fun onSuccess(university: ArrayList<University>) {
                handleSuccess(university)
            }

            override fun onFailure() {
                handleFailure()
            }
        })
    }

    private fun handleSuccess (uni: ArrayList<University>){
        ifViewAttached { view ->
            view.universityList(uni)
        }
    }

    private fun handleFailure (){
        ifViewAttached { view ->
            view.showError()
        }
    }
}