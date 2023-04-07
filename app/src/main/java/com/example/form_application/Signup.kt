package com.example.form_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.form_application.databinding.ActivitySignupBinding

class Signup : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivitySignupBinding
    lateinit var viewmodel: sharedpreferenceviewmodel
    lateinit var factory: viewmodelfactory

    //val data = arrayOf("Guest", "HR", "Admin", "Consultant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        factory = viewmodelfactory(sharedpreference, this)
        viewmodel = ViewModelProvider(this, factory)[sharedpreferenceviewmodel::class.java]

        binding.signupText.setOnClickListener(this)
        binding.btnSignup.setOnClickListener(this)

        binding.btnSignup.setOnClickListener {
            if (binding.mobileLayout.editText!!.text.toString().equals(viewmodel.getData())) {
                startActivity(Intent(this, Form::class.java))
            } else {
                Toast.makeText(this, "Invalid Number", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.signup_text -> {
                startActivity(Intent(this, Form::class.java))
            }

            R.id.btn_signup -> {
                if (binding.fnameEdit.text.toString().isEmpty() && binding.lnameEdit.text.toString()
                        .isEmpty() && binding.mobileEdit.text.toString().isEmpty()
                ) {
                    Toast.makeText(this, "Please fill value", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Successfully registered", Toast.LENGTH_SHORT).show()
                    viewmodel.saveData(binding.fnameEdit.text.toString(), binding.lnameEdit.text.toString(),
                        binding.mobileEdit.text.toString()
                    )

                    startActivity(Intent(this, Form::class.java))
                }
            }
        }
    }
}