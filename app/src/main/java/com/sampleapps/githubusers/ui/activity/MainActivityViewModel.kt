package com.sampleapps.githubusers.ui.activity

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sampleapps.githubusers.api.GitHubUsersApiInstance
import com.sampleapps.githubusers.model.GitHubUser
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.HttpException
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList

class MainActivityViewModel:ViewModel() {
    private val TAG:String ="MainActivityViewModel"
    private var usersList: ArrayList<GitHubUser> = ArrayList()
    suspend fun getUsersList():ArrayList<GitHubUser>{

        viewModelScope.async {
            val response = try{
                GitHubUsersApiInstance.api.getUsersList()
            }catch (e :IOException)
            {
                Log.e(TAG,"IOException,internet connection issue")
                throw Exception("IOException,internet connection issue")
                return@async
            }catch (e :HttpException){
                Log.e(TAG,"HttpException , unexpected Response")
                throw Exception("HttpException , unexpected Response")
                return@async
            }

            if (response.isSuccessful && response.body()!=null){
                usersList= response.body()!!
            }else
            {
                throw Exception("Response not successful")
            }
        }.await()
        return usersList
    }

}