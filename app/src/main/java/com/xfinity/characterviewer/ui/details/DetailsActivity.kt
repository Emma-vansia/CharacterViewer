package com.xfinity.characterviewer.ui.details

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.xfinity.characterviewer.R

class DetailsActivity : AppCompatActivity(),IDetailsView {


    private lateinit var iDetailsPresenter: IDetailsPresenter
    override fun display() {
        title.text = intent.getStringExtra(this.getString(R.string.heading))
        description.text = intent.getStringExtra(this.getString(R.string.explanation))
        if(intent.extras[this.getString(R.string.icon)].toString().isEmpty()){
            icon.setImageResource(R.drawable.preview)
        }
        else {
            Picasso.with(this).load(intent.extras[this.getString(R.string.icon)].toString()).into(icon)
        }

    }


    lateinit var  title:TextView
    lateinit var  description:TextView
    lateinit var icon: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        title = findViewById(R.id.descTitle)
        description = findViewById(R.id.description)
        icon = findViewById(R.id.icon)
        iDetailsPresenter = DetailsPresenter(this)
        iDetailsPresenter.loadView()

    }

    override fun onResume() {
        super.onResume()

        val actionBar: ActionBar? = this.supportActionBar
        actionBar?.title = intent.getStringExtra(this.getString(R.string.heading))
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.bounce_animation,R.anim.bounce_animation)
    }
}
