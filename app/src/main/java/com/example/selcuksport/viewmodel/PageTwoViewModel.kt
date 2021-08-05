package com.example.selcuksport.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.selcuksport.modul.Data4.DataData
import com.example.selcuksport.modul.Data5.DataOlay
import com.example.selcuksport.modul.Data5.olay
import com.example.selcuksport.service.OlayApıService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class PageTwoViewModel(application: Application):BaseViewModel(application), CoroutineScope {

    private val olayApıService = OlayApıService()
    val canlidata= MutableLiveData<ArrayList<DataOlay>>()
    private val disposable = CompositeDisposable()

    fun getDataFromAPI(id:Int){
        launch {
            disposable.add(
                olayApıService.getdata(id)
                    .subscribeOn(Schedulers.newThread()) //bu arka planda çalışacak
                    .observeOn(AndroidSchedulers.mainThread()) //ana threadde gösterilecek
                    .subscribeWith(object : DisposableSingleObserver<olay>() {

                        override fun onSuccess(t: olay) {
                            println("alexaygun"+t.data.event)
                            showCountries(t.data.event)

                        }
                        override fun onError(e: Throwable) {
                            println("hataaygun"+e.message)
                        }

                    })

            )
        }

    }

    private fun showCountries(haberList: ArrayList<DataOlay>){
        canlidata.value= haberList
    }



}