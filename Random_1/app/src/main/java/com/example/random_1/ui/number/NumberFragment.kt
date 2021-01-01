package com.example.random.ui.number

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.random_1.R

class NumberFragment : Fragment() {

    private lateinit var numberViewModel: NumberViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        numberViewModel =
                ViewModelProvider(this).get(NumberViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_number, container, false)
        root.findViewById<TextView>(R.id.textView3).text = numberViewModel.number.toString()

        root.findViewById<Button>(R.id.btn_create).setOnClickListener {
            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow((context as Activity).currentFocus?.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
            try {
                var min = root.findViewById<EditText>(R.id.editText1).text.toString().toInt()
                var max = root.findViewById<EditText>(R.id.editText2).text.toString().toInt()
                if(min>max) {
                    val builder = AlertDialog.Builder(context)
                    builder.setTitle("Error")
                    builder.setMessage("the integer on left side should be smaller than the right side")
                    builder.setPositiveButton("OK") { _, _ -> }
                    builder.create().show()
                }
                else {
                    numberViewModel.number = (min..max).random()
                    root.findViewById<TextView>(R.id.textView3).text = numberViewModel.number.toString()
                }
            } catch (e: NumberFormatException) {
                val builder = AlertDialog.Builder(context)
                builder.setTitle("Error")
                builder.setMessage("Please input integers")
                builder.setPositiveButton("OK") { _, _ -> }
                builder.create().show()
            }
        }
        return root
    }
}