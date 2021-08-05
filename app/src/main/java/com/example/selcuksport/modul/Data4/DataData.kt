package com.example.selcuksport.modul.Data4

import com.google.gson.annotations.SerializedName

data class DataData (


    @SerializedName("shots_on_target")
    val shots_on_target:String,
    @SerializedName("dangerous_attacks")
    val dangerous_attacks:String,
    @SerializedName("possesion")
    val possesion:String,
    @SerializedName("yellow_cards")
    val yellow_cards:String,
    @SerializedName("red_cards")
    val red_cards:String,
    @SerializedName("corners")
    val corners:String,
    @SerializedName("offsides")
    val offsides:String






)