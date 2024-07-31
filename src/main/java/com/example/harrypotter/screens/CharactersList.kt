package com.example.harrypotter.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.harrypotter.modle.Characters


@Composable
fun CharactersList(data: Array<Characters>, onClick:(characters: Characters)->Unit){
    LazyColumn(content = {
        items(data)
        {
            CharctersListItem(characters = it,onClick)
        }
    })
}

