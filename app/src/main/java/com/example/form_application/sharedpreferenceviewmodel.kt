package com.example.form_application

import android.content.Context
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class sharedpreferenceviewmodel(private var sharedrep:sharedpreference,private var context: Context):ViewModel() {

   // var firstname: MutableLiveData<String> = MutableLiveData()
   // var lastname: MutableLiveData<String> = MutableLiveData()
   // var baseObservable: Observables = Observables()

    fun saveData(fname: String, lname: String, phonenumber: String){
        sharedrep.getprefernce(context).edit().putString(keys.FNAME, fname).commit()
        sharedrep.getprefernce(context).edit().putString(keys.LNAME, lname).commit()
        sharedrep.getprefernce(context).edit().putString(keys.MOBNO, phonenumber).commit()
    }

    /*fun getFirstname(): MutableLiveData<String>{

        val fname = sharedrep.getprefernce(context).getString(keys.FNAME,"")
        firstname.value = fname
        return firstname
    }

    fun getLastname(): MutableLiveData<String>{

        val lname = sharedrep.getprefernce(context).getString(keys.LNAME,"")
        lastname.value = lname
        return lastname
    }

    fun getPhone(): String{
        val phonenumber = sharedrep.getprefernce(context).getString(keys.MOBNO,"")
        return phonenumber!!
    }*/

    fun getData() : String{
        val phonenumber = sharedrep.getprefernce(context).getString(keys.MOBNO,"")
        return phonenumber!!
    }



}
