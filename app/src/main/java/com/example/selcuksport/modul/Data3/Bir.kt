package com.example.selcuksport.modul.Data3

import com.example.selcuksport.modul.Data1.Datathird
import com.google.gson.annotations.SerializedName

data class Bir (


        @SerializedName("location")
        val location:String,
        @SerializedName("competition_id")
        val competition_id:Int,
        @SerializedName("et_score")
        val et_score:String?,
        @SerializedName("ht_score")
        val ht_score:String?,
        @SerializedName("league_name")
        val league_name:String?,
        @SerializedName("ft_score")
        val ft_score:String?,
        @SerializedName("odds")
        val odds : Datathird,
        @SerializedName("fixture_id")
        val fixture_id:Int,
        @SerializedName("competition_name")
        val competition_name:String?,
        @SerializedName("home_name")
        val home_name:String?,
        @SerializedName("time")
        val time:String?,
        @SerializedName("last_changed")
        val last_changed : String?,
        @SerializedName("away_id")
        val away_id:Int,
        @SerializedName("status")
        val status:String,
        @SerializedName("id")
        val id:Int,
        @SerializedName("has_lineups")
        val has_lineups : Boolean,
        @SerializedName("away_name")
        val away_name:String,
        @SerializedName("home_id")
        val home_id : Int,
        @SerializedName("league_id")
        val league_id:Int,
        @SerializedName("added")
        val added:String,
        @SerializedName("events")
        val events : String,
        @SerializedName("scheduled")
        val scheduled:String,
        @SerializedName("h2h")
        val h2h:String,
        @SerializedName("outcomes")
        val outcomes:Datathird,
        @SerializedName("info")
        val info:String







)