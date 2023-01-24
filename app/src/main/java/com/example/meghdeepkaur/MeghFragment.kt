package com.example.meghdeepkaur

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import com.example.meghdeepkaur.databinding.FragmentMeghBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MeghFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MeghFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var fragNav: FragNav
    var binding: FragmentMeghBinding?=null


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
        binding = FragmentMeghBinding.inflate(layoutInflater)

        binding?.btnLog?.setOnClickListener{
        onButtonClick()
         }

        binding?.btnReg?.setOnClickListener {
            val bundle= bundleOf("dataFromMegh" to binding?.etNam?.text.toString())
          //  val bundle= bundleOf("dataFromMegh" to "hello from Megh's Fragment)

            fragNav.navController.navigate(R.id.registrationFragment,bundle)
        }
        return binding?.root
    }
   fun onButtonClick() {
        Log.e("loginForm", "Button clicked")
        Log.e("loginForm", binding?.etNam?.text.toString())
        Log.e("loginForm", binding?.etId?.text.toString())
        if(binding?.etNam?.text.toString().isEmpty()) {
            Toast.makeText(activity,
                "Name cannot be Empty",
                Toast.LENGTH_LONG).show()
        }
        else if(binding?.etId?.text.toString().isEmpty()) {
            Toast.makeText(activity,
                "Email cannot be null. Please enter your Email ID",
                Toast.LENGTH_LONG).show()

        }
       else if(binding?.etPas?.length()==8) {
            Toast.makeText(activity,
                "Password must be AtLeast 8 Characters long",
                Toast.LENGTH_LONG).show()
            Log.e("MeghFragment", "your password is Hidden and secured")
        }
       else{
            Toast.makeText(activity,
                "Valid Data",
                Toast.LENGTH_LONG).show()
        }
    }

    override fun onResume() {
        super.onResume()
        fragNav.updateAppBarTitle("MeghFragment")
    }
    override fun onDestroy() {
        super.onDestroy()
        binding=null
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MeghFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MeghFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}