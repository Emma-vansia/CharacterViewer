package com.xfinity.characterviewer.ui.list

import com.xfinity.characterviewer.adapters.CharacterAdapter

interface IView {
    fun displayRecyclerView()
    fun setAdapter(characterAdapter: CharacterAdapter)
}
