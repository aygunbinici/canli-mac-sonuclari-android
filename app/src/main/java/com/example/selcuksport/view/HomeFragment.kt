package com.example.selcuksport.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.view.GravityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.selcuksport.R
import com.example.selcuksport.`interface`.Communicator
import com.example.selcuksport.adapter.RecyclerViewAdapter
import com.example.selcuksport.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private val recyclerViewAdapter=RecyclerViewAdapter(arrayListOf())



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        println("12345HomeFragment")
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val callback=object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                if (drawer.isDrawerOpen(GravityCompat.START)){
                    drawer.closeDrawer(GravityCompat.START)
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
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        viewModel.getDataFromAPI()

        recyclerview.layoutManager= LinearLayoutManager(context)
        recyclerview.adapter=recyclerViewAdapter

        menubutton.setOnClickListener {
            drawer.openDrawer(GravityCompat.START)
        }

        AnaSayfa.setOnClickListener {
            drawer.closeDrawer(GravityCompat.START)
        }
        anasayfaok.setOnClickListener {
            drawer.closeDrawer(GravityCompat.START)
        }



        ulkeler.setOnClickListener {
            drawer.closeDrawer(GravityCompat.START)
            val action=HomeFragmentDirections.actionHomeFragmentToAnaSayfaFragment()
            Navigation.findNavController(it).navigate(action)
        }

        ulkelerok.setOnClickListener {
             drawer.closeDrawer(GravityCompat.START)
            val action=HomeFragmentDirections.actionHomeFragmentToAnaSayfaFragment()
            Navigation.findNavController(it).navigate(action)
        }

        canlisonuc.setOnClickListener {
            drawer.closeDrawer(GravityCompat.START)
            val action=HomeFragmentDirections.actionHomeFragmentToCanliSonuclarFragment(48)
            Navigation.findNavController(it).navigate(action)
        }

        canlısonucok.setOnClickListener {
            drawer.closeDrawer(GravityCompat.START)
            val action=HomeFragmentDirections.actionHomeFragmentToCanliSonuclarFragment(48)
            Navigation.findNavController(it).navigate(action)
        }

         observeLiveData()

    }

    private fun observeLiveData(){
        viewModel.canlidata.observe(viewLifecycleOwner, Observer { haber->
            haber?.let {
                recyclerview.visibility=View.VISIBLE
                recyclerViewAdapter.updateCountyList(haber)

            }
        })

    }

}