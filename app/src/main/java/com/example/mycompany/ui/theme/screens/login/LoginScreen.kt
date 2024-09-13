package com.example.mycompany.ui.theme.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mycompany.R
import com.example.mycompany.data.AuthViewModel
import com.example.mycompany.navigation.ROUT_HOME
import com.example.mycompany.navigation.ROUT_SIGNUP
import com.example.mycompany.ui.theme.Pink32


@Composable
fun LoginScreen(navController: NavController){

    Column (modifier = Modifier.fillMaxSize().background(Color.Black)){



        Image(
            painter = painterResource(id = R.drawable.fit2) ,
            contentDescription ="home",
            modifier = Modifier.fillMaxWidth().height(400.dp),
        )

        Spacer(modifier = Modifier.width(40.dp))


        Text(
            text = "SignIn",
            fontSize = 30.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.White,
            modifier = Modifier.padding(start = 30.dp)
        )

        Spacer(modifier = Modifier.width(40.dp))


        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        val context = LocalContext.current



        OutlinedTextField(
            value = email ,
            onValueChange ={email = it},
            label = { Text(text = "Full name", color = Color.White)},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "",) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(10.dp))


        OutlinedTextField(
                value = password ,
            onValueChange ={password= it},
            label = { Text(text = "Password", color = Color.White)},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "",)},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            visualTransformation = PasswordVisualTransformation()


        )


        val Mcontext = LocalContext.current
        val authViewModel = AuthViewModel(navController, context)

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                authViewModel.login(email, password)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 20.dp, end = 20.dp),
            colors = ButtonDefaults.buttonColors(Pink32),
            shape = RoundedCornerShape(10.dp)
        )

        {
            Text(
                text = "SignIn")

        }
        Spacer(modifier = Modifier.height(10.dp))



        Text(
            text = "Don't have an account?Register!",
            fontSize = 18.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.White,
            modifier = Modifier.fillMaxWidth()
                .clickable { navController.navigate(ROUT_SIGNUP) },
            textAlign = TextAlign.Center
        )


        Spacer(modifier = Modifier.width(60.dp))





    }


}




@Composable
@Preview(showBackground = true)
fun LoginScreenPreview(){
    LoginScreen(rememberNavController())
}

