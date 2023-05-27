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
import com.example.hackatonfinal.R
import com.example.hackatonfinal.ui.theme.green40

data class EventHistory(
    val title: String,
    val time: String,
    val location: String,
    val description: String
)

@Composable
fun MyScreen() {
    val eventHistoryList = listOf(
        EventHistory(
            title = "Назва події 1",
            time = "19:00 - 22:00\n3 hours",
            location = "Місце проведення 1",
            description = "Tra tra das 1"
        ),
        EventHistory(
            title = "Назва події 2",
            time = "20:00 - 23:00\n3 hours",
            location = "Місце проведення 2",
            description = "Tra tra das 2"
        ),
        EventHistory(
            title = "Назва події 3",
            time = "21:00 - 00:00\n3 hours",
            location = "Місце проведення 3",
            description = "Tra tra das 3"
        )
    )



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
        ) {
            // Фото, яке можна змінювати за натиском
            Image(
                painter = painterResource(R.drawable.img),
                contentDescription = "User Photo",
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .clickable {
                    }
                    .align(Alignment.TopCenter)
            )
        }

        Text(
            text = "Ім'я користувача",
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .align(Alignment.CenterHorizontally)
                .offset(y = (-165.dp)), // Зміщення на 15dp вниз
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
        )

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
                CardField("Companies", 1)
                CardField("Monthly Hours", 2)
                CardField("All Hours", 3)
            }
        }

        Column(modifier = Modifier.padding(16.dp).offset(y = (-100.dp))) {
            eventHistoryList.forEach { event ->
                HistoryCard(event = event)
                Spacer(modifier = Modifier.height(16.dp))
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
        Column(modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)) {
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
