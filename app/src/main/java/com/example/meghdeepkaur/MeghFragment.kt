package com.example.meghdeepkaur

import android.app.AlertDialog
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
import com.google.android.material.snackbar.Snackbar

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
    val TAG= this.javaClass.simpleName

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

       var snackbar= Snackbar.make(binding?.root!!,resources.getText(R.string.name_empty),
       Snackbar.LENGTH_LONG)
       snackbar.setAction(resources.getText(R.string.ok)){

       }
       snackbar.show()
        Log.e(TAG, "Button clicked")
        Log.e("loginForm", binding?.etNam?.text.toString())
        Log.e("loginForm", binding?.etId?.text.toString())
        if(binding?.etNam?.text?.isEmpty()==true) {
            var toast= Toast.makeText(activity,
                (R.string.name_empty),
                Toast.LENGTH_LONG)
            toast.show()
        }
        else if(binding?.etId?.text.toString().isEmpty()) {
            Toast.makeText(activity,
                "Email cannot be null. Please enter your Email ID",
                Toast.LENGTH_LONG).show()
            binding?.etNam?.error=resources.getText(R.string.name_empty)
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
       var alertDialog= AlertDialog.Builder(activity)
       alertDialog.apply {
           setTitle(resources.getText(R.string.congrats))
           setMessage(resources.getText(R.string.details_filled))
           setPositiveButton(resources.getText(R.string.positive)){_,_->
           }
           setNegativeButton(resources.getText(R.string.negative)){_,_->
           }
           setNeutralButton(resources.getText(R.string.neutral)){_,_->
           }
           setCancelable(false)
       }
       alertDialog.show()
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