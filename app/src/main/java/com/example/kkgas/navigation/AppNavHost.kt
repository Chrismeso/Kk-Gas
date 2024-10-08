package com.example.kkgas.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kkgas.ui.theme.screens.about.AboutScreen
import com.example.kkgas.ui.theme.screens.book.BookGasScreen
import com.example.kkgas.ui.theme.screens.book.ViewBookedGascreen
import com.example.kkgas.ui.theme.screens.dashboard.DashBoardScreenAdmin
import com.example.kkgas.ui.theme.screens.dashboard.DashboardScreen
import com.example.kkgas.ui.theme.screens.details.DetailsScreen
import com.example.kkgas.ui.theme.screens.home.HomeScreen
import com.example.kkgas.ui.theme.screens.login.LoginScreen
import com.example.kkgas.ui.theme.screens.signup.SignupScreen
import com.example.kkgas.ui.theme.screens.splash.SplashScreen
import com.example.kkgas.ui.theme.screens.gas.AddGasScreen
import com.example.kkgas.ui.theme.screens.gas.ViewGasScreen
import com.example.kkgas.ui.theme.screens.gas.ViewGasScreenBuyer
import com.example.kkgas.ui.theme.screens.more.info.MoreInfoScreen

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
        composable(ROUT_DASHBOARD) {
            DashboardScreen(navController = navController)
        }
        composable(ROUT_DETAILS) {
            DetailsScreen(navController = navController)
        }
        composable(ROUT_ADDGAS) {
            AddGasScreen(navController = navController)
        }
        composable(ROUT_VIEWGAS) {
            ViewGasScreen(navController = navController)
        }
        composable(ROUT_MOREINFO) {
            MoreInfoScreen(navController = navController)
        }
        composable(ROUT_VIEWGASBUYER) {
            ViewGasScreenBuyer(navController = navController)
        }
        composable(ROUT_BOOKGAS) {
            BookGasScreen(navController = navController)
        }
        composable(ROUT_VIEWBOOKEDGAS) {
            ViewBookedGascreen(navController = navController)
        }
        composable(ROUT_DASHBOARDADMIN) {
            DashBoardScreenAdmin(navController = navController)
        }

    }
}