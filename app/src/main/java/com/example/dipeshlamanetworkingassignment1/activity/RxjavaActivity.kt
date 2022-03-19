package com.example.dipeshlamanetworkingassignment1.activity

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dipeshlamanetworkingassignment1.R
import com.example.dipeshlamanetworkingassignment1.Utils.ErrorConstants
import com.example.dipeshlamanetworkingassignment1.adapter.UniversityAdapter
import com.example.dipeshlamanetworkingassignment1.model.University
import com.example.dipeshlamanetworkingassignment1.presenter.MainPresenter
import com.example.dipeshlamanetworkingassignment1.view.MainView
import com.google.android.material.snackbar.Snackbar
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import kotlinx.android.synthetic.main.activity_rxjava.*

class RxjavaActivity : MvpActivity<MainView,MainPresenter>(),MainView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rxjava)
        presenter.getUniversityWithRx()
    }

    override fun createPresenter(): MainPresenter {
        return MainPresenter()
    }

    override fun universityList(universities: ArrayList<University>) {
        populateRecyclerView(universities)
    }

    private fun populateRecyclerView (list : ArrayList<University>){
        val layoutManager = LinearLayoutManager(this)
        rycUniversities.layoutManager = layoutManager
        val adapter = UniversityAdapter(list)
        rycUniversities.adapter = adapter
    }

    override fun showError() {
        Snackbar.make(constraint_layout_rx, ErrorConstants.error,Snackbar.LENGTH_LONG).show()
    }
}