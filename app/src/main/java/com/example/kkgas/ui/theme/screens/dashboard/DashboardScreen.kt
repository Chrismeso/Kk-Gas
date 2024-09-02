package com.example.kkgas.ui.theme.screens.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkgas.R
import com.example.kkgas.navigation.ROUT_ADDGAS
import com.example.kkgas.navigation.ROUT_BOOKGAS
import com.example.kkgas.navigation.ROUT_DETAILS
import com.example.kkgas.navigation.ROUT_MOREINFO
import com.example.kkgas.navigation.ROUT_VIEWGASBUYER
import com.example.kkgas.ui.theme.lightblue

@Composable

fun DashboardScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
        text = "Welcome to Kk gas",
        fontSize = 40.sp,
        fontFamily = FontFamily.Cursive,
        color = Color.Green

    )
        Image(
            painter = painterResource(id = R.drawable.gasicon1),
            contentDescription ="home",
            modifier = Modifier
                .size(200.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Get your preferencial gas here",
            fontSize = 20.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Green

        )
        Spacer(modifier = Modifier.height(20.dp))
        Column {
            //Start of main card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(700.dp),
                shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp),
                colors = CardDefaults.cardColors(lightblue),

                ) {
                //Row 1
                Row (modifier = Modifier.padding(20.dp)){
                    //first card
                    Card(modifier = Modifier
                        .width(160.dp)
                        .height(180.dp)
                        .clickable { navController.navigate(ROUT_DETAILS) },
                        elevation = CardDefaults.cardElevation(10.dp)) {
                        Column {
                            Spacer(modifier = Modifier.height(10.dp))
                            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center ) {
                                Image(
                                    painter = painterResource(id = R.drawable.details) , contentDescription = "home" , modifier = Modifier.size(100.dp)
                                )

                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "Details about Gas",
                                fontSize = 18.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontFamily = FontFamily.Serif
                            )
                        }

                    }
                    //end of first card
                    Spacer(modifier = Modifier.width(20.dp))

                    //Second card
                    Card(modifier = Modifier
                        .width(160.dp)
                        .height(180.dp).clickable { navController.navigate(ROUT_VIEWGASBUYER) },elevation = CardDefaults.cardElevation(10.dp)) {
                        Column {
                            Spacer(modifier = Modifier.height(10.dp))
                            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center ) {
                                Image(
                                    painter = painterResource(id = R.drawable.viewicon) , contentDescription = "home" , modifier = Modifier.size(100.dp)
                                )

                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "View product",
                                fontSize = 18.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontFamily = FontFamily.Serif

                            )
                        }

                    }
                    //end of second card

                }
                    //end of row1
                //Row 1
                Row (modifier = Modifier.padding(20.dp)){
                    //first card
                    Card(modifier = Modifier
                        .width(160.dp)
                        .height(180.dp)
                        .clickable { navController.navigate(ROUT_MOREINFO) },
                        elevation = CardDefaults.cardElevation(10.dp)) {
                        Column {
                            Spacer(modifier = Modifier.height(10.dp))
                            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center ) {
                                Image(
                                    painter = painterResource(id = R.drawable.moreinfo) , contentDescription = "home" , modifier = Modifier.size(100.dp)
                                )

                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "More info",
                                fontSize = 18.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontFamily = FontFamily.Serif
                            )
                        }

                    }
                    //end of first card
                    Spacer(modifier = Modifier.width(20.dp))

                    //Second card
                    Card(modifier = Modifier
                        .width(160.dp)
                        .height(180.dp).clickable { navController.navigate(ROUT_BOOKGAS) },elevation = CardDefaults.cardElevation(10.dp)) {
                        Column {
                            Spacer(modifier = Modifier.height(10.dp))
                            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center ) {
                                Image(
                                    painter = painterResource(id = R.drawable.bookingicon) , contentDescription = "home" , modifier = Modifier.size(100.dp)
                                )

                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "Book your gas",
                                fontSize = 18.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontFamily = FontFamily.Serif

                            )
                        }

                    }
                    //end of second card

                }
                //end of row1




            }


        }

        }
        //End of main card


    }





@Composable
@Preview(showBackground = true)
fun DashboardScreenPreview(){
    DashboardScreen(rememberNavController())


}