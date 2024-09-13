package com.example.mycompany.ui.theme.screens.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mycompany.R
import com.example.mycompany.navigation.ROUT_ABOUT
import com.example.mycompany.navigation.ROUT_INTENT
import com.example.mycompany.navigation.ROUT_LOGIN
import com.example.mycompany.ui.theme.Pink32
import com.example.mycompany.ui.theme.PurpleGrey40


@Composable
fun HomeScreen(navController: NavController){

    Column (modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ){
        Image(
            painter = painterResource(id = R.drawable.img) ,
            contentDescription ="home",
            modifier = Modifier
                .size(300.dp)
                .clip(shape = CircleShape),
            contentScale = ContentScale.Crop
        )


        Text(
            text = "",
            fontSize = 60.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Magenta,
            )



        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Join the community and let us help you get the body you want",
            fontSize = 18.sp,
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Fitness starts here",
            fontSize = 18.sp,
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(50.dp))


        Button(
            onClick = { navController.navigate(ROUT_INTENT) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 30.dp, end = 30.dp),
            colors = ButtonDefaults.buttonColors(Pink32),
            shape = RoundedCornerShape(10.dp)
        ){
            Text(text = "Get started",fontSize = 20.sp,)
        }

        Spacer(modifier = Modifier.height(20.dp))


    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
}

