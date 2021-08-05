package com.example.selcuksport.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.selcuksport.modul.Data1.Bitenmac
import com.example.selcuksport.modul.Data1.Datasecond
import com.example.selcuksport.modul.Data4.DataData
import com.example.selcuksport.modul.Data4.Detay
import com.example.selcuksport.service.BitenApıService
import com.example.selcuksport.service.DetayApıService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class PageOneViewModel(application: Application):BaseViewModel(application),CoroutineScope {

    private val detayApıService = DetayApıService()
    val canlidata= MutableLiveData<DataData>()
    private val disposable = CompositeDisposable()


    fun getDataFromAPI(macid:Int){
        launch {
            disposable.add(
                detayApıService.getdata(macid)
                    .subscribeOn(Schedulers.newThread()) //bu arka planda çalışacak
                    .observeOn(AndroidSchedulers.mainThread()) //ana threadde gösterilecek
                    .subscribeWith(object : DisposableSingleObserver<Detay>() {

                        override fun onSuccess(t: Detay) {
                            println("alex123"+t.data)
                            showCountries(t.data)

                        }
                        override fun onError(e: Throwable) {
                            println("alex321"+e.message)
                        }

                    })

            )
        }

    }

    private fun showCountries(haberList: DataData){
        canlidata.value= haberList
    }




}