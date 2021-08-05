package com.example.selcuksport.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.selcuksport.R
import com.example.selcuksport.modul.Data1.Datasecond
import com.example.selcuksport.modul.Data4.DataData
import com.example.selcuksport.modul.Data5.DataOlay
import kotlinx.android.synthetic.main.item_row_olay.view.*

class RecyclerViewOlay(val olay:ArrayList<DataOlay>):RecyclerView.Adapter<RecyclerViewOlay.ViewHolder>() {

    class ViewHolder(var view:View):RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_row_olay,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return olay.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var kart=olay[position].event
        if (kart=="YELLOW_CARD"){
             kart="Sarı Kart"
            holder.view.durum.text=kart

        }
        else if(kart=="SUBSTITUTION"){
            kart="DEĞİŞİKLİK"
            holder.view.durum.text=""

        }
        else if(kart=="GOAL"){
            kart="GOL"
            holder.view.durum.text=""

        }


        holder.view.kartgol.text=kart
        holder.view.dakika.text=olay[position].time
        holder.view.futbolcu.text=olay[position].player
     }

    fun updateCountyList(newCountryList:ArrayList<DataOlay>){
        olay.clear()
        olay.addAll(newCountryList)
        notifyDataSetChanged() //adaptörü yenilemek için kullandığımız metod
    }

}