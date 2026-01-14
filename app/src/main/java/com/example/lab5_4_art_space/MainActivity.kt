package com.example.lab5_4_art_space // ИСПРАВЛЕНО: Изменено с lab5_5_art_space на lab5_4_art_space

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab5_4_art_space.ui.theme.Lab5Theme
import com.example.lab5_4_art_space.R // ДОБАВЛЕНО: Явный импорт класса R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab5Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var currentArtwork by remember { mutableIntStateOf(1) }
    
    val imageResource = when(currentArtwork) {
        1 -> R.drawable.artwork_1
        2 -> R.drawable.artwork_2
        else -> R.drawable.artwork_3
    }
    
    val titleResource = when(currentArtwork) {
        1 -> R.string.artwork_1_title
        2 -> R.string.artwork_2_title
        else -> R.string.artwork_3_title
    }
    
    val artistResource = when(currentArtwork) {
        1 -> R.string.artwork_1_artist
        2 -> R.string.artwork_2_artist
        else -> R.string.artwork_3_artist
    }
    
    val yearResource = when(currentArtwork) {
        1 -> R.string.artwork_1_year
        2 -> R.string.artwork_2_year
        else -> R.string.artwork_3_year
    }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        
        // Artwork Display
        ArtworkWall(
            imageResource = imageResource,
            contentDescription = stringResource(titleResource),
            modifier = Modifier.weight(1f)
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Artwork Information
        ArtworkDescriptor(
            title = stringResource(titleResource),
            artist = stringResource(artistResource),
            year = stringResource(yearResource)
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Navigation Controls
        DisplayController(
            onPreviousClick = {
                currentArtwork = when(currentArtwork) {
                    1 -> 3
                    else -> currentArtwork - 1
                }
            },
            onNextClick = {
                currentArtwork = when(currentArtwork) {
                    3 -> 1
                    else -> currentArtwork + 1
                }
            }
        )
        
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun ArtworkWall(
    imageResource: Int,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(4.dp)
            ),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = contentDescription,
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
fun ArtworkDescriptor(
    title: String,
    artist: String,
    year: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        shape = RoundedCornerShape(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Light
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Text(
                    text = artist,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = " ($year)",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}

@Composable
fun DisplayController(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = onPreviousClick,
            modifier = Modifier.width(140.dp)
        ) {
            Text(
                text = stringResource(R.string.previous_button),
                fontSize = 16.sp
            )
        }
        
        Button(
            onClick = onNextClick,
            modifier = Modifier.width(140.dp)
        ) {
            Text(
                text = stringResource(R.string.next_button),
                fontSize = 16.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    Lab5Theme {
        ArtSpaceApp()
    }
}
