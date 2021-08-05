package com.example.selcuksport.modul.Data2

import com.example.selcuksport.modul.Data1.Datathird
import com.google.gson.annotations.SerializedName

data class FirstData (

    @SerializedName("id")
    val id:String,

    @SerializedName("name")
    val name:String,

    @SerializedName("is_real")
    val is_real:String,

    @SerializedName("leagues")
    val leagues:String,

    @SerializedName("scores")
    val scores:String,

    @SerializedName("federation")
    val federation:SecondData,

    @SerializedName("national_team")
    val national_team: NationalData?

)