package com.xfinity.characterviewer.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.xfinity.characterviewer.R
import com.xfinity.characterviewer.model.Character


class CharacterAdapter(internal var context: Context, internal var charList: List<Character>) : RecyclerView.Adapter<CharacterAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val mVH: MyViewHolder

        val v = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false)

        mVH = MyViewHolder(v)
        return mVH
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val character = charList.get(position)
        holder.title.text = "Title: " + character.title()

    }

    override fun getItemCount(): Int {
        return charList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView

        init {
            title = itemView.findViewById(R.id.title)

        }
    }

}
