package com.xfinity.characterviewer.ui.details

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.xfinity.characterviewer.R

class DetailsActivity : AppCompatActivity() {


    lateinit var  title:TextView
    lateinit var  description:TextView
    lateinit var icon: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        title = findViewById(R.id.descTitle)
        description = findViewById(R.id.description)
        icon = findViewById(R.id.icon)
        title.text = intent.extras[this.getString(R.string.title)].toString()
        description.text = intent.extras[this.getString(R.string.explaination)].toString()
        if(intent.extras[this.getString(R.string.icon)].toString().isEmpty()){
            Picasso.with(this).load(R.drawable.ic_launcher_background).into(icon)
        }
        else {
            Picasso.with(this).load(intent.extras["icon"].toString()).into(icon)
        }

    }
}
