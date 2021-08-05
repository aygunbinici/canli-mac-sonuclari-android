package com.example.selcuksport.modul.Data4

import com.google.gson.annotations.SerializedName

data class Detay(

    @SerializedName("success")
    val success:Boolean,

    @SerializedName("data")
    val data : DataData

)