package com.example.selcuksport.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.selcuksport.modul.Data1.Bitenmac
import com.example.selcuksport.modul.Data1.Datasecond
import com.example.selcuksport.service.BitenApıService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class HomeViewModel(application: Application):BaseViewModel(application),CoroutineScope {

    private val bitenApıService = BitenApıService()
    val canlidata= MutableLiveData<ArrayList<Datasecond>>()
    private val disposable = CompositeDisposable()


    fun getDataFromAPI(){
        launch {
            disposable.add(
                bitenApıService.getdata()
                    .subscribeOn(Schedulers.newThread()) //bu arka planda çalışacak
                    .observeOn(AndroidSchedulers.mainThread()) //ana threadde gösterilecek
                    .subscribeWith(object : DisposableSingleObserver<Bitenmac>() {

                        override fun onSuccess(t: Bitenmac) {
                            println("alex"+t.data.match)
                            showCountries(t.data.match)

                        }
                        override fun onError(e: Throwable) {
                            println(e.message)
                        }

                    })

            )
        }

    }

    private fun showCountries(haberList: ArrayList<Datasecond>){
        canlidata.value= haberList
    }



}