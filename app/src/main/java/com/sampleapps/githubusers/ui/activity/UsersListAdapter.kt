package com.sampleapps.githubusers.ui.activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.sampleapps.githubusers.R
import com.sampleapps.githubusers.model.GitHubUser
import kotlinx.coroutines.CoroutineScope

/*
* Recycler view adapter class
*/
class UsersListAdapter(private val listener: UserItemClicked, private val usersList: ArrayList<GitHubUser>): RecyclerView.Adapter<UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.fragment_user,parent,false)
        val holder=UserViewHolder(view)
        view.setOnClickListener {
            listener.onUserClicked(usersList[holder.adapterPosition])
        }
        return holder
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = usersList[position]
        holder.nameText.text = currentUser.login
        Glide.with(holder.itemView).load(currentUser.avatar_url).into(holder.avatar)

    }

    override fun getItemCount(): Int {
        return usersList.size
    }
}

/*
* view holder class for each user
*/
class UserViewHolder(userView: View):RecyclerView.ViewHolder(userView){
    val nameText: TextView =userView.findViewById(R.id.userName)
    val avatar: ShapeableImageView =userView.findViewById(R.id.profile_pic)

}

/*
* onclickLister callback interface
*/
interface UserItemClicked{
    fun onUserClicked(user:GitHubUser)
}