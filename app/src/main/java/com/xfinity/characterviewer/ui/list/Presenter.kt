package com.xfinity.characterviewer.ui.list

import android.content.Context
import android.util.Log
import com.xfinity.characterviewer.adapters.CharacterAdapter
import com.xfinity.characterviewer.model.Names
import com.xfinity.characterviewer.network.ApiService
import com.xfinity.characterviewer.network.RetrofitInstance
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Presenter(internal var context: Context, internal var iView: IView) : IPresenter {
    override fun changeLayout() {
        iView.displayRecyclerView()
    }

    init {
        iView.displayRecyclerView()
    }

    override fun callApi() {

         RetrofitInstance.retrofitInstance.create(ApiService::class.java).getCharacterList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(object : Observer<Names> {
                     override fun onComplete() {

                     }

                     override fun onSubscribe(d: Disposable) {

                     }

                     override fun onNext(t: Names) {

                         iView.setAdapter(t!!.RelatedTopics)
                     }

                     override fun onError(e: Throwable) {

                     }

                 })
    }

}
