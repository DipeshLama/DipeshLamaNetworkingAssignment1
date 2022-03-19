package com.example.dipeshlamanetworkingassignment1.view

import com.example.dipeshlamanetworkingassignment1.model.University
import com.hannesdorfmann.mosby3.mvp.MvpView

interface MainView : MvpView{
    fun universityList (universities : ArrayList<University>)

    fun showError ()
}