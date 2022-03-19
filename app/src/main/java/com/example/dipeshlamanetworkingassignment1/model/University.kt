package com.example.dipeshlamanetworkingassignment1.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class University {

    @SerializedName("country")
    @Expose
    val country: String? = null

    @SerializedName("name")
    @Expose
    val name: String? = null

    @SerializedName("domains")
    @Expose
    val domains: List<String>? = null

    @SerializedName("alpha_two_code")
    @Expose
    val alphaTwoCode: String? = null

    @SerializedName("state-province")
    @Expose
    val stateProvince: Any? = null

    @SerializedName("web_pages")
    @Expose
    val webPages: List<String>? = null
}