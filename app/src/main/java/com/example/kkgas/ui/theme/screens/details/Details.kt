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
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkgas.R
import com.example.kkgas.navigation.ROUT_MOREINFO
import com.example.kkgas.ui.theme.green
import com.example.kkgas.ui.theme.lightgreen
import com.example.kkgas.ui.theme.wondergreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun DetailsScreen(navController: NavController){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())


    ) {



        TopAppBar(

            title = { Text(
                text = "All types of Lpg gas you can find here",
                fontFamily = FontFamily.Serif
                ) },
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
            placeholder = { Text(text = "Choose your Gas") }
        )

        //END OF SEARCHBAR


        Spacer(modifier = Modifier.height(20.dp))
        //Row1
        Row(modifier = Modifier
            .padding(20.dp)
            .horizontalScroll(rememberScrollState())) {
            //CARD 1
            Row (modifier = Modifier.padding(20.dp)){

                Card(
                    modifier = Modifier
                        .height(160.dp)
                        .width(150.dp)
                ) {


                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                        Image(
                            painter = painterResource(id = R.drawable.promini),
                            contentDescription = "home",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                }


                        Column (
                            modifier = Modifier.padding(10.dp)
                        ){
                            Text(
                                text = "6Kg sea gas ",
                                modifier = Modifier.padding(top = 90.dp, start = 10.dp),
                                fontFamily = FontFamily.Serif
                            )

                            Text(
                                text = "ksh 4000 ",
                                modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                                fontFamily = FontFamily.Serif
                            )
                            val mContext = LocalContext.current
                            //STK
                            Button(
                                onClick = {  val simToolKitLaunchIntent =
                                    mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                                    simToolKitLaunchIntent?.let { mContext.startActivity(it) } },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .padding(start = 50.dp, end = 50.dp),
                                colors = ButtonDefaults.buttonColors(green),
                                shape = RoundedCornerShape(10.dp)
                            ) {

                                Text(text = "Purchase")

                            }







                }




            }

            Spacer(modifier = Modifier.width(10.dp))
            //card2
            Row (modifier = Modifier.padding(20.dp)){

                Card(
                    modifier = Modifier
                        .height(160.dp)
                        .width(150.dp)
                ) {


                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                        Image(
                            painter = painterResource(id = R.drawable.mpishimini),
                            contentDescription = "home",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
                        Column (  modifier = Modifier.padding(10.dp),
                            horizontalAlignment = Alignment.Start){

                            Text(
                                text = "6Kg mpishi gas ",
                                modifier = Modifier.padding(top = 90.dp, start = 10.dp),
                                fontFamily = FontFamily.Serif
                            )

                            Text(
                                text = "ksh 4500 ",
                                modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                                fontFamily = FontFamily.Serif
                            )
                            val mContext = LocalContext.current
                            //STK
                            Button(
                                onClick = {  val simToolKitLaunchIntent =
                                    mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                                    simToolKitLaunchIntent?.let { mContext.startActivity(it) } },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .padding(start = 50.dp, end = 50.dp),
                                colors = ButtonDefaults.buttonColors(green),
                                shape = RoundedCornerShape(10.dp)
                            ) {

                                Text(text = "Purchase")

                            }




                }

            }

            Spacer(modifier = Modifier.width(40.dp))
            //card 3
           Row (modifier = Modifier.padding(20.dp)){
               Card(
                   modifier = Modifier
                       .height(160.dp)
                       .width(180.dp)
               ) {


                   Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                       Image(
                           painter = painterResource(id = R.drawable.kgasmini),
                           contentDescription = "home",
                           modifier = Modifier.fillMaxSize(),
                           contentScale = ContentScale.Crop
                       )
                   }
               }
                       Column (modifier = Modifier.padding(10.dp),
                           horizontalAlignment = Alignment.Start){
                           Text(
                               text = "6Kg Kgas gas ",
                               modifier = Modifier.padding(top = 90.dp, start = 10.dp),
                               fontFamily = FontFamily.Serif
                           )

                           Text(
                               text = "ksh 4500 ",
                               modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                               fontFamily = FontFamily.Serif
                           )
                           val mContext = LocalContext.current
                           //STK
                           Button(
                               onClick = {  val simToolKitLaunchIntent =
                                   mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                                   simToolKitLaunchIntent?.let { mContext.startActivity(it) } },
                               modifier = Modifier
                                   .fillMaxWidth()
                                   .height(50.dp)
                                   .padding(start = 50.dp, end = 50.dp),
                               colors = ButtonDefaults.buttonColors(green),
                               shape = RoundedCornerShape(10.dp)
                           ) {

                               Text(text = "Purchase")

                           }

                       }





           }
            Spacer(modifier = Modifier.width(40.dp))
            // Card 4
           Row(modifier = Modifier.padding(20.dp)) {
               Card(
                   modifier = Modifier
                       .height(160.dp)
                       .width(180.dp)
               ) {


                   Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                       Image(
                           painter = painterResource(id = R.drawable.totalmini),
                           contentDescription = "home",
                           modifier = Modifier.fillMaxSize(),
                           contentScale = ContentScale.Crop
                       )
                   }
               }
                           Column (modifier = Modifier.padding(10.dp),
                               horizontalAlignment = Alignment.Start){
                               Text(
                                   text = "6Kg total gas ",
                                   modifier = Modifier.padding(top = 90.dp, start = 10.dp),
                                   fontFamily = FontFamily.Serif
                               )

                               Text(
                                   text = "ksh 4500 ",
                                   modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                                   fontFamily = FontFamily.Serif
                               )
                               val mContext = LocalContext.current
                               //STK
                               Button(
                                   onClick = {  val simToolKitLaunchIntent =
                                       mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                                       simToolKitLaunchIntent?.let { mContext.startActivity(it) } },
                                   modifier = Modifier
                                       .fillMaxWidth()
                                       .height(50.dp)
                                       .padding(start = 50.dp, end = 50.dp),
                                   colors = ButtonDefaults.buttonColors(green),
                                   shape = RoundedCornerShape(10.dp)
                               ) {

                                   Text(text = "Purchase")

                               }


                           }







           }
            Spacer(modifier = Modifier.width(40.dp))
            // Card 5
         Row (modifier = Modifier.padding(20.dp)){
             Card(
                 modifier = Modifier
                     .height(160.dp)
                     .width(180.dp)
             ) {


                 Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                     Image(
                         painter = painterResource(id = R.drawable.afrigas6kg),
                         contentDescription = "home",
                         modifier = Modifier.fillMaxSize(),
                         contentScale = ContentScale.Crop
                     )
                 }
             }
                         Column (modifier = Modifier.padding(10.dp),
                             horizontalAlignment = Alignment.Start){
                             Text(
                                 text = "6Kg Afri gas ",
                                 modifier = Modifier.padding(top = 90.dp, start = 10.dp),
                                 fontFamily = FontFamily.Serif
                             )

                             Text(
                                 text = "ksh 5000 ",
                                 modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                                 fontFamily = FontFamily.Serif
                             )
                             val mContext = LocalContext.current
                             //STK
                             Button(
                                 onClick = {  val simToolKitLaunchIntent =
                                     mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                                     simToolKitLaunchIntent?.let { mContext.startActivity(it) } },
                                 modifier = Modifier
                                     .fillMaxWidth()
                                     .height(50.dp)
                                     .padding(start = 50.dp, end = 50.dp),
                                 colors = ButtonDefaults.buttonColors(green),
                                 shape = RoundedCornerShape(10.dp)
                             ) {

                                 Text(text = "Purchae")

                             }



                         }

         }

        }
        //Row2
        Row(modifier = Modifier
            .padding(40.dp)
            .horizontalScroll(rememberScrollState())) {
            //CARD 1

            Row(modifier = Modifier.padding(20.dp)) {

                Card(
                    modifier = Modifier
                        .height(160.dp)
                        .width(180.dp)
                ) {


                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                        Image(
                            painter = painterResource(id = R.drawable.total13kg),
                            contentDescription = "home",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
                Spacer(modifier = Modifier.width(40.dp))
                Column(
                    modifier = Modifier.padding(10.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "13Kg total gas ",
                        modifier = Modifier.padding(top = 90.dp, start = 20.dp),
                        fontFamily = FontFamily.Serif
                    )

                    Text(
                        text = "ksh 8000 ",
                        modifier = Modifier.padding(top = 10.dp, start = 20.dp),
                        fontFamily = FontFamily.Serif
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    val mContext = LocalContext.current
                    //STK
                    Button(
                        onClick = {  val simToolKitLaunchIntent =
                            mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { mContext.startActivity(it) } },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(start = 50.dp, end = 50.dp),
                        colors = ButtonDefaults.buttonColors(green),
                        shape = RoundedCornerShape(10.dp)
                    ) {

                        Text(text = "Purchase")

                    }


                }
            }

            Spacer(modifier = Modifier.width(40.dp))
            //card2
            Row(modifier = Modifier.padding(20.dp)) {
                Card(
                    modifier = Modifier
                        .height(160.dp)
                        .width(180.dp)
                ) {


                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                        Image(
                            painter = painterResource(id = R.drawable.promini13kg),
                            contentDescription = "home",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                }

                Column(
                    modifier = Modifier.padding(10.dp),
                    horizontalAlignment = Alignment.Start
                ) {

                    Text(
                        text = "13Kg pro gas ",
                        modifier = Modifier.padding(top = 90.dp, start = 10.dp),
                        fontFamily = FontFamily.Serif
                    )

                    Text(
                        text = "ksh 7000 ",
                        modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                        fontFamily = FontFamily.Serif
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    val mContext = LocalContext.current
                    //STK
                    Button(
                        onClick = {  val simToolKitLaunchIntent =
                            mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { mContext.startActivity(it) } },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(start = 50.dp, end = 50.dp),
                        colors = ButtonDefaults.buttonColors(green),
                        shape = RoundedCornerShape(10.dp)
                    ) {

                        Text(text = "Purchase")

                    }

                }

            }
            Spacer(modifier = Modifier.width(40.dp))
            //card 3
            Row(modifier = Modifier.padding(20.dp)) {
                Card(
                    modifier = Modifier
                        .height(180.dp)
                        .width(200.dp)
                ) {


                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                        Image(
                            painter = painterResource(id = R.drawable.seagas13kg),
                            contentDescription = "home",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                }



                Column(
                    modifier = Modifier.padding(10.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Sea gas ",
                        modifier = Modifier.padding(top = 90.dp, start = 10.dp),
                        fontFamily = FontFamily.Serif
                    )

                    Text(
                        text = "ksh 6500 ",
                        modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                        fontFamily = FontFamily.Serif
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    val mContext = LocalContext.current
                    //STK
                    Button(
                        onClick = {  val simToolKitLaunchIntent =
                            mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { mContext.startActivity(it) } },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(start = 50.dp, end = 50.dp),
                        colors = ButtonDefaults.buttonColors(green),
                        shape = RoundedCornerShape(10.dp)
                    ) {

                        Text(text = "Purchase")

                    }

                }


            }
            Spacer(modifier = Modifier.width(40.dp))
            // Card 4
            Row(modifier = Modifier.padding(20.dp)) {
                Card(
                    modifier = Modifier
                        .height(180.dp)
                        .width(200.dp)
                ) {


                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                        Image(
                            painter = painterResource(id = R.drawable.rubis13kg),
                            contentDescription = "home",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                }

                Column(
                    modifier = Modifier.padding(10.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "13Kg rubis gas ",
                        modifier = Modifier.padding(top = 90.dp, start = 10.dp),
                        fontFamily = FontFamily.Serif
                    )

                    Text(
                        text = "ksh 6500 ",
                        modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                        fontFamily = FontFamily.Serif
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    val mContext = LocalContext.current
                    //STK
                    Button(
                        onClick = {  val simToolKitLaunchIntent =
                            mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { mContext.startActivity(it) } },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(start = 50.dp, end = 50.dp),
                        colors = ButtonDefaults.buttonColors(green),
                        shape = RoundedCornerShape(10.dp)
                    ) {

                        Text(text = "Purchase")

                    }


                }


            }

            Spacer(modifier = Modifier.width(40.dp))
            // Card 5
            Row(modifier = Modifier.padding(20.dp)) {
                Card(
                    modifier = Modifier
                        .height(160.dp)
                        .width(180.dp)
                ) {


                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                        Image(
                            painter = painterResource(id = R.drawable.mpishi13kg),
                            contentDescription = "home",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                }


                Column(
                    modifier = Modifier.padding(10.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "13Kg mpishi gas ",
                        modifier = Modifier.padding(top = 90.dp, start = 10.dp),
                        fontFamily = FontFamily.Serif
                    )

                    Text(
                        text = "ksh 7000 ",
                        modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                        fontFamily = FontFamily.Serif
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    val mContext = LocalContext.current
                    //STK
                    Button(
                        onClick = {  val simToolKitLaunchIntent =
                            mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { mContext.startActivity(it) } },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(start = 50.dp, end = 50.dp),
                        colors = ButtonDefaults.buttonColors(green),
                        shape = RoundedCornerShape(10.dp)
                    ) {

                        Text(text = "Purchase")

                    }


                }


            }
            Spacer(modifier = Modifier.width(40.dp))
            // Card 6
            Row(modifier = Modifier.padding(20.dp)) {
                Card(
                    modifier = Modifier
                        .height(160.dp)
                        .width(180.dp)
                ) {


                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                        Image(
                            painter = painterResource(id = R.drawable.afrigas13kg),
                            contentDescription = "home",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                }



                Column(
                    modifier = Modifier.padding(10.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "13Kg Afri gas ",
                        modifier = Modifier.padding(top = 90.dp, start = 10.dp),
                        fontFamily = FontFamily.Serif
                    )

                    Text(
                        text = "ksh 6000 ",
                        modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                        fontFamily = FontFamily.Serif
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    val mContext = LocalContext.current
                    //STK
                    Button(
                        onClick = {  val simToolKitLaunchIntent =
                            mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { mContext.startActivity(it) } },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(start = 50.dp, end = 50.dp),
                        colors = ButtonDefaults.buttonColors(green),
                        shape = RoundedCornerShape(10.dp)
                    ) {

                        Text(text = "Purchase")

                    }


                }


            }
            Spacer(modifier = Modifier.width(40.dp))
            // Card 7
            Row(modifier = Modifier.padding(20.dp)) {
                Card(
                    modifier = Modifier
                        .height(160.dp)
                        .width(180.dp)
                ) {


                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                        Image(
                            painter = painterResource(id = R.drawable.safegas13kg),
                            contentDescription = "home",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                }

                Column(
                    modifier = Modifier.padding(10.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "13Kg Safe gas ",
                        modifier = Modifier.padding(top = 90.dp, start = 10.dp),
                        fontFamily = FontFamily.Serif
                    )

                    Text(
                        text = "ksh 6500 ",
                        modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                        fontFamily = FontFamily.Serif
                            )
                    Spacer(modifier = Modifier.height(10.dp))
                     val mContext = LocalContext.current
                    //STK
                    Button(
                        onClick = {  val simToolKitLaunchIntent =
                            mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { mContext.startActivity(it) } },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(start = 50.dp, end = 50.dp),
                        colors = ButtonDefaults.buttonColors(green),
                        shape = RoundedCornerShape(10.dp)
                    ) {

                        Text(text = "Purchase")

                    }



                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { navController.navigate(ROUT_MOREINFO) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 20.dp, end = 20.dp),
            colors = ButtonDefaults.buttonColors(lightgreen),
            shape = RoundedCornerShape(10.dp)
        ) {

            Text(text = "Know more")

        }
        Spacer(modifier = Modifier.height(40.dp))

        }








    }



@Composable
@Preview(showBackground = true)
fun DetailsScreenPreview(){
    DetailsScreen(rememberNavController())


}