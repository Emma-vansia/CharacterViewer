package com.xfinity.characterviewer.adapters

import android.app.FragmentManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import com.xfinity.characterviewer.R
import com.xfinity.characterviewer.model.CharacterNames
import com.xfinity.characterviewer.ui.details.DetailsActivity
import com.xfinity.characterviewer.ui.details.DetailsFragment
import com.xfinity.characterviewer.ui.list.MainActivity


class CharacterAdapter(private var context: MainActivity, internal var charList: List<CharacterNames>, private val isTablet:Boolean) : RecyclerView.Adapter<CharacterAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val mVH: MyViewHolder

        val v = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false)

        mVH = MyViewHolder(v)
        return mVH
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val character = charList.get(position)
        holder.title.text = context.getString(R.string.title) + character.heading()

        if(isTablet){
            holder.itemView.setOnClickListener({
                var detailsFragment=DetailsFragment()
                var bundle = Bundle()
                bundle.putString(context.getString(R.string.heading), character.heading())
                bundle.putString(context.getString(R.string.explaination), character.explaination())
                bundle.putString(context.getString(R.string.icon), character.Icon.URL)
                detailsFragment.setArguments(bundle)
                context.fragmentManager.beginTransaction().replace(R.id.frameLayout,detailsFragment).commit()
            })
        }else{
            holder.itemView.setOnClickListener({
                val intent = Intent(context, DetailsActivity::class.java)
                intent.putExtra(context.getString(R.string.heading), character.heading())
                intent.putExtra(context.getString(R.string.explaination), character.explaination())
                intent.putExtra(context.getString(R.string.icon), character.Icon.URL)
                context.startActivity(intent)
            })
        }
    }

    override fun getItemCount(): Int {
        return charList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var title: TextView

        init {
            title = itemView.findViewById(R.id.title)


        }
    }


}
