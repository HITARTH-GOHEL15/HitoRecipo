package org.example.hito2.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.example.hito2.data.MealModel

@Composable
fun RecipeDetails(
    recipe: MealModel
) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
                .padding(12.dp),
        ) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = MaterialTheme.colorScheme.primary.copy(0.1f),
                            shape = MaterialTheme.shapes.medium
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        model = recipe.image,
                        contentDescription = "thumbnail",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(230.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(8.dp))
                //Title
                recipe.title?.let {
                    Text(
                        text = it,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
                Spacer(modifier = Modifier.padding(8.dp))
                //Summary
                recipe.summary?.let {
                    Text(
                        text = it,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                //Time
                Details(
                    title = "ReadyInMinutes: ",
                    text = recipe.readyInMinutes.toString()
                )
                //Vegetarian
                Details(
                    title = "Vegetarian: ",
                    text = recipe.vegetarian.toString()
                )
                //CookTime
                Details(
                    title = "veryHealthy: ",
                    text = recipe.veryHealthy.toString()
                )
                //healthScore
                Details(
                    title = "healthScore: ",
                    text = recipe.healthScore.toString()
                )
                //SourceUrl
                Text(
                    text = recipe.sourceUrl.toString(),
                    fontWeight = FontWeight.Light,
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
}

@Composable
fun Names(
    text: String,
    fontWeight: FontWeight,
    fontStyle: TextStyle
) {
    Text(
        text = text,
        fontWeight = fontWeight,
        color = MaterialTheme.colorScheme.primary,
        style = fontStyle
    )
}

@Composable
fun Details(
    title: String,
    text: String
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ){
        Names(
            text = title,
            fontWeight = FontWeight.Bold,
            fontStyle = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
