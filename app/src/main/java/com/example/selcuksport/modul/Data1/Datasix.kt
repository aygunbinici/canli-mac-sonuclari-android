package com.example.selcuksport.modul.Data1

import com.google.gson.annotations.SerializedName

data class Datasix(
    @SerializedName("half_time")
    val half_time:String,
    @SerializedName("full_time")
    val full_time:String,
    @SerializedName("extra_time")
    val extra_time : String?
)