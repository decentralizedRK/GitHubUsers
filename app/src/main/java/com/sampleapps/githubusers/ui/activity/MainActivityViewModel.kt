package com.sampleapps.githubusers.ui.activity

import android.util.Log
import androidx.lifecycle.ViewModel

class MainActivityViewModel:ViewModel() {
    fun getUsers():ArrayList<String>{
       val list= ArrayList<String>()
        for(i in 1..100){
            list.add("User $i")
        }
        return list
    }
}