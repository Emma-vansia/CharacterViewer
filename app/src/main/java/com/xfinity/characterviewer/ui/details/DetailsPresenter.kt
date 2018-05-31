package com.xfinity.characterviewer.ui.details

import android.content.Context

class DetailsPresenter(internal var context: Context, internal var iDetailsView: IDetailsView) : IDetailsPresenter {

    override fun loadView() {
        iDetailsView.display()
    }
}
