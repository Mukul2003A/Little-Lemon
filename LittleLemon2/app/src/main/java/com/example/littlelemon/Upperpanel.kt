package com.example.littlelemon

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UpperPanel() {
    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .background(LittleLemonColor.green)
            .fillMaxWidth()
    ) {
        Text(
            text = "Little Lemon", fontSize = 40.sp, fontWeight = FontWeight.Bold,
            color = LittleLemonColor.yellow,
            modifier = Modifier.padding(start = 20.dp, top = 20.dp)
        )
        Text(
            text = stringResource(id = R.string.chicago), fontSize = 24.sp, fontWeight = FontWeight.Bold,
            color = LittleLemonColor.cloud,
            modifier = Modifier.padding(start = 20.dp)
        )
        Row(
            Modifier
                .fillMaxWidth()
                .padding(20.dp), horizontalArrangement = Arrangement.Start) {
            Text(text = stringResource(id = R.string.description_one), Modifier.width(200.dp), color = LittleLemonColor.cloud, fontSize = 18.sp)
            Image(painter = painterResource(id = R.drawable.upperpanelimage), contentDescription = "",
                Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(20.dp)
                    ),
            )
        }
        Button(
            onClick = {
                Toast.makeText(context, "Order received. Thank you!", Toast.LENGTH_SHORT).show()
            },
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(containerColor = LittleLemonColor.yellow),
            modifier = Modifier.padding(horizontal = 10.dp),
        ){
            Text(text = stringResource(id = R.string.Order), fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0XFF333333))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UpperPanelPreview(){
    UpperPanel()
}