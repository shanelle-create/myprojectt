package com.example.mycompany.ui.theme.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mycompany.R
import com.example.mycompany.data.AuthViewModel
import com.example.mycompany.navigation.ROUT_HOME
import com.example.mycompany.navigation.ROUT_LOGIN
import com.example.mycompany.ui.theme.Pink32
import com.example.mycompany.ui.theme.white


@Composable
fun SignupScreen(navController: NavController){

     Column(
         modifier = Modifier
             .fillMaxSize()
             .background(Color.Black)
             .verticalScroll(rememberScrollState()),
         ){

         Image(
             painter = painterResource(id = R.drawable.fit2) ,
             contentDescription ="home",
             modifier = Modifier.fillMaxWidth().height(400.dp),
         )

         Spacer(modifier = Modifier.height(10.dp))


         Text(
             text = "SignUp",
             fontSize = 30.sp,
             fontFamily = FontFamily.SansSerif,
             color = Color.White,
             modifier = Modifier.padding(start = 30.dp)
         )

         Spacer(modifier = Modifier.width(10.dp))



         var name by remember {mutableStateOf("")}
         var email by remember {mutableStateOf("")}
         var password by remember {mutableStateOf("")}
         var confpassword by remember {mutableStateOf("")}


         Spacer(modifier = Modifier.height(20.dp))


         OutlinedTextField(
             value = name ,
             onValueChange ={name = it},
             label = { Text(text = "Full name", color = white)},
             modifier = Modifier
                 .fillMaxWidth()
                 .padding(start = 20.dp, end = 20.dp),
             leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "",)},
             keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
)
         Spacer(modifier = Modifier.height(10.dp))

         OutlinedTextField(
             value = email ,
             onValueChange ={email = it},
             label = { Text(text = "Enter your email", color = white)},
             modifier = Modifier
                 .fillMaxWidth()
                 .padding(start = 20.dp, end = 20.dp),
             leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "",)},
             keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
         )

         Spacer(modifier = Modifier.height(10.dp))

         OutlinedTextField(
             value = password ,
             onValueChange ={password= it},
             label = { Text(text = "Password", color = white)},
             modifier = Modifier
                 .fillMaxWidth()
                 .padding(start = 20.dp, end = 20.dp),
             leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "",)},
             keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
             visualTransformation = PasswordVisualTransformation()


         )
         Spacer(modifier = Modifier.height(10.dp))

         OutlinedTextField(
             value = confpassword ,
             onValueChange ={confpassword= it},
             label = { Text(text = "Confirm Password", color = Color.White)},
             modifier = Modifier
                 .fillMaxWidth()
                 .padding(start = 20.dp, end = 20.dp),
             leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "",)},
             keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
             visualTransformation = PasswordVisualTransformation()


         )

         Spacer(modifier = Modifier.height(10.dp))

         val context = LocalContext.current
         val authViewModel = AuthViewModel(navController, context)
         Button(onClick = {
             authViewModel.signup(name, email, password,confpassword)
         },
             colors = ButtonDefaults.buttonColors(Pink32),
             modifier = Modifier
                 .fillMaxWidth()
                 .padding(start = 20.dp, end = 20.dp),
             shape = RoundedCornerShape(5.dp)) {
             Text(text = "SignUp")
         }



         Spacer(modifier = Modifier.height(10.dp))

         Button(
             onClick = {navController.navigate(ROUT_LOGIN) },
             modifier = Modifier
                 .fillMaxWidth()
                 .height(50.dp)
                 .padding(start = 20.dp, end = 20.dp),
             colors = ButtonDefaults.buttonColors(Pink32),
             shape = RoundedCornerShape(10.dp)
         )

         {
             Text(
                 text = "LOGIN")

         }
     }
}

@Composable
@Preview(showBackground = true)
fun SignupScreenPreview(){
    SignupScreen(rememberNavController())
}