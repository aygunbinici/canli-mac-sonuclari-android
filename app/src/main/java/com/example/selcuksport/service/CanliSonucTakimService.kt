package com.example.selcuksport.service

import com.example.selcuksport.modul.Data1.Bitenmac
import com.example.selcuksport.modul.Data3.DataResult
import com.example.selcuksport.modul.Data3.takimSonuc
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class CanliSonucTakimService {

    private val BASE_URL="http://livescore-api.com"
    private val api= Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(canlisonuctakim::class.java)

    fun getdata(id:Int): Single<takimSonuc> {
        return api.getdata(id)
    }

}