package com.example.selcuksport.view

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import com.example.selcuksport.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.BaseTransientBottomBar
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.layout_bottom_sheet.*
import kotlinx.android.synthetic.main.layout_bottom_sheet.view.*

class LoginFragment : Fragment() {
    var isClose = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val abc:String="alexdesouza"
        val def=abc.split("de")
        println(def)
        println(def[0])


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         // Inflate the layout for this fragment
        val root= inflater.inflate(R.layout.fragment_login, container, false)

        val buton=root.findViewById<Button>(R.id.button)


        buton.setOnClickListener {

            val bottomSheetDialog = BottomSheetDialog(root.context,R.style.BottomSheetDialogTheme)

            val bottomSheetView = LayoutInflater.from(root.context).inflate(R.layout.layout_bottom_sheet,root.bottomsheet)

            bottomSheetDialog.setContentView(bottomSheetView)

            bottomSheetDialog.show()


            bottomSheetView.findViewById<View>(R.id.button2).setOnClickListener {
                Toast.makeText(root.context,"Share...",Toast.LENGTH_SHORT).show()
                isClose = true
                bottomSheetDialog.dismiss()
            }


             bottomSheetDialog.setOnDismissListener { dialog ->
                 if (isClose){
                     val action=LoginFragmentDirections.actionLoginFragmentToHomeFragment()
                     Navigation.findNavController(it).navigate(action)
                     isClose = false
                 }
            }



        }


        return root
    }



}