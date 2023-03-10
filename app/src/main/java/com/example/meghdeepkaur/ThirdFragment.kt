package com.example.meghdeepkaur

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meghdeepkaur.adapters.NameAdapter
import com.example.meghdeepkaur.clickInterfaces.RecyclerClickTnterfaces
import com.example.meghdeepkaur.databinding.FragmentThirdBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ThirdFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThirdFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var binding: FragmentThirdBinding?= null
    lateinit var fragNav: FragNav
    var adapter: NameAdapter?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragNav= activity as FragNav
        val arrayList= arrayListOf("ram","sham","Gita","sita","nita","kita")
        adapter= NameAdapter(fragNav, arrayList, object: RecyclerClickTnterfaces{
            override fun onClickListener(string: String) {
                //super.onClickListener(string)
                Toast.makeText(fragNav,string, Toast.LENGTH_LONG).show()
            }
        })
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentThirdBinding.inflate(layoutInflater)
        //binding?.rv?.layoutManager= LinearLayoutManager(fragNav, LinearLayoutManager.VERTICAL,false)
       // binding?.rv?.layoutManager= LinearLayoutManager(fragNav, LinearLayoutManager.HORIZONTAL,false)
        binding?.rv?.layoutManager= GridLayoutManager(fragNav, 3)
        binding?.burec?.setOnClickListener{
            adapter?.add("Bhawna")
        }

        binding?.rv?.adapter= adapter
        return binding?.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ThirdFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ThirdFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}