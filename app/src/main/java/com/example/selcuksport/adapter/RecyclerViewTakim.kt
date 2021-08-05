package com.example.selcuksport.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.selcuksport.R
import com.example.selcuksport.modul.Data1.Datasecond
import com.example.selcuksport.modul.Data3.Bir
import com.example.selcuksport.modul.Data3.DataResult
import kotlinx.android.synthetic.main.item_row.view.*
import kotlinx.android.synthetic.main.item_row.view.depscore
import kotlinx.android.synthetic.main.item_row.view.depteam
import kotlinx.android.synthetic.main.item_row.view.homescore
import kotlinx.android.synthetic.main.item_row.view.hometeam
import kotlinx.android.synthetic.main.item_row_takim.view.*

class RecyclerViewTakim(val takim:ArrayList<Bir>):RecyclerView.Adapter<RecyclerViewTakim.ViewHolder>() {

    class ViewHolder(var view:View):RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_row_takim,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return takim.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val tarih=takim[position].last_changed?.split(" ")
        val yourArray : List<String>? = tarih?.get(0)?.split("-")
        val tarih1= yourArray?.get(1)
        val tarih2= yourArray?.get(2)


        val skor=takim[position].ht_score
        val sonuc2= skor?.split("-")
        val sonuc3= sonuc2?.get(0).toString()
        val sonuc4= sonuc2?.get(1).toString()


        holder.view.hometeam.text=takim[position].home_name
        holder.view.depteam.text=takim[position].away_name
        holder.view.homescore.text=sonuc3
        holder.view.depscore.text=sonuc4
        holder.view.tarih5.text=tarih1 + "/" + tarih2
    }

    fun updateCountyList(newCountryList:List<Bir>){
        takim.clear()
        takim.addAll(newCountryList)
        notifyDataSetChanged() //adaptörü yenilemek için kullandığımız metod
    }
}