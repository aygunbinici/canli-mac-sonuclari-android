package com.example.selcuksport.modul.Data1

import com.example.selcuksport.modul.Data1.Datafifth
import com.example.selcuksport.modul.Data1.Datafourth
import com.google.gson.annotations.SerializedName

data class Datathird (

    @SerializedName("pre")
    val pre: Datafourth,
    @SerializedName("live")
    val live: Datafifth

)