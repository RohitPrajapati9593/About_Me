package com.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.databinding.ViewDataBinding
import com.aboutme.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //TODO: Instance of MyName data class.
    private val myName: MyName = MyName("Rohit Prajapati")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  TODO: Replace the below line setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //TODO: Set the value of the myName variable that is declared and used in the layout file.
        binding.myName = myName

        //   TODO: Replace the below line     findViewById<Button>(R.id.done_button).setOnClickListener {
        //   TODO: Replace the below line         addNickname(it)
        //   TODO: Replace the below line     }
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        // TODO: Replace the below line   val editText = findViewById<EditText>(R.id.nickname_edit)
        // TODO: Replace the below line     val nicknameTextView = findViewById<TextView>(R.id.nickname_text)
        binding.apply {
            //TODO: Replace the below line  nicknameTextView.text = editText.text
            //binding.nicknameText.text = binding.nicknameEdit.text
            myName?.nickname = nicknameEdit.text.toString()
            //TODO: Replace the below line editText.visibility = View.GONE

            binding.nicknameEdit.visibility = View.GONE
            //TODO:Replace the below line view.visibility = View.GONE

            binding.doneButton.visibility = View.GONE

            //TODO:   Replace the below line  nicknameTextView.visibility = View.VISIBLE
            binding.nicknameText.visibility = View.VISIBLE

            //TODO: Invalidate all binding expressions and request a new rebind to refresh UI
            invalidateAll()

        }
        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }


}