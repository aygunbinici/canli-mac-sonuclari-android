package com.example.selcuksport.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.view.GravityCompat
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.selcuksport.R
import com.example.selcuksport.adapter.RecyclerViewAdapterUlkeler
import com.example.selcuksport.modul.Data2.FirstData
import com.example.selcuksport.viewmodel.AnaSayfaViewModel
import com.example.selcuksport.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_ana_sayfa.*
import kotlinx.android.synthetic.main.fragment_home.*


class AnaSayfaFragment : Fragment() {

    private lateinit var viewModel:AnaSayfaViewModel
    private val recyclerViewAdapterUlkeler=RecyclerViewAdapterUlkeler(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        println("12345Anasayfa")
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_ana_sayfa, container, false)

        val callback=object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                if (drawer2.isDrawerOpen(GravityCompat.START)){
                    drawer2.closeDrawer(GravityCompat.START)
                    println("basıldı")
                }

                else{
                    if (isEnabled){
                        isEnabled=false
                        requireActivity().onBackPressed()
                    }
                }

            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,callback)

        return root
     }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        edittext1.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
             }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
             }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.canlidata.observe(viewLifecycleOwner, Observer {haber->
                    haber?.let {
                        var mylist:ArrayList<FirstData> = ArrayList()
                        haber.forEach { countryData ->
                            val searchtext= s.toString()

                            if (countryData.name.toLowerCase().indexOf(searchtext.toLowerCase(),0) != -1){
                                mylist.add(countryData)
                            }
                        }

                        recyclerview_ulkeler.visibility=View.VISIBLE
                        recyclerViewAdapterUlkeler.updateCountyList(mylist)
                        
                    }
                })
            }

        }

        )


        viewModel = ViewModelProviders.of(this).get(AnaSayfaViewModel::class.java)
        viewModel.getDataFromAPIulke()


        recyclerview_ulkeler.layoutManager= LinearLayoutManager(context)
        recyclerview_ulkeler.adapter=recyclerViewAdapterUlkeler

        canlisonuc2.setOnClickListener {
            drawer2.closeDrawer(GravityCompat.START)
            val action=AnaSayfaFragmentDirections.actionAnaSayfaFragmentToCanliSonuclarFragment(48)
            Navigation.findNavController(it).navigate(action)
        }

        canlısonucok2.setOnClickListener {
            drawer2.closeDrawer(GravityCompat.START)
            val action=AnaSayfaFragmentDirections.actionAnaSayfaFragmentToCanliSonuclarFragment(48)
            Navigation.findNavController(it).navigate(action)
        }

        AnaSayfa2.setOnClickListener {
             drawer2.closeDrawer(GravityCompat.START)
            val action=AnaSayfaFragmentDirections.actionAnaSayfaFragmentToHomeFragment()
            Navigation.findNavController(it).navigate(action)
        }

        anasayfaok2.setOnClickListener {
             drawer2.closeDrawer(GravityCompat.START)
            val action=AnaSayfaFragmentDirections.actionAnaSayfaFragmentToHomeFragment()
            Navigation.findNavController(it).navigate(action)
        }


        ulkeler2.setOnClickListener {
            drawer2.closeDrawer(GravityCompat.START)
        }

        ulkelerok2.setOnClickListener {
            drawer2.closeDrawer(GravityCompat.START)
        }


        menubuton2.setOnClickListener {
            drawer2.openDrawer(GravityCompat.START)
        }

        observeLiveData()


    }

    private fun observeLiveData(){
        viewModel.canlidata.observe(viewLifecycleOwner, Observer { haber->
            haber?.let {
                recyclerview_ulkeler.visibility=View.VISIBLE
                recyclerViewAdapterUlkeler.updateCountyList(haber)

            }
        })

    }

}