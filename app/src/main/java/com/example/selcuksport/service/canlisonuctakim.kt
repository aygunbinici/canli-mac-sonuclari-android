package com.example.selcuksport.service

import com.example.selcuksport.modul.Data3.DataResult
import com.example.selcuksport.modul.Data3.takimSonuc
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface canlisonuctakim {


    @GET("/api-client/scores/live.json?key=EU3qgu9wFL9jh5iN&secret=1TeMt7XE8tbSVYqzSt09X9GCVPWcVe0X")

    fun getdata(@Query("country")id:Int):Single<takimSonuc>


}