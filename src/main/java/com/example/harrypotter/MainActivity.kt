package com.example.harrypotter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.harrypotter.screens.CharactersDetail
import com.example.harrypotter.screens.CharactesListScreen
import com.example.harrypotter.ui.theme.HarryPotterTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {

            DataManager.loadAssetsFromFile(applicationContext)
        }
        setContent {
            HarryPotterTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App(){

    if(DataManager.isDataLoaded.value){
        if(DataManager.currentPage.value == Pages.LISTING){
            CharactesListScreen(data = DataManager.data) {
               DataManager.switchPages(it)
            }
        }
        else{

            DataManager.currentCharacters?.let { CharactersDetail(characters = it) }
        }
    }

}
enum class Pages{
    LISTING,
    DETAIL
}