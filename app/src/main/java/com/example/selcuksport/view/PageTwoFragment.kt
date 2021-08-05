package com.example.selcuksport.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.selcuksport.R
import com.example.selcuksport.adapter.RecyclerViewAdapter
import com.example.selcuksport.adapter.RecyclerViewOlay
import com.example.selcuksport.viewmodel.HomeViewModel
import com.example.selcuksport.viewmodel.PageOneViewModel
import com.example.selcuksport.viewmodel.PageTwoViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_page_one.*
import kotlinx.android.synthetic.main.fragment_page_two.*


class PageTwoFragment : Fragment() {

    private lateinit var viewModel: PageTwoViewModel
    private val recyclerViewOlay=RecyclerViewOlay(arrayListOf())
    private var value:Int=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        value=arguments?.getInt("Key")!!



        return inflater.inflate(R.layout.fragment_page_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PageTwoViewModel::class.java)
        viewModel.getDataFromAPI(value)

        recyclerviewolay.layoutManager= LinearLayoutManager(context)
        recyclerviewolay.adapter=recyclerViewOlay

        observeLiveData()


     }

    private fun observeLiveData(){
        viewModel.canlidata.observe(viewLifecycleOwner, Observer { haber->
            haber?.let {
                recyclerviewolay.visibility=View.VISIBLE
                recyclerViewOlay.updateCountyList(haber)

            }
        })

    }



}