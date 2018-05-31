package com.xfinity.characterviewer.model

import java.io.Serializable


data class Characters(
         val RelatedTopics: List<Character>
) /*{
    fun getCharacters() = RelatedTopics
}*/

data class Character(
        val Result: String,
        val Text: String,
        val Icon: Icon
): Serializable {
    fun title(): String = Text.substringBefore(" - ")
    fun description(): String = Text.substringAfter(" - ")
}
data class Icon(
        val URL: String,
        val Width: String,
        val Height: String
)
