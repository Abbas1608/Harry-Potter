package com.example.harrypotter.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.harrypotter.modle.Characters
import com.example.harrypotter.R


@Composable
fun CharactesListScreen(data: Array<Characters>, onClick: (characters: Characters)->Unit) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(100.dp)
                    .align(CenterHorizontally)
            )
            CharactersList(data = data,onClick
            )
        }
    }
}