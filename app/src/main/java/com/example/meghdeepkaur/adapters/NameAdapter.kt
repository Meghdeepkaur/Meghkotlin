package com.example.meghdeepkaur.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.meghdeepkaur.clickInterfaces.RecyclerClickTnterfaces
import com.example.meghdeepkaur.databinding.AdapterNameBinding

class NameAdapter (val context:Context,
val arrayList: ArrayList<String>,val recyclerClickInterfaces: RecyclerClickTnterfaces):RecyclerView.Adapter<NameAdapter.ViewHolder>(){
    inner class ViewHolder(val binding: AdapterNameBinding?):RecyclerView.ViewHolder(binding?.root?: View(context)){
        fun showData(position: Int){
            binding?.btToast?.setOnClickListener{recyclerClickInterfaces.onClickListener(arrayList[position])}
            binding?.textv?.text= arrayList[position]
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        var binding= AdapterNameBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.showData(position)

    }

    override fun getItemCount(): Int {
        return  arrayList.size
    }
    fun add(string: String){
        arrayList.add(string)
        notifyDataSetChanged()
    }
}