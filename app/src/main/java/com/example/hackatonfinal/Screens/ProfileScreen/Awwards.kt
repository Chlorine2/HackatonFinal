package com.example.hackatonfinal.Screens.ProfileScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hackatonfinal.R
import com.example.hackatonfinal.graphs.ListOfScreens

data class Awards(
    val photoResId: Int,
    val title: String,
    val location: String,
    val description: String
)


@Composable
fun AwardsItemCard(navController: NavController, awards: Companies) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(8.dp))
            .shadow(18.dp),
        color = Color.LightGray,
    ) {
        Column(modifier = Modifier.padding(16.dp).clickable{navController.navigate(ListOfScreens.Detail.name)}
        ) {
            Image(
                painter = painterResource(awards.photoResId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(shape = RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = awards.title,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = awards.description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Black
                    )
                }
                Column(modifier = Modifier.padding(start = 16.dp)) {
                    Text(
                        text = awards.location,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Black,
                        modifier = Modifier.align(Alignment.End)
                    )
                }

                Modifier.clickable {
                    navController.navigate(ListOfScreens.Awards.name)
                }
            }
        }
    }
}
@Composable
fun AwardsScreen(navController: NavController) {
    val companies = listOf(
        Companies(
            photoResId = R.drawable.img_5,
            title = "Unloading the cars",
            location = "Lviv",
            description = ""
        ),
        Companies(
            photoResId = R.drawable.img,
            title = "Netting",
            location = "Lviv",
            description = ""
        ),
        Companies(
            photoResId = R.drawable.img_6,
            title = "Рelp with clothes",
            location = "Lviv",
            description = ""
        )
    )

    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {        companies.forEach { awards ->
        AwardsItemCard(navController, awards)
    }
    }
}

