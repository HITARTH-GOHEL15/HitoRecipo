package org.example.hito2.ui.search_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import org.example.hito2.core.HITO_2Theme
import org.example.hito2.data.MealModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SearchListCard(
    recipe: MealModel,
    onRecipeClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { onRecipeClick() }
            .background(color = MaterialTheme.colorScheme.primary.copy(0.1f) , shape = MaterialTheme.shapes.medium),
        contentAlignment = Alignment.Center
    ) {
        Row {
            AsyncImage(
                model = recipe.image,
                contentDescription = "thumbnail",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(MaterialTheme.shapes.medium)
                    .weight(0.3f)
                    .height(180.dp)
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Column(
                modifier = Modifier
                    .weight(0.7f)
                    .padding(vertical = 10.dp)
            ) {
                recipe.title?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
                recipe.summary?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodyMedium,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 3,
                        lineHeight = 24.sp
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun SearchListCardPreview() {
    HITO_2Theme {

    }
}

