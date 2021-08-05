package com.example.selcuksport.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.selcuksport.modul.Data2.FirstData
import com.example.selcuksport.modul.Data2.Ulkeler
import com.example.selcuksport.modul.Data3.Bir
import com.example.selcuksport.modul.Data3.takimSonuc
import com.example.selcuksport.service.CanliSonucTakimService
import com.example.selcuksport.service.UlkelerApıService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


class CanliSonucTakimViewModel(application: Application):BaseViewModel(application), CoroutineScope {

    private val canliSonucTakimService= CanliSonucTakimService()
    val canlidata= MutableLiveData<ArrayList<Bir>>()
    private val disposable = CompositeDisposable()

    fun getDataFromAPItakim(id:Int){
        launch {
            disposable.add(
                    canliSonucTakimService.getdata(id)
                            .subscribeOn(Schedulers.newThread()) //bu arka planda çalışacak
                            .observeOn(AndroidSchedulers.mainThread()) //ana threadde gösterilecek
                            .subscribeWith(object : DisposableSingleObserver<takimSonuc>() {

                                override fun onSuccess(t: takimSonuc) {
                                    println("alexxx"+t.data.match)
                                    showCountries(t.data.match)

                                }
                                override fun onError(e: Throwable) {
                                    println("hata"+e.message)
                                }

                            })

            )
        }

    }

    private fun showCountries(haberlist:ArrayList<Bir>){
        canlidata.value=haberlist
    }


}