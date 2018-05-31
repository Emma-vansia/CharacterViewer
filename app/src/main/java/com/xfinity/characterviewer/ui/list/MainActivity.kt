package com.xfinity.characterviewer.ui.list

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem

import com.xfinity.characterviewer.R
import com.xfinity.characterviewer.adapters.CharacterAdapter

class MainActivity : AppCompatActivity(), IView {

    lateinit var recyclerView: RecyclerView
    lateinit var iPresenter: IPresenter
    override fun displayRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.setHasFixedSize(true)
    }

    override fun setAdapter(characterAdapter: CharacterAdapter) {
        recyclerView.adapter = characterAdapter

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        iPresenter = Presenter(this, this)

        iPresenter.callApi()

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_toggle -> {

            }
        }
        return super.onOptionsItemSelected(item)
    }

}
