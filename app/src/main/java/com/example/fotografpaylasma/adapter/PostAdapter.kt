package com.example.fotografpaylasma.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fotografpaylasma.databinding.RecyclerRowBinding
import com.example.fotografpaylasma.model.Post
import com.squareup.picasso.Picasso

class PostAdapter(private val postlist : ArrayList<Post>) : RecyclerView.Adapter<PostAdapter.PostHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostHolder(binding)
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.binding.recyclerEmailText.text = postlist[position].email
        holder.binding.recyclerCommentText.text = postlist[position].comment
        Picasso.get().load(postlist[position].downloadUrl).into(holder.binding.recyclerImageView)
    }

    override fun getItemCount(): Int {
        return postlist.size
    }

    class PostHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){

    }
}