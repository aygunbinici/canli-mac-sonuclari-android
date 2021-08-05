package com.example.selcuksport.modul.Data2

import com.example.selcuksport.modul.Data1.Datafirst
import com.google.gson.annotations.SerializedName

data class Ulkeler(

    @SerializedName("success")
    val success:Boolean,

    @SerializedName("data")
    val data: AraData


)