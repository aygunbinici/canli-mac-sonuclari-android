package com.example.selcuksport.modul.Data5

import com.example.selcuksport.modul.Data1.Datathird
import com.google.gson.annotations.SerializedName

data class DataOlay(

    @SerializedName("id")
    val id:String,
    @SerializedName("match_id")
    val match_id:String,
    @SerializedName("player")
    val player:String,
    @SerializedName("time")
    val time:String,
    @SerializedName("event")
    val event:String,
    @SerializedName("sort")
    val sort:String,
    @SerializedName("home_away")
    val home_away : String,
    @SerializedName("info")
    val info:String?

)