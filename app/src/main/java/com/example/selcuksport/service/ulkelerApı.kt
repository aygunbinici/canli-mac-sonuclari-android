package com.example.selcuksport.service

import com.example.selcuksport.modul.Data2.Ulkeler
import io.reactivex.Single
import retrofit2.http.GET

interface ulkelerApı {

    @GET("/api-client/countries/list.json?key=EU3qgu9wFL9jh5iN&secret=1TeMt7XE8tbSVYqzSt09X9GCVPWcVe0X")
    fun getulkeler(): Single<Ulkeler>

}