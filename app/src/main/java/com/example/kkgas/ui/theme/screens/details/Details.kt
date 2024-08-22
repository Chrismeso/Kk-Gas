package com.example.kkgas.ui.theme.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkgas.R
import com.example.kkgas.navigation.ROUT_MOREINFO
import com.example.kkgas.ui.theme.lightgreen
import com.example.kkgas.ui.theme.wondergreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun DetailsScreen(navController: NavController){

    Column(
        modifier = Modifier.fillMaxSize()
    ) {



        TopAppBar(

            title = { Text(text = "All types of lpg gas you can find here") },
            colors = TopAppBarDefaults.mediumTopAppBarColors(wondergreen),
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu",
                        tint = Color.White
                    )

                }
            },

            actions={
                IconButton(onClick = { /*TODO*/ }){

                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Notifications",
                        tint = Color.White
                    )

                }
            }
        )


        Box (modifier = Modifier.height(280.dp), contentAlignment = Alignment.Center){

            Image(
                painter = painterResource(id = R.drawable.gashome),
                contentDescription ="home",
                modifier = Modifier.fillMaxSize()
            )







            Spacer(modifier = Modifier.height(20.dp))

        }

        //SEARCHBAR
        var search by remember { mutableStateOf("") }

        OutlinedTextField(
            value = search,
            onValueChange ={search= it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "search") },
            placeholder = { Text(text = "Choose your location") }
        )

        //END OF SEARCHBAR


        Spacer(modifier = Modifier.height(20.dp))
        //Row1
        Row(modifier = Modifier
            .padding(20.dp)
            .horizontalScroll(rememberScrollState())) {
            //CARD 1

            Card(
                modifier = Modifier
                    .height(180.dp)
                    .width(200.dp)
            ) {

               Row {
                   Box (modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

                       Image(
                           painter = painterResource(id = R.drawable.promini),
                           contentDescription ="home",
                           modifier = Modifier.fillMaxSize(),
                           contentScale = ContentScale.Crop
                       ) }
                   }
               }
            Column (
                modifier = Modifier.padding(10.dp),
                horizontalAlignment = Alignment.Start
                ){
                Text(
                    text = "6Kg Pro mini gas ",
                    modifier = Modifier.padding(top = 70.dp),
                    fontFamily = FontFamily.Serif
                )

                Text(
                    text = "ksh 4000 ",
                    modifier = Modifier.padding(top = 10.dp),
                    fontFamily = FontFamily.Serif
                )


            }
            Spacer(modifier = Modifier.width(40.dp))
            //card2
            Card(
                modifier = Modifier
                    .height(180.dp)
                    .width(200.dp)
            ) {

              Row {
                  Box (modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

                      Image(
                          painter = painterResource(id = R.drawable.mpishimini),
                          contentDescription ="home",
                          modifier = Modifier.fillMaxSize(),
                          contentScale = ContentScale.Crop
                      )

                      Spacer(modifier = Modifier.height(20.dp))
                  }
                 Column (  modifier = Modifier.padding(10.dp),
                     horizontalAlignment = Alignment.Start){

                     Text(
                         text = "6Kg mpishi gas ",
                         modifier = Modifier.padding(top = 70.dp),
                         fontFamily = FontFamily.Serif
                     )

                     Text(
                         text = "ksh 4500 ",
                         modifier = Modifier.padding(top = 10.dp),
                         fontFamily = FontFamily.Serif
                     )

                 }


              }

            }
            Spacer(modifier = Modifier.width(40.dp))
            //card 3
            Card(
                modifier = Modifier
                    .height(180.dp)
                    .width(200.dp)
            ) {

                Row {
                    Box (modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

                        Image(
                            painter = painterResource(id = R.drawable.kgasmini),
                            contentDescription ="home",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.height(20.dp))
                    }
                    Column (modifier = Modifier.padding(10.dp),
                        horizontalAlignment = Alignment.Start){
                        Text(
                            text = "6Kg Kgas gas ",
                            modifier = Modifier.padding(top = 70.dp),
                            fontFamily = FontFamily.Serif
                        )

                        Text(
                            text = "ksh 4500 ",
                            modifier = Modifier.padding(top = 10.dp),
                            fontFamily = FontFamily.Serif
                        )

                    }

                }
                }
            Spacer(modifier = Modifier.width(40.dp))
            // Card 4
            Card(
                modifier = Modifier
                    .height(180.dp)
                    .width(200.dp)
            ) {
                Row {

                    Box (modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

                        Image(
                            painter = painterResource(id = R.drawable.totalmini),
                            contentDescription ="home",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.height(20.dp))
                    }
                    Column (modifier = Modifier.padding(10.dp),
                        horizontalAlignment = Alignment.Start){
                        Text(
                            text = "6Kg mpishi gas ",
                            modifier = Modifier.padding(top = 70.dp),
                            fontFamily = FontFamily.Serif
                        )

                        Text(
                            text = "ksh 4500 ",
                            modifier = Modifier.padding(top = 10.dp),
                            fontFamily = FontFamily.Serif
                        )


                    }
                }


            }





        }


        Button(
            onClick = { navController.navigate(ROUT_MOREINFO) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 20.dp, end = 20.dp),
            colors = ButtonDefaults.buttonColors(lightgreen),
            shape = RoundedCornerShape(10.dp)
        ) {

            Text(text = "Get Started")

        }







    }

}

@Composable
@Preview(showBackground = true)
fun DetailsScreenPreview(){
    DetailsScreen(rememberNavController())


}