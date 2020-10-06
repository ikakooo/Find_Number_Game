package com.example.numbers_game

object Extensions {
    fun isTriedCharacter(char: String,triedChars: MutableList<String>): Boolean {
        triedChars.indices.forEach { if (triedChars[it] == char) return true }
        return false
    }
}