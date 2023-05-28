package com.example.hackatonfinal.Screens.ProfileScreen

import android.graphics.BitmapFactory
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter.State.Empty.painter
import com.example.hackatonfinal.R
import com.example.hackatonfinal.graphs.ListOfScreens
import com.example.hackatonfinal.ui.theme.blue
import com.example.hackatonfinal.ui.theme.green40
import java.util.Stack

data class EventHistory(
    val title: String,
    val time: String,
    val location: String,
    val description: String
)

@Composable
fun MyScreen(navController: NavController) {
    val eventHistoryList = listOf(
        EventHistory(
            title = "Lviv Open Lab",
            time = "3 hours",
            location = "Avenue Chervonoi Kalyny",
            description = "Medical assistance"
        ),
        EventHistory(
            title = "Lvivskyi lytsar",
            time = "3 hours",
            location = "Chornovola avenue",
            description = "Assistance to Ukrainian soldiers"
        ),
        EventHistory(
            title = "Plast",
            time = "3 hours",
            location = "Saharova str",
            description = "Cooking meals for refugees"
        ), EventHistory(
            title = "Bur",
            time = "3 hours",
            location = "Plyznyka str",
            description = "Unloading the machine"
        )
    )
    val visibleItemCount = 2
    var currentIndex by remember { mutableStateOf(visibleItemCount) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .height(350.dp)
                .fillMaxWidth()
                .background(green40)
                .zIndex(-20f)
        ) {
            // Фото, яке можна змінювати за натиском
            Image(
                painter = painterResource(id = R.drawable.img_2),
                contentDescription = "User Photo",
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .clickable {
                    }
                    .align(Alignment.TopCenter)
            )
        }

        Column(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Ostap Vyshnia",
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .align(Alignment.CenterHorizontally)
                    .offset(y = (-165.dp)), // Зміщення на 15dp вниз
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(110.dp)
                .offset(y = (-100.dp))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CardField(title = "Companies", number = 23)
                CardField(title = "Monthly Hours", number = 24)
                CardField(title = "Total", number = 95)
            }
        }
        Button(
            onClick = { navController.navigate(route = ListOfScreens.Companies.name) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(60.dp)
                .zIndex(5f)
                .offset(y = (-100.dp)),
        colors = ButtonDefaults.buttonColors(blue)
        ) {
            Text(text = "Awards")
        }

        Column(modifier = Modifier.padding(16.dp).offset(y = (-100.dp))) {
            eventHistoryList.take(currentIndex).forEach { event ->
                HistoryCard(event = event)
                Spacer(modifier = Modifier.height(16.dp))
            }

            if (currentIndex < eventHistoryList.size) {
                Button(
                    onClick = {
                        currentIndex += visibleItemCount
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(blue)
                ) {
                    Text(text = "Завантажити ще")
                }
            }
        }
    }
}
    @Composable
    fun CardField(title: String, number: Int) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = title, fontSize = 16.sp)
            Text(text = number.toString(), fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }
    }

    @Composable
    fun HistoryCard(event: EventHistory) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                .clip(RoundedCornerShape(8.dp))
                .shadow(18.dp),
            color = Color.LightGray,
        ) {
            Column(
                modifier = Modifier.padding(
                    top = 8.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 8.dp
                )
            ) {
                Row {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = event.title,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = event.description,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Black
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .align(Alignment.Top)
                    ) {
                        Text(
                            text = event.time,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Black,
                            modifier = Modifier.align(Alignment.End)
                        )
                        Text(
                            text = event.location,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Black,
                            modifier = Modifier.align(Alignment.End)
                        )
                    }
                }
            }
        }
    }

