package com.xfinity.characterviewer.ui.details

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.squareup.picasso.Picasso
import com.xfinity.characterviewer.R

class DetailsFragment : Fragment(),IDetailsView {

    private lateinit var iDetailsPresenter: IDetailsPresenter
    override fun display() {
        title.text = arguments.get(this.getString(R.string.heading))!!.toString()
        explanation.text = arguments.get(this.getString(R.string.explanation))!!.toString()

        if (arguments.get(this.getString(R.string.icon)).toString().isEmpty()) {
            icon.setImageResource(R.drawable.preview)
        } else {
            Picasso.with(activity).load(arguments.get(this.getString(R.string.icon)).toString()).into(icon)
        }
    }

    lateinit var title: TextView
    private lateinit var explanation: TextView
    lateinit var icon: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle?): View {

        val view = inflater.inflate(R.layout.activity_details, container, false)

        title = view.findViewById(R.id.descTitle)
        explanation = view.findViewById(R.id.description)
        icon = view.findViewById(R.id.icon)

        iDetailsPresenter = DetailsPresenter(this)
        iDetailsPresenter.loadView()

        return view
    }


}
