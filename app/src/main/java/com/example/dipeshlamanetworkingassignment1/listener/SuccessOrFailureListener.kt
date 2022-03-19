package com.example.dipeshlamanetworkingassignment1.listener

import com.example.dipeshlamanetworkingassignment1.model.University
import java.lang.Exception

interface SuccessOrFailureListener {
    fun onSuccess (university : ArrayList<University>)
    fun onFailure ()
}