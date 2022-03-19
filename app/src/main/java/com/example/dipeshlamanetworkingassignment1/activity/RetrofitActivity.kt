package com.example.dipeshlamanetworkingassignment1.activity

import androidx.appcompat.app.AppCompatActivity
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
import kotlinx.android.synthetic.main.activity_retrofit.*
import kotlinx.android.synthetic.main.activity_rxjava.*

class RetrofitActivity : MvpActivity<MainView,MainPresenter>(),MainView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)
        presenter.getUniversityListWithRetrofit()
    }

    override fun createPresenter(): MainPresenter {
        return MainPresenter()
    }

    override fun universityList(universities: ArrayList<University>) {
        runOnUiThread{
            populateRecyclerView(universities)
        }
    }

    private fun populateRecyclerView (list : ArrayList<University>){
        val layoutManager = LinearLayoutManager(this)
        rycUniversitiesRetrofit.layoutManager = layoutManager
        val adapter = UniversityAdapter(list)
        rycUniversitiesRetrofit.adapter = adapter
    }

    override fun showError() {
//        Snackbar.make(constraint_layout_retrofit, ErrorConstants.error, Snackbar.LENGTH_SHORT).show()
        Toast.makeText(this, ErrorConstants.error, Toast.LENGTH_LONG).show()
    }
}