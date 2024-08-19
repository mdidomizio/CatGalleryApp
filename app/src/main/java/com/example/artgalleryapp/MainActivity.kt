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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.res.stringResource
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

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        when (currentScreen) {
            1 -> {
                MainImage (
                    picture = R.drawable.cat_one,
                    description = stringResource(R.string.a_wonderful_cat_one),
                )

                MainTextBlock (
                    title = stringResource(R.string.title_one),
                    artist = stringResource(R.string.artist_one) ,
                    year = stringResource(R.string.year_one)
                )

                MainButtonsRow(
                    onButtonClickedBack = { currentScreen = 5},
                    onButtonClickedNext = { currentScreen = 2 },
                )
            }
            2 -> {
                MainImage (
                    picture = R.drawable.cat_two,
                    description = stringResource(R.string.a_wonderful_cat_two),
                )

                MainTextBlock (
                    title = stringResource(R.string.title_two),
                    artist = stringResource(R.string.artist_two) ,
                    year = stringResource(R.string.year_two)
                )

                MainButtonsRow(
                    onButtonClickedBack = { currentScreen = 1},
                    onButtonClickedNext = { currentScreen = 3 },
                )

            }
            3 -> {
                MainImage (
                    picture = R.drawable.cat_three,
                    description = stringResource(R.string.a_wonderful_cat_three),
                )

                MainTextBlock (
                    title = stringResource(R.string.title_three),
                    artist = stringResource(R.string.artist_three) ,
                    year = stringResource(R.string.year_three)
                )

                MainButtonsRow(
                    onButtonClickedBack = { currentScreen = 2},
                    onButtonClickedNext = { currentScreen = 4 },
                )
            }
            4 -> {
                MainImage (
                    picture = R.drawable.cat_four,
                    description = stringResource(R.string.a_wonderful_cat_four),
                )

                MainTextBlock (
                    title = stringResource(R.string.title_four),
                    artist = stringResource(R.string.artist_four) ,
                    year = stringResource(R.string.year_four)
                )

                MainButtonsRow(
                    onButtonClickedBack = { currentScreen = 3},
                    onButtonClickedNext = { currentScreen = 5 },
                )
            }
           else -> {
               MainImage (
                   picture = R.drawable.cat_five,
                   description = stringResource(R.string.a_wonderful_cat_five),
               )

               MainTextBlock (
                   title = stringResource(R.string.title_five),
                   artist = stringResource(R.string.artist_five) ,
                   year = stringResource(R.string.year_five)
               )

               MainButtonsRow(
                   onButtonClickedBack = { currentScreen = 4},
                   onButtonClickedNext = { currentScreen = 1 },
               )
           }
        }
    }
}

@Composable
fun MainImage(
    picture: Int,
    description: String,
    modifier: Modifier = Modifier.height(300.dp)
){
    Image(
        painter = painterResource(picture),
        contentDescription = description,
        contentScale = ContentScale.FillHeight,
        modifier = modifier
            .fillMaxWidth(),
    )
}

@Composable
fun MainTextBlock(
    title: String,
    artist: String,
    year: String,
    modifier: Modifier = Modifier

){
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
}}

@Composable
fun ActionButton(
    buttonName: String,
    buttonClicked: () -> Unit
){
    Button(
        onClick = buttonClicked
    ) {
        Text(
            text = buttonName
        )
    }
}


@Composable
fun MainButtonsRow(
    onButtonClickedBack: () -> Unit,
    onButtonClickedNext: () -> Unit,
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        ActionButton(
            buttonName = "Back",
            buttonClicked = onButtonClickedBack
        )

        ActionButton(
            buttonName = "Next",
            buttonClicked = onButtonClickedNext
        )
    }
}

/*fun onButtonClickedBack(currentScreen: Int) {
    if (currentScreen >= 6){
        currentScreen = 1
    } else { currentScreen++ }

}*/

/*fun onButtonClickedNext(
    currentScreen: Int
) {
     if (currentScreen <= 1){
        currentScreen = 6
    } else { currentScreen-- }
    }*/


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtGalleryAppTheme {
        ArtGalleryApp()
    }
}