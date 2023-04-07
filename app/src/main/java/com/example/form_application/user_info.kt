package com.example.form_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.form_application.databinding.ActivityUserInfoBinding

class user_info : AppCompatActivity() {
    private lateinit var binding: ActivityUserInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityUserInfoBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_user_info)

        val intent = intent
        val name = intent.getStringExtra("Name")
        val lastname = intent.getStringExtra("lastname")
        val phone = intent.getStringExtra("Phone")
        val alphoe = intent.getStringExtra("Al.number")
        val email= intent.getStringExtra("Email")
        val gender=intent.getStringExtra("Gender")
        val Courses=intent.getStringExtra("Courses")

        binding.info.text= " Name:-  $name $lastname \n Phone No:-  $phone \n Alter.mo.no :- $alphoe  \n Email :- $email  \n Gender :-  $gender \n Courses :- $Courses"


    }
}