package com.sampleapps.githubusers.ui.activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sampleapps.githubusers.R

class UsersListAdapter(private val usersList: ArrayList<String>): RecyclerView.Adapter<UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.fragment_user,parent,false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = usersList[position]
        holder.nameText.text = currentUser
    }

    override fun getItemCount(): Int {
        return usersList.size
    }
}

class UserViewHolder(userView: View):RecyclerView.ViewHolder(userView){
    val nameText: TextView =userView.findViewById(R.id.userName)

}