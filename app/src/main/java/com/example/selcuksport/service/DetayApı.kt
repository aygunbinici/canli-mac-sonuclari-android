package com.example.selcuksport.service

import com.example.selcuksport.modul.Data1.Bitenmac
import com.example.selcuksport.modul.Data4.Detay
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface DetayApı {


    @GET("/api-client/matches/stats.json?match_id=251790&key=EU3qgu9wFL9jh5iN&secret=1TeMt7XE8tbSVYqzSt09X9GCVPWcVe0X")
    fun getdata(@Query("match_id")macid:Int): Single<Detay>


}