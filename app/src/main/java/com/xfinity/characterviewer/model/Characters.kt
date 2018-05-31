package com.xfinity.characterviewer.model


data class Characters(
        private val RelatedTopics: List<Character>
) {
    fun getCharacters() = RelatedTopics
}

data class Character(
        val Result: String,
        val Text: String,
        val Icon: Icon,
        var isFavorite: Boolean = false
)

data class Icon(
        val URL: String,
        val Width: String,
        val Height: String
)
