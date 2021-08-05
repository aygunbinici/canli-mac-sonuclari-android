package com.example.selcuksport.service

import com.example.selcuksport.modul.Data4.Detay
import com.example.selcuksport.modul.Data5.olay
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Olay {


    @GET("api-client/scores/events.json?key=EU3qgu9wFL9jh5iN&secret=1TeMt7XE8tbSVYqzSt09X9GCVPWcVe0X&id=251790")
    fun getdata(@Query("id")macid:Int): Single<olay>

}