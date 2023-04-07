package com.example.form_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.form_application.R.layout.activity_login
import com.example.form_application.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    lateinit var factory: viewmodelfactory
    lateinit var viewmodel: sharedpreferenceviewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        factory = viewmodelfactory(sharedpreference, this)
        viewmodel = ViewModelProvider(this, factory)[sharedpreferenceviewmodel::class.java]


        binding.loginText.setOnClickListener {
            if (binding.mobileLogin.editText?.toString().equals(viewmodel.getData())) {
                startActivity(Intent(this, Form::class.java))
            } else {
                Toast.makeText(
                    this, "Please Enter Your Registered Phone Number", Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.skip.setOnClickListener {
            startActivity(Intent(this, Form::class.java))
        }
        binding.loginText.setOnClickListener {
            startActivity(Intent(this, Signup::class.java))
        }
        binding.btnLogin.setOnClickListener{
            startActivity(Intent(this, Form::class.java))
        }
    }
}

/*
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.skip ->{
                startActivity(Intent(this, Form::class.java))
            }

            R.id.login_text ->{
                startActivity(Intent(this, Signup::class.java))
            }
        }
    }*/
