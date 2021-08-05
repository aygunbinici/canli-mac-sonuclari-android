package com.example.selcuksport.modul.Data3

import com.google.gson.annotations.SerializedName

data class takimSonuc(

    @SerializedName("success")
    val success:Boolean,
    @SerializedName("data")
    val data:DataResult

)