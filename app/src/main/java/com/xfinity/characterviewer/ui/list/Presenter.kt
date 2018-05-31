package com.xfinity.characterviewer.ui.list

import android.content.Context
import android.util.Log
import com.xfinity.characterviewer.adapters.CharacterAdapter
import com.xfinity.characterviewer.model.Characters
import com.xfinity.characterviewer.network.ApiService
import com.xfinity.characterviewer.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Presenter(internal var context: Context, internal var iView: IView) : IPresenter {

    init {
        iView.displayRecyclerView()
    }

    override fun callApi() {
        val apiService = RetrofitInstance.retrofitInstance.create(ApiService::class.java)
        val charCall = apiService.getCharacterList()
        var characterAdapter: CharacterAdapter? = null
        charCall.enqueue(object : Callback<Characters> {
            override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
                Log.i("response", " " + response.body()!!.RelatedTopics)
                characterAdapter = CharacterAdapter(context, response.body()!!.RelatedTopics)

                iView.setAdapter(characterAdapter!!)
            }

            override fun onFailure(call: Call<Characters>, t: Throwable) {


            }
        })

    }
}
