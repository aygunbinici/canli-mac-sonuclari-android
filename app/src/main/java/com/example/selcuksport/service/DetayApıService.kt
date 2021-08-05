package com.example.selcuksport.service

import com.example.selcuksport.modul.Data3.takimSonuc
import com.example.selcuksport.modul.Data4.Detay
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class DetayApıService {

    private val BASE_URL = "http://livescore-api.com"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(DetayApı::class.java)

    fun getdata(macid:Int): Single<Detay> {
        return api.getdata(macid)

    }
}
