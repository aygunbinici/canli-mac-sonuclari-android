package com.example.selcuksport.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.selcuksport.modul.Data1.Bitenmac
import com.example.selcuksport.modul.Data1.Datasecond
import com.example.selcuksport.modul.Data2.FirstData
import com.example.selcuksport.modul.Data2.SecondData
import com.example.selcuksport.modul.Data2.Ulkeler
import com.example.selcuksport.service.UlkelerApıService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class AnaSayfaViewModel(application: Application):BaseViewModel(application), CoroutineScope {

    private val ulkelerApıService=UlkelerApıService()
    val canlidata= MutableLiveData<ArrayList<FirstData>>()
    private val disposable = CompositeDisposable()

    fun getDataFromAPIulke(){
        launch {
            disposable.add(
                ulkelerApıService.getdataulke()
                    .subscribeOn(Schedulers.newThread()) //bu arka planda çalışacak
                    .observeOn(AndroidSchedulers.mainThread()) //ana threadde gösterilecek
                    .subscribeWith(object : DisposableSingleObserver<Ulkeler>() {

                        override fun onSuccess(t: Ulkeler) {
                            println("alexxx"+t.data.country)
                            showCountries(t.data.country)

                        }
                        override fun onError(e: Throwable) {
                            println("hata"+e.message)
                        }

                    })

            )
        }

    }
    private fun showCountries(haberList: ArrayList<FirstData>){
        canlidata.value= haberList
    }


}