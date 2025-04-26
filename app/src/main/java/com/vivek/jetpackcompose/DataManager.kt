package com.vivek.jetpackcompose

import android.content.Context
import com.google.gson.Gson
import com.vivek.jetpackcompose.models.Quote

class DataManager {

    var data = emptyArray<Quote>()
    fun loadAssetsFromFile(context: Context){
        val inputSystem = context.assets.open("quotes.json")
        val size = inputSystem.available()
        val buffer = ByteArray(size)
        inputSystem.read(buffer)
        inputSystem.close()
        val json = String(buffer,Charsets.UTF_8)
        val gson= Gson()
        data = gson.fromJson(json,Array<Quote>::class.java)
    }


}