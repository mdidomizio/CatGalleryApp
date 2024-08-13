package com.example.artgalleryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artgalleryapp.ui.theme.ArtGalleryAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtGalleryAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtGalleryApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ArtGalleryApp(
    modifier: Modifier = Modifier
) {
    var currentScreen by remember { mutableStateOf(1) }
    var picture by remember { mutableStateOf(R.drawable.cat_one) }
    var descriptionPicture by remember { mutableStateOf("A beautiful cat - One") }
    var title by remember { mutableStateOf("Title One") }
    var artist by remember { mutableStateOf("Artist One -") }
    var year by remember { mutableStateOf("Random Year One") }
    var onClickedNext by remember { mutableStateOf(false) }
    var onClickedBack by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        MainImage(
            picture = picture,
            description = descriptionPicture,
        )
        Column (
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth()
        ){
            Text(
                text = title,
                fontSize = 44.sp,
                modifier = modifier
                    .padding(30.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = modifier.padding(30.dp)

            ) {
                Text(
                    text = "$artist \n",
                    fontSize = 16.sp,
                    modifier = modifier
                )

                Text(
                    text = year,
                    fontSize = 16.sp,
                    modifier = modifier
                )

            }

        }

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            ActionButton(
                buttonName = "Back",
                onButtonClicked = { goBack() },
            )

            ActionButton(
                buttonName = "Next",
                onButtonClicked = { goNext() },
            )
        }
    }
}

@Composable
fun MainImage(
    picture: Int,
    description: String,
    modifier: Modifier = Modifier.fillMaxWidth()

){
    Image(
        painter = painterResource(picture),
        contentDescription = description,
        contentScale = ContentScale.Crop
    )
}

@Composable
fun ActionButton(
    buttonName: String,
    onButtonClicked: () -> Unit
){
    Button(
        onClick = { onButtonClicked }
    ) {
        Text(
            text = buttonName
        )
    }
}

fun goBack(){}
fun goNext(){}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtGalleryAppTheme {
        ArtGalleryApp()
    }
}