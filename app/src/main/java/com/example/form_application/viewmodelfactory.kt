package com.example.form_application

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class viewmodelfactory(private val sharedPrefRepo: sharedpreference, private val context: Context):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(sharedpreferenceviewmodel::class.java)){
            return sharedpreferenceviewmodel(sharedPrefRepo, context) as T
        }
        throw IllegalArgumentException("Unknown class")
    }
}