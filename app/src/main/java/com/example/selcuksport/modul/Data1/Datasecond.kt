package com.example.selcuksport.modul.Data1

import com.google.gson.annotations.SerializedName

data class Datasecond (

    @SerializedName("location")
    val location:String,
    @SerializedName("competition_id")
    val competition_id:Int,
    @SerializedName("et_score")
    val et_score:String?,
    @SerializedName("ht_score")
    val ht_score:String,
    @SerializedName("date")
    val date:String,
    @SerializedName("has_lineups")
    val has_lineups:Boolean,
    @SerializedName("odds")
    val odds : Datathird,
    @SerializedName("fixture_id")
    val fixture_id:Int,
    @SerializedName("competition_name")
    val competition_name:String,
    @SerializedName("home_name")
    val home_name:String,
    @SerializedName("time")
    val time:String,
    @SerializedName("score")
    val score:String,
    @SerializedName("last_changed")
    val last_changed : String,
    @SerializedName("away_id")
    val away_id:Int,
    @SerializedName("status")
    val status:String,
    @SerializedName("id")
    val id:Int,
    @SerializedName("ft_score")
    val ft_score : String,
    @SerializedName("away_name")
    val away_name:String,
    @SerializedName("home_id")
    val home_id:Int,
    @SerializedName("league_id")
    val league_id : Int,

    @SerializedName("outcomes")
    val outcomes: Datasix,

    @SerializedName("added")
    val added:String,
    @SerializedName("events")
    val events:String,
    @SerializedName("scheduled")
    val scheduled : String,

    @SerializedName("h2h")
    val h2h : String

)