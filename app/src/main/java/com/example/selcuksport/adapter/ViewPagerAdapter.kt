package com.example.selcuksport.adapter

 import android.os.Bundle
 import androidx.fragment.app.Fragment
 import androidx.fragment.app.FragmentManager
 import androidx.fragment.app.FragmentStatePagerAdapter
 import com.example.selcuksport.view.PageOneFragment
 import com.example.selcuksport.view.PageTwoFragment

internal class ViewPagerAdapter (fm:FragmentManager?,idid:Int): FragmentStatePagerAdapter(fm!!){

    val aygun=idid
    override fun getItem(position: Int): Fragment {
        println("DMRCK :"+aygun)
        return when(position){

             0 -> {

                 val fragment=PageOneFragment()
                 val args:Bundle= Bundle()
                 args.putInt("Key",aygun)
                 fragment.arguments=args

                 com.example.selcuksport.view.PageOneFragment()

                 return fragment


            }

            1 -> {

                val fragment=PageTwoFragment()
                val args:Bundle= Bundle()
                args.putInt("Key",aygun)
                fragment.arguments=args

                com.example.selcuksport.view.PageTwoFragment()

                return fragment

            }

            else -> PageOneFragment()

        }


    }

    override fun getCount(): Int {
        return 2
    }

}