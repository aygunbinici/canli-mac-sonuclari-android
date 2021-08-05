package com.example.selcuksport.modul.Data1

import com.google.gson.annotations.SerializedName

data class Datafirst (

    @SerializedName("prev_page")
    val prev_page:Boolean,

    @SerializedName("match")
    val match:ArrayList<Datasecond>

)