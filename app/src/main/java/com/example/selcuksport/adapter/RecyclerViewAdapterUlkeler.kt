package com.example.selcuksport.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.selcuksport.R
import com.example.selcuksport.modul.Data1.Datasecond
import com.example.selcuksport.modul.Data2.FirstData
import com.example.selcuksport.view.AnaSayfaFragmentDirections
import com.example.selcuksport.view.CanliSonuclarFragmentDirections
import kotlinx.android.synthetic.main.item_ulkeler.view.*

class RecyclerViewAdapterUlkeler(var ulke:ArrayList<FirstData>):RecyclerView.Adapter<RecyclerViewAdapterUlkeler.ViewHolder>() {


    class ViewHolder(var view: View):RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_ulkeler,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ulke.size
     }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.team.text=ulke[position].name
        val id=ulke[position].id.toString().toInt()
        println("aygunaygun"+id)

        holder.view.setOnClickListener {
            val action=AnaSayfaFragmentDirections.actionAnaSayfaFragmentToCanliSonuclarFragment(id)
            Navigation.findNavController(it).navigate(action)
           
        }

    }


    fun updateCountyList(newCountryList:List<FirstData>){
        ulke.clear()
        ulke.addAll(newCountryList)
        notifyDataSetChanged() //adaptörü yenilemek için kullandığımız metod
    }
}