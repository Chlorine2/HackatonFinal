package com.example.hackatonfinal.Screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.hackatonfinal.models.Project
import com.example.hackatonfinal.ui.theme.green40
import com.example.hackatonfinal.viewModel.SharedViewModel
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

data class Event(
    val photoResId: Int,
    val title: String,
    val time: String,
    val category: String,
    val description: String
)

@Composable
fun EventItemCard(data: Project, onClick: () -> Unit, viewModel: SharedViewModel, photoResId: Int, height: Dp) {
    Surface(

        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(20.dp))
            .shadow(18.dp)
            .requiredHeight(height)
            .clickable { viewModel.updateProject(data); onClick() },
        color = green40
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(photoResId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(shape = RoundedCornerShape(18.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = data.name,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = data.description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White
                    )
                }
                Column(modifier = Modifier.padding(start = 16.dp)) {
                    Text(
                        text = data.category,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White,
                        modifier = Modifier.align(Alignment.End)
                    )
                    Text(
                        text = formatDateAndTime(data.startTime),
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White,
                        modifier = Modifier.align(Alignment.End)
                    )

                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EventItemCard2(data: Project, onClick: () -> Unit, viewModel: SharedViewModel, photoResId: Int) {
    Surface(

        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(18.dp))
            .shadow(18.dp)
            .clickable { viewModel.updateProject(data); onClick() },
        color = green40,
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(photoResId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(shape = RoundedCornerShape(18.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = data.name,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.White

                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = data.description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White
                    )
                }
                Column(modifier = Modifier.padding(start = 16.dp)) {
                    Text(
                        text = data.category,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White,
                        modifier = Modifier.align(Alignment.End)
                    )
                    Text(
                        text = formatDateAndTime(data.startTime),
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White,
                        modifier = Modifier.align(Alignment.End)
                    )

                }
            }
        }
    }
}
private fun formatDateAndTime(dateTime: String): String {
    var formattedDate = ""
    try {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val date = dateFormat.parse(dateTime)
        val outputDateFormat = SimpleDateFormat("dd.MM.yyyy HH:mm") // Формат виведення дати і часу
        formattedDate = outputDateFormat.format(date)
    } catch (e: ParseException) {
        e.printStackTrace()
        // Обробка помилки розпарсингу дати
    }
    return formattedDate
}
