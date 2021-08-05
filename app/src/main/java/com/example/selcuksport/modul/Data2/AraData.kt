package com.example.selcuksport.modul.Data2

import com.google.gson.annotations.SerializedName

data class AraData (
    @SerializedName("country")
    val country:ArrayList<FirstData>
)