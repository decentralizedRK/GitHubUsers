package com.sampleapps.githubusers.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sampleapps.githubusers.R

class MainActivity : AppCompatActivity() {
    private lateinit var mAdapter: UsersListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel=ViewModelProvider(this).get(MainActivityViewModel::class.java)
        val userList= findViewById<RecyclerView>(R.id.recyclerview)
        userList.layoutManager=LinearLayoutManager(this)
        mAdapter=UsersListAdapter(viewModel.getUsers())
        userList.adapter=mAdapter
    }
}