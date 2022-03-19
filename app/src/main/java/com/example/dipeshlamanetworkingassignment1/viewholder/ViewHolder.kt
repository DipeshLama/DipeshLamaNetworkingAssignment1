package com.example.dipeshlamanetworkingassignment1.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.dipeshlamanetworkingassignment1.model.University
import kotlinx.android.synthetic.main.custom_university_list.view.*

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val name = view.txvUniName
    val country = view.txvCountry
    val domain = view.txvDomain
    val alphaCode = view.txvAlphaCode
    val state = view.txvState
    val website = view.txvWebsite

    fun bind (university : University){
        country.text =university.country
        name.text = university.name
        domain.text = university.domains!![0]
        alphaCode.text = university.alphaTwoCode
        state.text = university.stateProvince.toString()
        website.text = university.webPages!![0]
    }
}