package com.example.meghdeepkaur

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.meghdeepkaur.databinding.FragmentFirstBinding
import android.Manifest
import android.app.Activity.RESULT_OK
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Bitmap

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    val TAG = this.javaClass.simpleName
    var binding: FragmentFirstBinding? = null
    var sharedPreferences: SharedPreferences? = null
    lateinit var fragNav: FragNav
    var dataFromMegh: String = ""

    var requestPermissionLauncherGal =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                selectImage.launch("image/*")
                Log.e("TAG", "Permission Granted")
            } else {
                Log.e("TAG", "Permission Denied")
                var alertDialog = AlertDialog.Builder(activity)
                alertDialog.apply {
                    setTitle("Permission Required")
                    setMessage("Permission required to run the App")
                    setCancelable(false)
                    setPositiveButton("Ok") { _, _ -> }
                    alertDialog.show()
                }
            }
        }



    var requestPermissionLauncherCam =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted:Boolean ->
            if (isGranted) {
                selectImageFromCamera.launch(null)
                Log.e("TAG", "Permission Granted")
            } else {
                Log.e("TAG", "Permission Denied")
                var alertDialog = AlertDialog.Builder(activity)
                alertDialog.apply {
                    setTitle("Permission Required")
                    setMessage("Permission required to run the App")
                    setCancelable(false)
                    setPositiveButton("Ok") { _, _ -> }
                    alertDialog.show()
                }

            }
        }



            val selectImage = registerForActivityResult(
                ActivityResultContracts.GetContent()
            ) { imageUri ->
                Log.e(TAG, imageUri.toString())
                binding?.iv1?.setImageURI(imageUri)
            }

            val selectImageFromCamera = registerForActivityResult(
                ActivityResultContracts.TakePicturePreview()
            ) { imageBitmap ->
                binding?.iv1?.setImageBitmap(imageBitmap)
            }




            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                fragNav= activity as FragNav
                dataFromMegh = arguments?.getString("dataFromMegh") ?: ""
                arguments?.let {
                    param1 = it.getString(ARG_PARAM1)
                    param2 = it.getString(ARG_PARAM2)
                }
                sharedPreferences = context?.getSharedPreferences(
                    context?.resources?.getString(R.string.app_name),
                    AppCompatActivity.MODE_PRIVATE
                )
            }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding= FragmentFirstBinding.inflate(layoutInflater)
        //binding?.tvShowData?.text=dataFromMegh
        binding?.tvShowData?.text = sharedPreferences?.getString("name","NO Data present")

        binding?.buGal?.setOnClickListener {
            requestPermissionLauncherGal.launch(
                Manifest.permission.READ_EXTERNAL_STORAGE)
        }
            binding?.buCam?.setOnClickListener {
                requestPermissionLauncherCam.launch(
                    Manifest.permission.CAMERA)
            }
                return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding= null
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}