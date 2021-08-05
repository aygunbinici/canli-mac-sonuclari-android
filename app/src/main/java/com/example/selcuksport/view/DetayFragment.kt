package com.example.selcuksport.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.selcuksport.R
import com.example.selcuksport.adapter.ViewPagerAdapter
import com.example.selcuksport.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_ana_sayfa.*
import kotlinx.android.synthetic.main.fragment_detay.*

class DetayFragment : Fragment() {


    private var home:String=""
    private var dep:String=""
    private var homescore:String=""
    private var depscore:String=""
    private var idid:Int=0


    private lateinit var buton1:Button
    private lateinit var buton2:Button
    private lateinit var mViewPager:ViewPager
    private lateinit var mPagerAdapter:ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


     }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root= inflater.inflate(R.layout.fragment_detay, container, false)


        mViewPager=root.findViewById(R.id.viewPager)
        buton1=root.findViewById(R.id.button1)
        buton2=root.findViewById(R.id.button2)
        println("DMRCK 2 : " + idid)
//        mPagerAdapter=ViewPagerAdapter(fragmentManager,idid)
//        mViewPager.adapter=mPagerAdapter
//        mViewPager.offscreenPageLimit=2


        buton1.setOnClickListener {
            mViewPager.currentItem=0
            println("sayfa1")
         }
        buton2.setOnClickListener {
             mViewPager.currentItem=1
            println("sayfa2")
         }

        mViewPager.currentItem=0

        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            home=DetayFragmentArgs.fromBundle(it).hometeam
            dep=DetayFragmentArgs.fromBundle(it).depteam
            homescore=DetayFragmentArgs.fromBundle(it).homescore
            depscore=DetayFragmentArgs.fromBundle(it).depscore
            idid=DetayFragmentArgs.fromBundle(it).id

        }

        println("A123"+idid)

        mPagerAdapter=ViewPagerAdapter(fragmentManager,idid)
        mViewPager.adapter=mPagerAdapter
//        mViewPager.offscreenPageLimit=2

        println("AAAAA"+idid)

        hometeam.text=home
        depteam.text=dep
        scoreone.text=homescore
        twoscore.text=depscore


    }



}