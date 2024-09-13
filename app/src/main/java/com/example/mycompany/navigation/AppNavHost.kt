package com.example.mycompany.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycompany.ui.theme.login.LoginScreen
import com.example.mycompany.ui.theme.screens.about.AboutScreen
import com.example.mycompany.ui.theme.screens.account.AddAccountScreen
import com.example.mycompany.ui.theme.screens.account.ViewAccountScreen

import com.example.mycompany.ui.theme.screens.home.HomeScreen
import com.example.mycompany.ui.theme.screens.intent.IntentScreen
import com.example.mycompany.ui.theme.screens.taskmanager.AddTaskScreen
import com.example.mycompany.ui.theme.screens.taskmanager.ViewTaskScreen
import com.example.mycompany.ui.theme.signup.SignupScreen
import com.example.mycompany.ui.theme.splash.SplashScreen


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination:String = ROUT_SPLASH
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

        composable(ROUT_HOME) {
            HomeScreen(navController = navController)
        }

        composable(ROUT_ABOUT) {
         AboutScreen(navController = navController)
        }

        composable(ROUT_SPLASH) {
            SplashScreen(navController = navController)
        }

        composable(ROUT_SIGNUP) {
            SignupScreen(navController = navController)
        }

        composable(ROUT_LOGIN) {
            LoginScreen(navController = navController)
        }

        composable(ROUT_INTENT) {
            IntentScreen(navController = navController)
        }
        composable(ADD_TASK){
            AddTaskScreen(navController = navController)
        }
        composable(VIEW_TASKS){
            ViewTaskScreen(navController = navController)
        }

        composable(ADD_ACCOUNT){
            AddAccountScreen(navController = navController)
        }
        composable(VIEW_ACCOUNT){
            ViewAccountScreen(navController = navController)
        }






    }
    }








