package com.xfinity.characterviewer.ui.list

import com.xfinity.characterviewer.model.CharacterNames

interface IView {
    fun displayRecyclerView()
    fun setAdapter(characterList: List<CharacterNames>)
}
