package com.example.mycompany.ui.theme.screens.intent

import android.annotation.SuppressLint
import android.content.Intent
import android.provider.MediaStore
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mycompany.R
import com.example.mycompany.ui.theme.Pink32


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun IntentScreen(navController: NavController) {
    Column (modifier = Modifier.fillMaxSize()){

        var selected by remember { mutableIntStateOf(0) }

        Scaffold(
            bottomBar = {
                NavigationBar (
                    containerColor = Pink32
                ){

                    bottomNavItems.forEachIndexed { index, bottomNavItem ->
                        NavigationBarItem(
                            selected = index == selected,
                            onClick = {
                                selected = index
                                navController.navigate(bottomNavItem.route)
                            },
                            icon = {
                                BadgedBox(
                                    badge = {
                                        if (bottomNavItem.badges != 0) {
                                            Badge {
                                                Text(text = bottomNavItem.badges.toString())
                                            }
                                        } else if (bottomNavItem.hasNews) {
                                            Badge()
                                        }
                                    }
                                ){
                                    Icon(imageVector =
                                    if (index == selected)
                                        bottomNavItem.selectedIcon
                                    else
                                        bottomNavItem.unselectedIcon,
                                        contentDescription = bottomNavItem.title)
                                }

                            },
                            label = {
                                Text(text = bottomNavItem.title)
                            })
                    }
                }
            },
            topBar = {
                TopAppBar(
                    title = { Text(text =  "Fitness App", color = Color.White)},
                    colors = TopAppBarDefaults.mediumTopAppBarColors(Pink32))
            },


            //Content Section
            content =  @Composable{
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 100.dp)
                        .verticalScroll(rememberScrollState()),
                ){
                    Spacer(modifier = Modifier.height(20.dp))

                    Column() {
                        Text(text = "Personal Growth!", fontSize = 25.sp,modifier = Modifier.padding(start = 20.dp))
                        Text(text = "Give yourself grace in challenging moments..", fontSize = 16.sp,modifier = Modifier.padding(start = 20.dp))
                    }

                    Spacer(modifier = Modifier.height(20.dp))



                        Card(modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp)
                            .height(200.dp)){
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                Image(
                                    painter = painterResource(id = R.drawable.fit2) ,
                                    contentDescription ="home",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                                Text(text = "Hips & Glutes",
                                    fontSize = 30.sp,
                                    color = Color.White,
                                    modifier = Modifier.padding(start = 20.dp),
                                    fontWeight = FontWeight.ExtraBold)
                            }
                        }



                    Spacer(modifier = Modifier.height(20.dp))


                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp)
                            .height(100.dp)
                    ){

                        Row {
                            Card(modifier = Modifier
                                .width(200.dp)
                                .height(200.dp)){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Image(
                                        painter = painterResource(id = R.drawable.fit2) ,
                                        contentDescription ="home",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )

                                }
                            }
                            Spacer(modifier = Modifier.width(20.dp))


                            Column {
                                Spacer(modifier = Modifier.height(20.dp))

                                Text(text = "Hip Thrusts", fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
                                Text(text = "00:20")
                            }

                        }
                    }


                    Spacer(modifier = Modifier.height(20.dp))


                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp)
                            .height(100.dp)
                    ){

                        Row {
                            Card(modifier = Modifier
                                .width(200.dp)
                                .height(200.dp)){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Image(
                                        painter = painterResource(id = R.drawable.img_2) ,
                                        contentDescription ="home",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )

                                }
                            }
                            Spacer(modifier = Modifier.width(20.dp))


                            Column {
                                Spacer(modifier = Modifier.height(20.dp))

                                Text(text = "Lizard Stretch", fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
                                Text(text = "00:30")
                            }

                        }
                    }


                    Spacer(modifier = Modifier.height(20.dp))


                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp)
                            .height(100.dp)
                    ){

                        Row {
                            Card(modifier = Modifier
                                .width(200.dp)
                                .height(200.dp)){
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                    Image(
                                        painter = painterResource(id = R.drawable.fit2) ,
                                        contentDescription ="home",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )

                                }
                            }
                            Spacer(modifier = Modifier.width(20.dp))


                            Column {
                                Spacer(modifier = Modifier.height(20.dp))

                                Text(text = "Low lunge", fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
                                Text(text = "00:20")
                            }

                        }
                    }

                    Spacer(modifier = Modifier.height(120.dp))





                }









            }
        )

    }

}

val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        route="home",
        selectedIcon=Icons.Filled.Home,
        unselectedIcon=Icons.Outlined.Home,
        hasNews = false,
        badges=0
    ),



    BottomNavItem(
        title = "Book",
        route="add_account",
        selectedIcon=Icons.Filled.Star,
        unselectedIcon=Icons.Outlined.Star,
        hasNews = true,
        badges=0
    ),


    BottomNavItem(
        title = "View",
        route="view_account",
        selectedIcon=Icons.Filled.PlayArrow,
        unselectedIcon=Icons.Outlined.PlayArrow,
        hasNews = true,
        badges=0
    ),


    )

data class BottomNavItem(
    val title :String,
    val route :String,
    val selectedIcon: ImageVector,
    val unselectedIcon : ImageVector,
    val hasNews :Boolean,
    val badges :Int
)




@Composable
@Preview(showBackground = true)
fun IntentScreenPreview() {
    IntentScreen(rememberNavController())
}