package com.example.selcuksport.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.selcuksport.R
import com.example.selcuksport.viewmodel.HomeViewModel
import com.example.selcuksport.viewmodel.PageOneViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_page_one.*

class PageOneFragment : Fragment() {


    private lateinit var viewModel: PageOneViewModel
    private var value:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        value=arguments?.getInt("Key")!!

        return inflater.inflate(R.layout.fragment_page_one, container, false)

     }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(PageOneViewModel::class.java)
        viewModel.getDataFromAPI(value)
        println("Domur"+value)

        observeLiveData()

    }

    private fun observeLiveData(){
        println("alexalex")
        viewModel.canlidata.observe(viewLifecycleOwner, Observer { haber->
            haber?.let {

                val sutdeger= haber.shots_on_target.split(":")
                val deger1=sutdeger[0].toString()
                val deger2=sutdeger[1].toString()
                sut1.text=deger1.toString()
                sut2.text=deger2.toString()

                val atakdeger= haber.dangerous_attacks.split(":")
                val atak1=atakdeger[0].toString()
                val atak2=atakdeger[1].toString()
                Atak1.text=atak1
                Atak2.text=atak2

                val pozisyondeger= haber.possesion.split(":")
                val poz1=pozisyondeger[0].toString()
                val poz2=pozisyondeger[1].toString()
                Poz1.text=poz1
                Poz2.text=poz2

                val sarikart= haber.yellow_cards.split(":")
                val sari1=sarikart[0].toString()
                val sari2=sarikart[1].toString()
                Sarı1.text=sari1
                Sarı2.text=sari2

                val kirmizikart= haber.red_cards.split(":")
                val kirmizi1=kirmizikart[0].toString()
                val kirmizi2=kirmizikart[1].toString()
                Kırmızı1.text=kirmizi1
                Kırmızı2.text=kirmizi2

                val korner= haber.corners.split(":")
                val korner1=korner[0].toString()
                val korner2=korner[1].toString()
                Korner1.text=korner1
                Korner2.text=korner2

                val ofsayt= haber.offsides.split(":")
                val ofsayt1=ofsayt[0].toString()
                val ofsayt2=ofsayt[1].toString()
                Ofsayt1.text=ofsayt1
                Ofsayt2.text=ofsayt2


            }
        })

    }

 }