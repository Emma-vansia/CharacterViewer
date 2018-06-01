package com.xfinity.characterviewer.ui.details

class DetailsPresenter(private var iDetailsView: IDetailsView) : IDetailsPresenter {

    override fun loadView() {
        iDetailsView.display()
    }
}
