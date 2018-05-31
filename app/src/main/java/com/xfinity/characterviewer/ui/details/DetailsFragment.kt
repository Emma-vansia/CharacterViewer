package com.xfinity.characterviewer.ui.details

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.squareup.picasso.Picasso
import com.xfinity.characterviewer.R

class DetailsFragment : Fragment(),IDetailsView {

    lateinit var iDetailsPresenter: IDetailsPresenter
    override fun display() {
        title.text = arguments.get(this.getString(R.string.heading))!!.toString()
        explaination.text = arguments.get(this.getString(R.string.explaination))!!.toString()

        if (arguments.get(this.getString(R.string.icon)).toString().isEmpty()) {
            icon.setImageResource(R.drawable.preview)
        } else {
            Picasso.with(activity).load(arguments.get(this.getString(R.string.icon)).toString()).into(icon)
        }
    }

    lateinit var title: TextView
    lateinit var explaination: TextView
    lateinit var icon: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle?): View {

        val view = inflater.inflate(R.layout.activity_details, container, false)

        title = view.findViewById(R.id.descTitle)
        explaination = view.findViewById(R.id.description)
        icon = view.findViewById(R.id.icon)

        iDetailsPresenter = DetailsPresenter(activity, this)
        iDetailsPresenter.loadView()

        return view
    }


}
