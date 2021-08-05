package com.example.selcuksport.modul.Data2

import com.google.gson.annotations.SerializedName

data class NationalData (

    @SerializedName("id")
    val id:String,

    @SerializedName("name")
    val name:String,

    @SerializedName("stadium")
    val stadium:String,

    @SerializedName("location")
    val location:String


)