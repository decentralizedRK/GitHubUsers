package com.sampleapps.githubusers.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GitHubUsersApiInstance {

    val api:GitHubUsersApi by lazy{
        Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GitHubUsersApi::class.java)
    }
}