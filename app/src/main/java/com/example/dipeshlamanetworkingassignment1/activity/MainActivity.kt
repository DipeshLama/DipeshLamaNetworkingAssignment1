package com.example.dipeshlamanetworkingassignment1.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.dipeshlamanetworkingassignment1.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListener()
    }

    private fun initListener (){
        btnUsingRx.setOnClickListener(this)
        btnUsingRetrofitOnly.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view){
            btnUsingRx -> {
                startActivity(Intent(this, RxjavaActivity::class.java))
            }
            btnUsingRetrofitOnly ->{
                startActivity(Intent(this, RetrofitActivity::class.java))
            }
        }
    }
}