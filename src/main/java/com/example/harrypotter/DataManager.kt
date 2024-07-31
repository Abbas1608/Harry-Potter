package com.example.harrypotter

import com.example.harrypotter.modle.Characters
import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson


object DataManager {
    var data = emptyArray<Characters>()
    var currentCharacters: Characters? = null
    var currentPage = mutableStateOf(Pages.LISTING)

    var isDataLoaded = mutableStateOf(false)
    fun loadAssetsFromFile(context: Context) {
        val inputStream = context.assets.open("characters.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Characters>::class.java)
        isDataLoaded.value = true

    }
    fun switchPages(characters: Characters?){
        if(currentPage.value == Pages.LISTING){
            currentCharacters = characters
            currentPage.value = Pages.DETAIL
        }else{
            currentPage.value = Pages.LISTING
        }
    }
}





