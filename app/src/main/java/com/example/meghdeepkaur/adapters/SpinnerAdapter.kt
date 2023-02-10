package com.example.meghdeepkaur.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.meghdeepkaur.databinding.AdapterSpinnerBinding

class SpinnerAdapter(var arrayList: ArrayList<String>): BaseAdapter() {
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(p0: Int): Any {
        return arrayList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val layoutInflater= LayoutInflater.from(p2?.context)
        val binding= AdapterSpinnerBinding.inflate(layoutInflater,p2,false)

        binding.tvv.text= arrayList[p0]
        return binding.root
    }
}