package com.example.userformmui

import android.app.ActionBar
import android.app.Dialog
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.userformmui.Adapters.ListViewAdapter
import com.example.userformmui.Factory.Sqlite_Factory
import com.example.userformmui.Model.SqlViewModel
import com.example.userformmui.Model.Student_Info
import com.example.userformmui.databinding.ActivityMainBinding
import com.example.userformmui.databinding.ActivityStudentInfoBinding
import com.example.userformmui.repository.Sqlite_DB_Repo

class Student_info_Activity : AppCompatActivity(), AdapterView.OnItemClickListener {

    private lateinit var ViewModel : SqlViewModel
    lateinit var Factory : Sqlite_Factory
    private lateinit var binding:ActivityStudentInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_student_info)

        Factory = Sqlite_Factory(Sqlite_DB_Repo(this))
        ViewModel = ViewModelProvider(this, Factory)[SqlViewModel::class.java]
        val ListofStudent = ViewModel.getAllData()

        val myAdapter  = ListViewAdapter(ListofStudent)
        binding.listViewUserInfo.adapter = myAdapter
        // binding.listViewUserInfo.setOnItemClickListener(this)
    }

    override fun onItemClick(adapter: AdapterView<*>?, view: View?, position: Int, row: Long) {
        val data = adapter?.getItemAtPosition(position).toString()
        Toast.makeText(this, "clicked $data", Toast.LENGTH_SHORT).show()
    }
}