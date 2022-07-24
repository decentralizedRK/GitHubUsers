package com.sampleapps.githubusers.api

import com.sampleapps.githubusers.model.GitHubUser
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubUsersApi {

    @GET("users")
    suspend fun getUsersList(): Response<ArrayList<GitHubUser>>

/*    @GET("users/{login}")
    suspend fun getUser(@Path("login") login: String):Response<Profile>*/
}