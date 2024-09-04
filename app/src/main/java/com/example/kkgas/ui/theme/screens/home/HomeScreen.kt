package com.example.kkgas.ui.theme.screens.home


import android.annotation.SuppressLint
import androidx.compose.animation.core.EaseInCirc
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.material3.Card
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
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkgas.R
import com.example.kkgas.navigation.ROUT_BOOKGAS
import com.example.kkgas.navigation.ROUT_DASHBOARD
import com.example.kkgas.navigation.ROUT_DETAILS
import com.example.kkgas.navigation.ROUT_MOREINFO
import com.example.kkgas.navigation.ROUT_VIEWGASBUYER
import com.example.kkgas.ui.theme.green
import kotlinx.coroutines.launch




@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController:NavController) {


        //Navigation Drawer

        val drawerState = rememberDrawerState(DrawerValue.Closed)

        val scope = rememberCoroutineScope()

        val menuList = listOf(
            Icons.Filled.Settings to "details",
            Icons.Filled.AccountCircle to "dashboard",

        )

        var selectedItem by remember { mutableStateOf(-1) }

        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    DrawerHeader()
                    menuList.forEachIndexed { index, pair ->
                        NavigationDrawerItem(
                            label = {
                                Row(modifier = Modifier.fillMaxWidth()) {
                                    Icon(imageVector = pair.first, contentDescription = pair.second)
                                    Spacer(modifier = Modifier.width(15.dp))
                                    Text(text = pair.second)
                                }
                            },
                            selected = selectedItem == index,
                            onClick = { selectedItem = index })
                    }
                }
            }) {
            Scaffold(
                topBar = {

                    TopAppBar(title = { Text(text = "Saves time and costs", color = Color.White) },
                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }) {
                                Icon(Icons.Filled.Menu, contentDescription = "", tint = Color.White)
                            }
                        },colors = TopAppBarDefaults.mediumTopAppBarColors(Color.Black))

                }
            ) {
                //Main Content of the screen


                Column(modifier = Modifier.fillMaxSize()
                    .background(green)
                    .padding(top = 70.dp)
                    .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center) {


                            Image(
                                painter = painterResource(id = R.drawable.gashome),
                                contentDescription = "home",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(300.dp)
                                    .clip(shape = CircleShape).padding(50.dp),
                                contentScale = ContentScale.Crop
                            )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "Welcome to Kk Gas",
                        fontSize = 40.sp,
                        fontFamily = FontFamily.Cursive


                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Get your gas wih Kk gas",
                        fontSize = 25.sp
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Most reliable business in town!",
                        fontSize = 15.sp
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "With manageable costs",
                        fontSize = 15.sp

                    )
                    Text(
                        text = "and delivery",
                        fontSize = 15.sp,
                        )

                    Text(
                        text = "anytime anywhere",
                        fontSize = 15.sp,
                    )



                    Spacer(modifier = Modifier.height(10.dp))



                    Button(
                        onClick = { navController.navigate(ROUT_MOREINFO) },
                        shape = RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp),
                        colors = ButtonDefaults.buttonColors(Color.Black),
                        modifier = Modifier.padding(end = 200.dp )
                    ) {
                        Text(text = "Ask about us")
                    }



                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = { navController.navigate(ROUT_DASHBOARD) },
                        shape = RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp),
                        colors = ButtonDefaults.buttonColors(Color.Black),
                        modifier = Modifier.padding(end = 100.dp)
                    ) {
                        Text(text = "View our stock")
                    }


                    Spacer(modifier = Modifier.height(20.dp))




                    Button(
                        onClick = { navController.navigate(ROUT_DETAILS) },
                        shape = RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp),
                        colors = ButtonDefaults.buttonColors(Color.Black),
                        modifier = Modifier.padding(start = 90.dp)
                    ) {
                        Text(text = "Choose our gas")
                    }



                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = { navController.navigate(ROUT_BOOKGAS) },
                        shape = RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp),
                        colors = ButtonDefaults.buttonColors(Color.Black),
                        modifier = Modifier.padding(start = 200.dp)
                    ) {
                        Text(text = "Book your gas")
                    }
                }




            }


        }

}



@Composable
private fun DrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Other")
    }

}




@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){

    HomeScreen(navController = rememberNavController())

}