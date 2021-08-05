package com.example.selcuksport.modul.Data5

import com.example.selcuksport.modul.Data4.DataData
import com.google.gson.annotations.SerializedName

data class olay(
    @SerializedName("success")
    val success:Boolean,

    @SerializedName("data")
    val data : DataDataData

)