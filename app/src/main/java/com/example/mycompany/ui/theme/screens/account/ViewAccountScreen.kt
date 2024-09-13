package com.example.mycompany.ui.theme.screens.account

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.mycompany.data.AccountViewModel
import com.example.mycompany.models.Account


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ViewAccountScreen(navController:NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var accountRepository = AccountViewModel(navController, context)


        val emptyAccountState = remember { mutableStateOf(Account("","","","","")) }
        var emptyAccountsListState = remember { mutableStateListOf<Account>() }

        var accounts = accountRepository.ViewAccount(emptyAccountState, emptyAccountsListState)



        Spacer(modifier = Modifier.height(50.dp))


         Text(
             text = "Bookings",
             fontSize = 18.sp,
             fontFamily = FontFamily.SansSerif
         )


                    Spacer(modifier = Modifier.height(20.dp))

                    LazyColumn(){
                        items(accounts){
                            AccountItem(
                                name = it.name,
                                title = it. title,
                                email = it.email,
                                id = it.id,
                                navController = navController,
                                accountRepository = accountRepository,
                                accountImage = it.imageUrl
                            )
                        }
                    }

    }
}







@Composable
fun AccountItem(name:String, title:String, email:String, id:String,
                navController:NavHostController,
                accountRepository:AccountViewModel, accountImage:String) {

    //1 item

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(15.dp)) {
        Card (modifier = Modifier
            .height(200.dp)
            .width(370.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = rememberAsyncImagePainter(accountImage),
                    contentDescription = "null",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

            }
        }
            Text(text =name,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Default,
                color = Color.Black
            )


            Text(text = title,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.Default,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(text = email,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Default,
                color = Color.Black
            )
        Spacer(modifier = Modifier.height(5.dp))

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){

            IconButton(onClick = {  accountRepository.updateAccount(id)}) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "", tint = Color.White)
            }

            Spacer(modifier = Modifier.width(5.dp))

            IconButton(onClick = { accountRepository.deleteAccount(id) }) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "", tint = Color.White)
            }


        }




        Divider()








        //end 1 item

    }





}



@Composable
@Preview(showBackground = true)
fun ViewAccountScreenPreview(){

    ViewAccountScreen(navController = rememberNavController())

}




