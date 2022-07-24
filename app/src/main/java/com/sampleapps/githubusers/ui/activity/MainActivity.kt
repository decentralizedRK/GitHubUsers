package com.sampleapps.githubusers.ui.activity

import android.net.Uri
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
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
        progressBar.isVisible=true
        userList.layoutManager=LinearLayoutManager(this)
        GlobalScope.launch(Dispatchers.Main) {
            try {
                mAdapter=UsersListAdapter(this@MainActivity,viewModel.getUsersList())
                progressBar.isVisible=false;
                userList.adapter=mAdapter
            }catch (e:Exception){
                progressBar.isVisible=false;
                Toast.makeText(this@MainActivity,e.message,Toast.LENGTH_LONG).show()
            }
        }

    }

    override fun onUserClicked(user: GitHubUser) {
        val url = user.html_url
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(url))
    }
}