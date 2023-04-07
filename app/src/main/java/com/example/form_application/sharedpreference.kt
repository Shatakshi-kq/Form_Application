package com.example.form_application

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.view.Display.Mode
private const val FILE_NAME:String="_shapre"
private const val Mode=MODE_PRIVATE

object sharedpreference {

    fun getprefernce(context: Context):SharedPreferences{
        return context.getSharedPreferences(FILE_NAME, Mode)
    }
}
