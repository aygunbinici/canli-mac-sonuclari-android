package com.example.selcuksport.service

import com.example.selcuksport.modul.Data1.Bitenmac
import io.reactivex.Single
import retrofit2.http.GET

interface macsonucuApı {


     @GET("/api-client/scores/history.json?key=EU3qgu9wFL9jh5iN&secret=1TeMt7XE8tbSVYqzSt09X9GCVPWcVe0X&competition_id=6&lang=TR&from=2021-05-05")
     fun getdata(): Single<Bitenmac>


}