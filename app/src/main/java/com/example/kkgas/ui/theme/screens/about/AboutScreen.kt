package com.example.kkgas.ui.theme.screens.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
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
import com.example.kkgas.ui.theme.lightgreen
import com.example.kkgas.ui.theme.screens.home.HomeScreen

@Composable

fun AboutScreen(navController: NavController){
    Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
        ){





    }

}




@Composable
@Preview(showBackground = true)
fun AboutScreenPreview(){
    AboutScreen(rememberNavController())


}