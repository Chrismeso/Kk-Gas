package com.example.kkgas.ui.theme.screens.more.info

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkgas.R
import com.example.kkgas.ui.theme.lightgreen
import com.example.kkgas.ui.theme.lightgreen
import com.example.kkgas.ui.theme.wondergreen

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable

fun MoreInfoScreen(navController: NavController){
    Column (modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())){
        var selected by remember { mutableIntStateOf(0) }
        Scaffold(
            bottomBar = {
                NavigationBar {
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
                                ) {
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
                    title = { Text(text = "Kk Gas") },
                    colors = TopAppBarDefaults.mediumTopAppBarColors(lightgreen)
                )
            },


            floatingActionButton = {
                FloatingActionButton(onClick = { /*TODO*/ }) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Add,
                            contentDescription = "menu")
                    }
                }
            },
            //Content Section
            content = @Composable{
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 60.dp),

                    ){

                    //Row 1
                    Row {
                        Card(
                            modifier = Modifier
                                .height(180.dp)
                                .width(200.dp)
                        ) {

                            Box (modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

                                Image(
                                    painter = painterResource(id = R.drawable.gasimage2),
                                    contentDescription ="home",
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(top = 30.dp)
                                        .padding(start = 10.dp),
                                    contentScale = ContentScale.Crop
                                )
                                Icon(imageVector = Icons.Default.Favorite, contentDescription = "favourite",
                                    modifier = Modifier
                                        .align(Alignment.TopStart)
                                        .padding(2.dp),
                                    tint = lightgreen
                                    )



                            }

                        }
                        Column (modifier = Modifier.padding(20.dp)){
                            Text(
                                text = "Get Kk Gas",
                                fontSize = 25.sp

                            )
                            Row {
                                Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = lightgreen, modifier = Modifier.size(30.dp))
                                Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = lightgreen, modifier = Modifier.size(30.dp))
                                Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = lightgreen, modifier = Modifier.size(30.dp))
                                Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = lightgreen, modifier = Modifier.size(30.dp))
                                Icon(imageVector = Icons.Default.Star, contentDescription = "star", tint = lightgreen, modifier = Modifier.size(30.dp))
                            }
                            Text(
                                text = "The reliable lpg gas you can find",
                                fontFamily = FontFamily.Serif
                                )
                            Text(
                                text = "14,400 Reviews",
                                fontFamily = FontFamily.Serif
                            )
                            val mContext = LocalContext.current
                            Button(
                                onClick = {val callIntent= Intent(Intent.ACTION_DIAL)
                                    callIntent.data="tel:0112577059".toUri()
                                    mContext.startActivity(callIntent)
                                },
                                colors = ButtonDefaults.buttonColors(lightgreen),
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Text(text = "Call")

                            }
                        }


                    }
                    // End of row
                    Spacer(modifier = Modifier.height(5.dp))
                    val mContext = LocalContext.current


                    //CALL
                    Button(
                        onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0112577059".toUri()
                            mContext.startActivity(callIntent)},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(start = 20.dp, end = 20.dp),
                        colors = ButtonDefaults.buttonColors(lightgreen),
                        shape = RoundedCornerShape(10.dp)
                    ) {

                        Text(text = "Call")

                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    //SMS
                    Button(
                        onClick = {  val smsIntent= Intent(Intent.ACTION_SENDTO)
                            smsIntent.data="smsto:0112577059".toUri()
                            smsIntent.putExtra("sms_body","Hello ,how was your day?")
                            mContext.startActivity(smsIntent) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(start = 20.dp, end = 20.dp),
                        colors = ButtonDefaults.buttonColors(lightgreen),
                        shape = RoundedCornerShape(10.dp)
                    ) {

                        Text(text = "SMS")

                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    //EMAIL
                    Button(
                        onClick = {  val shareIntent = Intent(Intent.ACTION_SEND)
                            shareIntent.type = "text/plain"
                            shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("chrismwikamba745@gmail.com"))
                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                            mContext.startActivity(shareIntent)},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(start = 20.dp, end = 10.dp),
                        colors = ButtonDefaults.buttonColors(lightgreen),
                        shape = RoundedCornerShape(10.dp)
                    ) {

                        Text(text = "Email")

                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "We are looking forward to work with you thank you for choosing Kk Gas",
                        fontSize = 30.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily.Cursive
                        )


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
        title = "Details",
        route="details",
        selectedIcon=Icons.Filled.Info,
        unselectedIcon=Icons.Outlined.Info,
        hasNews = true,
        badges=5
    ),


    BottomNavItem(
        title = "Dashboard",
        route="dashboard",
        selectedIcon=Icons.Filled.Menu,
        unselectedIcon=Icons.Outlined.Menu,
        hasNews = true,
        badges=1
    ),


    )



data class BottomNavItem(
    val title :String,
    val route :String,
    val selectedIcon: ImageVector,
    val unselectedIcon :ImageVector,
    val hasNews :Boolean,
    val badges :Int
)






@Composable
@Preview(showBackground = true)
fun MoreInfoScreenPreview(){
    MoreInfoScreen(navController = rememberNavController())


}