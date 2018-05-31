package com.xfinity.characterviewer.model

import java.io.Serializable


data class Names(
         val RelatedTopics: List<CharacterNames>
){
    fun getNames() = RelatedTopics
}

data class CharacterNames(
        val Result: String,
        val Text: String,
        val Icon: Icon
): Serializable {
    fun heading(): String = Text.substringBefore(" - ")
    fun explaination(): String = Text.substringAfter(" - ")
}
data class Icon(
        val URL: String,
        val Width: String,
        val Height: String
)
