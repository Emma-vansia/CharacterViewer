package com.xfinity.characterviewer.ui.list

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.*
import android.view.Menu
import android.view.MenuItem

import com.xfinity.characterviewer.R
import com.xfinity.characterviewer.adapters.CharacterAdapter
import com.xfinity.characterviewer.model.CharacterNames
import kotlinx.android.synthetic.main.recycler_view.*
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController



class MainActivity : AppCompatActivity(), IView {

    lateinit var recyclerView: RecyclerView
    private lateinit var iPresenter: IPresenter

    private var isTablet:Boolean = false
    private var toggle: Boolean = true
    override fun displayRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView)
        if (toggle) {
            recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        }
        else{
            recyclerView.layoutManager = GridLayoutManager(this,2)
        }


        val resId = R.anim.layout_animation_fall_down
        val animation = AnimationUtils.loadLayoutAnimation(this, resId)
        recyclerView.setLayoutAnimation(animation)
        recyclerView.setHasFixedSize(true)
    }

    override fun setAdapter(characterList: List<CharacterNames>) {
        isTablet = frameLayout != null
        recyclerView.adapter = CharacterAdapter(this, characterList,isTablet)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iPresenter = Presenter(this)
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
                toggle = !toggle
                iPresenter.changeLayout()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.bounce_animation,R.anim.bounce_animation)
    }
}
