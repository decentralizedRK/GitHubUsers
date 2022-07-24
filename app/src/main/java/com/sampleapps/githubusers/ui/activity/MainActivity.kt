package com.sampleapps.githubusers.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sampleapps.githubusers.R
import com.sampleapps.githubusers.model.GitHubUser
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() , UserItemClicked {
    private lateinit var mAdapter: UsersListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel=ViewModelProvider(this).get(MainActivityViewModel::class.java)
        val userList = findViewById<RecyclerView>(R.id.recyclerview)
        val progressBar = findViewById<ProgressBar>(R.id.progressbar)
        val userItemClicked = this
        progressBar.isVisible=true
        userList.layoutManager=LinearLayoutManager(this)
        GlobalScope.launch(Dispatchers.Main) {
            mAdapter=UsersListAdapter(userItemClicked,viewModel.getNames())
            progressBar.isVisible=false;
            userList.adapter=mAdapter
        }
    }

    override fun onUserClicked(user: GitHubUser,pos:Int) {
        Toast.makeText(this,"User clicked $pos :"+user.login,Toast.LENGTH_SHORT).show()
    }
}