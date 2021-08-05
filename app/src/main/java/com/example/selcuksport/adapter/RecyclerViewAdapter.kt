package com.example.selcuksport.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.selcuksport.R
import com.example.selcuksport.`interface`.Communicator
import com.example.selcuksport.modul.Data1.Datasecond
import com.example.selcuksport.view.HomeFragmentDirections
import kotlinx.android.synthetic.main.item_row.view.*

class RecyclerViewAdapter(val bitenmac:ArrayList<Datasecond>):RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {




    class ViewHolder(var view: View):RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_row,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return bitenmac.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val sonuc=bitenmac[position].score
        val sonuc2=sonuc.split("-")
        val sonuc3=sonuc2[0]
        val sonuc4=sonuc2[1]
        println(sonuc3)
        println(sonuc4)

        val myhomename=bitenmac[position].home_name
        val mydepname=bitenmac[position].away_name
        val id:Int=bitenmac[position].id


        holder.view.setOnClickListener {
            val action=HomeFragmentDirections.actionHomeFragmentToDetayFragment(myhomename,mydepname,sonuc3,sonuc4,id)
            Navigation.findNavController(it).navigate(action)

        }
 
        //     "added": "2021-05-08 17:16:50"

        val tarih = bitenmac[position].added.split(" ")
        val yourArray : List<String> = tarih[0].split("-")

        println("aygunbınıcı"+yourArray)

        holder.view.hometeam.text=bitenmac[position].home_name
        holder.view.depteam.text=bitenmac[position].away_name
        holder.view.homescore.text=sonuc3.toString()
        holder.view.depscore.text=sonuc4.toString()
        holder.view.tarih.text=yourArray[1]+"/"+yourArray[2]
        //split veri bölme
    }

    fun updateCountyList(newCountryList:List<Datasecond>){
        bitenmac.clear()
        bitenmac.addAll(newCountryList)
        notifyDataSetChanged() //adaptörü yenilemek için kullandığımız metod
    }


}