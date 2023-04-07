package com.example.form_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.form_application.databinding.ActivityFormActivityBinding

class Form : AppCompatActivity(), RadioGroup.OnCheckedChangeListener,
    CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private lateinit var binding: ActivityFormActivityBinding
    var gender:String?= null
    var arraylist:java.util.ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil. setContentView(this,R.layout.activity_form_activity)

        binding.radioGrp.setOnCheckedChangeListener(this)
        binding.cpp.setOnCheckedChangeListener(this)
        binding.java.setOnCheckedChangeListener(this)
        binding.php.setOnCheckedChangeListener(this)
        binding.python.setOnCheckedChangeListener(this)
        binding.android.setOnCheckedChangeListener(this)
        binding.flutter.setOnCheckedChangeListener(this)

        binding.btnSubmit.setOnClickListener(this)

    }

    override fun onCheckedChanged(checked: RadioGroup?, p1: Int) {
        when(checked?.checkedRadioButtonId){
            R.id.rb_male ->{
                gender= binding.rbMale.text.toString()
            }

            R.id.rb_female ->{
                gender= binding.rbFemale.text.toString()
            }

            R.id.transgender ->{
                gender= binding.transgender.text.toString()
            }
        }
    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
        when(p0?.id){
            R.id.cpp ->{
                if (binding.cpp.isChecked){
                    arraylist.add(binding.cpp.text.toString())
                }
                else{
                    arraylist.remove(binding.cpp.text.toString())
                }
            }

            R.id.java ->{
                if (binding.java.isChecked){
                    arraylist.add(binding.java.text.toString())
                }
                else{
                    arraylist.remove(binding.java.text.toString())
                }
            }

            R.id.python ->{
                if (binding.python.isChecked){
                    arraylist.add(binding.python.text.toString())
                }
                else{
                    arraylist.remove(binding.python.text.toString())
                }
            }

            R.id.php ->{
                if (binding.php.isChecked){
                    arraylist.add(binding.php.text.toString())
                }
                else{
                    arraylist.remove(binding.php.text.toString())
                }
            }

            R.id.android ->{
                if (binding.android.isChecked){
                    arraylist.add(binding.android.text.toString())
                }
                else{
                    arraylist.remove(binding.android.text.toString())
                }
            }

            R.id.flutter ->{
                if (binding.flutter.isChecked){
                    arraylist.add(binding.flutter.text.toString())
                }
                else{
                    arraylist.remove(binding.flutter.text.toString())
                }
            }
        }
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btn_submit ->{
                if (binding.fname.editText!!.text.isEmpty() && binding.lname.editText!!.text.isEmpty()
                    && binding.phone.editText!!.text.isEmpty() && binding.email.editText!!.text.isEmpty() && binding.dob.editText!!.text.isEmpty()){
                        Toast.makeText(this, "Please fill the required inofrmation", Toast.LENGTH_SHORT).show()
                    }
                else if (binding.fname.editText!!.text.isEmpty()){
                    Toast.makeText(this, "Please Enter Your First name", Toast.LENGTH_SHORT).show()
                    binding.fname.requestFocus()
                }
                else if (binding.lname.editText!!.text.isEmpty()){
                    Toast.makeText(this, "Please Enter Your Last name", Toast.LENGTH_SHORT).show()
                    binding.lname.requestFocus()
                }
                else if (binding.phone.editText!!.text.isEmpty()){
                    Toast.makeText(this, "Please Enter Phone Number", Toast.LENGTH_SHORT).show()
                    binding.phone.requestFocus()
                }
                else if (binding.email.editText!!.text.isEmpty()){
                    Toast.makeText(this, "Please Enter Your Email address", Toast.LENGTH_SHORT).show()
                    binding.email.requestFocus()
                }
                else if (binding.dob.editText!!.text.isEmpty()){
                    Toast.makeText(this, "Please Enter Your Date of Birth", Toast.LENGTH_SHORT).show()
                    binding.dob.requestFocus()
                }
                else if(binding.phone.editText?.text.toString().equals(binding.phone2.editText!!.text.toString())){
                    Toast.makeText(this,"plese fill diffrent number",Toast.LENGTH_LONG).show()
                }
                else{

                    val name = binding.fname.editText?.text.toString()
                    val lastname = binding.lname.editText?.text.toString()
                    val phone = binding.phone.editText?.text.toString()
                    val Alerphone = binding.phone2.editText?.text.toString()
                    val email = binding.email.editText!!.text.toString()
                    val intent = Intent(this, user_info::class.java)
                    val listname=arraylist.toString().replace("["," ").replace("]"," ")

                    intent.putExtra("Name", name)
                    intent.putExtra("lastname", lastname)
                    intent.putExtra("Phone", phone)
                    intent.putExtra("Al.number", Alerphone)
                    intent.putExtra("Email", email)
                    intent.putExtra("Gender", gender)

                    intent.putExtra("Courses", listname)
                    startActivity(intent)
                }

            }
        }
    }
}