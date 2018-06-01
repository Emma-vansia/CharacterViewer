package com.xfinity.characterviewer.ui.list

import com.xfinity.characterviewer.model.Names
import com.xfinity.characterviewer.network.ApiService
import com.xfinity.characterviewer.network.RetrofitInstance
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class Presenter(internal var iView: IView) : IPresenter {
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
                        // set the adapter after getting the response
                         iView.setAdapter(t.RelatedTopics)
                     }

                     override fun onError(e: Throwable) {

                     }

                 })
    }

}
