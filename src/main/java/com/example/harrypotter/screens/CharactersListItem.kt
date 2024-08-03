package com.example.harrypotter.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.harrypotter.modle.Characters




@Composable
fun  CharctersListItem(characters: Characters, onClick: (characters: Characters) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable{onClick(characters)}
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberImagePainter(data = characters.displayIcon),
                contentDescription = "Characters",
                modifier = Modifier
                    .size(120.dp)
                    .clip(shape = CircleShape)
                    .background(Color.White)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = characters.displayName,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Blue
            )
            Spacer(modifier = Modifier.height(10.dp))

        }
    }
}
