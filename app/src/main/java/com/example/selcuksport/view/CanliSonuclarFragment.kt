package com.example.selcuksport.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.view.GravityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.selcuksport.R
import com.example.selcuksport.adapter.RecyclerViewTakim
import com.example.selcuksport.viewmodel.CanliSonucTakimViewModel
import kotlinx.android.synthetic.main.fragment_canli_sonuclar.*

class CanliSonuclarFragment : Fragment() {

    private lateinit var viewModel:CanliSonucTakimViewModel
    private val recyclerViewTakim=RecyclerViewTakim(arrayListOf())

     private var myid:Int=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_canli_sonuclar, container, false)

        val callback=object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                if (drawer3.isDrawerOpen(GravityCompat.START)){
                    drawer3.closeDrawer(GravityCompat.START)
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

        arguments?.let {
            myid=CanliSonuclarFragmentArgs.fromBundle(it).id
            println("fenerbahçe"+myid)
        }

        viewModel = ViewModelProviders.of(this).get(CanliSonucTakimViewModel::class.java)
        viewModel.getDataFromAPItakim(myid)

        recyclercst.layoutManager= LinearLayoutManager(context)
        recyclercst.adapter=recyclerViewTakim

        menubutton3.setOnClickListener {
            drawer3.openDrawer(GravityCompat.START)
        }

        AnaSayfa3.setOnClickListener {
            drawer3.closeDrawer(GravityCompat.START)
            val action=CanliSonuclarFragmentDirections.actionCanliSonuclarFragmentToHomeFragment()
            Navigation.findNavController(it).navigate(action)
        }

        anasayfaok3.setOnClickListener {
            drawer3.closeDrawer(GravityCompat.START)
            val action=CanliSonuclarFragmentDirections.actionCanliSonuclarFragmentToHomeFragment()
            Navigation.findNavController(it).navigate(action)
        }

        ulkeler3.setOnClickListener {
            drawer3.closeDrawer(GravityCompat.START)
            val action=CanliSonuclarFragmentDirections.actionCanliSonuclarFragmentToAnaSayfaFragment()
            Navigation.findNavController(it).navigate(action)
        }

        ulkelerok3.setOnClickListener {
            drawer3.closeDrawer(GravityCompat.START)
            val action=CanliSonuclarFragmentDirections.actionCanliSonuclarFragmentToAnaSayfaFragment()
            Navigation.findNavController(it).navigate(action)
        }

        canlisonuc3.setOnClickListener {
            drawer3.closeDrawer(GravityCompat.START)
        }

        canlısonucok3.setOnClickListener {
            drawer3.closeDrawer(GravityCompat.START)
        }

        observeLiveData()


    }

    private fun observeLiveData(){
        viewModel.canlidata.observe(viewLifecycleOwner, Observer { haber->
            haber?.let {
                recyclercst.visibility=View.VISIBLE
                recyclerViewTakim.updateCountyList(haber)
            }
        })

    }

}