package com.example.meghdeepkaur

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.meghdeepkaur.adapters.MyListAdapter
import com.example.meghdeepkaur.databinding.FragmentListCustomBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListCustomFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListCustomFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var binding: FragmentListCustomBinding?= null
    lateinit var fragNav: FragNav
    var myListAdapter: MyListAdapter?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragNav= activity as FragNav
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentListCustomBinding.inflate(layoutInflater)

        var arrayOfString:ArrayList<String> = arrayListOf("Ekonkar","Satnam","Waheguru")
        arrayOfString.add("Wah")

        myListAdapter = MyListAdapter(arrayOfString)
        binding?.lview?.adapter = myListAdapter
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding=null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListCustomFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListCustomFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}