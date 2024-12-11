package com.example.lazyverticalgrid

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ImageItem(val title: String, val imageRes: Int)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                PantallaGaleria()
            }
        }
    }
}

@Composable
fun PantallaGaleria() {
    val images = listOf(
        ImageItem("Imagen 1", R.drawable.mix2),
        ImageItem("Imagen 2", R.drawable.mix3),
        ImageItem("Imagen 3", R.drawable.power),
        ImageItem("Imagen 4", R.drawable.pfp),
        ImageItem("Imagen 5", R.drawable.radardenovedades),
        ImageItem("Imagen 6", R.drawable.phnkr),
        ImageItem("Imagen 7", R.drawable.radardenovedades),
        ImageItem("Imagen 8", R.drawable.phnkr)
    )

    val context = LocalContext.current

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(16.dp)
    ) {
        items(images) { image ->
            ImagenTargeta(imageItem = image, context = context) { clickedImage ->
                Toast.makeText(context, "Tú hiciste clic en: ${clickedImage.title}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun ImagenTargeta(imageItem: ImageItem, context: android.content.Context, onClick: (ImageItem) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.Gray),
        onClick = { onClick(imageItem) }
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = imageItem.imageRes),
                contentDescription = imageItem.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = imageItem.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
