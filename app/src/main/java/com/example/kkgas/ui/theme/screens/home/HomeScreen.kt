package com.example.kkgas.ui.theme.screens.home


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkgas.R
import com.example.kkgas.navigation.ROUT_BOOKGAS
import com.example.kkgas.navigation.ROUT_DETAILS
import com.example.kkgas.navigation.ROUT_MOREINFO
import com.example.kkgas.navigation.ROUT_VIEWGASBUYER



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController:NavController) {
    Column {
        //Main Content of the screen
        Image(
            painter = painterResource(id = R.drawable.gashome),
            contentDescription = "home",
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp)
                .padding(start = 10.dp),
            contentScale = ContentScale.Crop
        )


        Text(
            text = "Welcome to Kk Gas",
            fontSize = 30.sp,
            fontFamily = FontFamily.SansSerif

        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Get your gas wih Kk gas",
            fontSize = 25.sp
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Most reliable business in town!",
            fontSize = 25.sp
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "With managable costs delivery anytime anywhere",
            fontSize = 25.sp
        )
        Text(
            text = " Delivery anytime anywhere",
            fontSize = 25.sp

        )


        Spacer(modifier = Modifier.height(10.dp))



        Button(
            onClick = { navController.navigate(ROUT_MOREINFO) },
            shape = RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp),
            colors = ButtonDefaults.buttonColors(Color.Black)
        ) {
            Text(text = "Ask about us")
        }



        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { navController.navigate(ROUT_VIEWGASBUYER) },
            shape = RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp),
            colors = ButtonDefaults.buttonColors(Color.Black)
        ) {
            Text(text = "View our stock")
        }


        Spacer(modifier = Modifier.height(20.dp))




        Button(
            onClick = { navController.navigate(ROUT_DETAILS) },
            shape = RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp),
            colors = ButtonDefaults.buttonColors(Color.Black)
        ) {
            Text(text = "Choose our gas")
        }



        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { navController.navigate(ROUT_BOOKGAS) },
            shape = RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp),
            colors = ButtonDefaults.buttonColors(Color.Black)
        ) {
            Text(text = "Book your gas")
        }


    }
}




@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){

    HomeScreen(navController = rememberNavController())

}