package com.example.meghdeepkaur

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.example.meghdeepkaur.databinding.FragmentRegistrationBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [RegistrationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegistrationFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var fragNav: FragNav

    var dataFromMegh: String=""

    var binding: FragmentRegistrationBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragNav= activity as FragNav
        dataFromMegh= arguments?.getString("dataFromMegh")?:""

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentRegistrationBinding.inflate(layoutInflater)
        binding?.reg?.setOnClickListener{
            onButtonClick()
        }
        binding?.tv1?.text=dataFromMegh
        return binding?.root

    }

    override fun onResume() {
        super.onResume()
        fragNav.updateAppBarTitle("Registration Fragment")
    }

    override fun onDestroy() {
        super.onDestroy()
        binding=null
    }

    fun onButtonClick() {
        Log.e("RegistrationForm", "Button clicked")
        Log.e("RegistrationForm", binding?.regName?.text.toString())
        Log.e("RegistrationForm",binding?.regMail?.text.toString())
        if(binding?.regName?.text.toString().isEmpty()) {
            Toast.makeText(activity,
                "Name cannot be Empty",
                Toast.LENGTH_LONG).show()
        }
        else if(binding?.regMail?.text.toString().isEmpty()) {
            Toast.makeText(activity,
                "Email cannot be null. Please enter your Email ID",
                Toast.LENGTH_LONG).show()
        }
        else if(binding?.regPh?.length()!! <10) {
            Toast.makeText(activity,
                "Phone number must be AtLeast 10 character long",
                Toast.LENGTH_LONG).show()
            Log.e("MainActivity", "your password is Hidden and secured")
        }

        else if(binding?.regPas?.length()!! <8) {
            Toast.makeText(activity,
                "Password must be AtLeast 8 Characters long",
                Toast.LENGTH_LONG).show()
        }
        else if(binding?.regCpas?.text.toString() != binding?.regPas?.text.toString()) {
            Toast.makeText(
                activity,
                "Password does not match",
                Toast.LENGTH_LONG
            ).show()
        }else{
            Toast.makeText(
                activity,
                "VALID CREDENTIALS.",
                Toast.LENGTH_LONG).show()
        }
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
         * @return A new instance of fragment RegistrationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegistrationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
