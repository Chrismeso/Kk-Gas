package com.example.kkgas.ui.theme.screens.gas

import android.annotation.SuppressLint
import android.content.Intent
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.kkgas.data.GasViewModel
import com.example.kkgas.models.Gas
import com.example.kkgas.navigation.ROUT_ADDGAS
import com.example.kkgas.ui.theme.home
import com.example.kkgas.ui.theme.screens.more.info.BottomNavItem


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ViewGasScreenBuyer(navController:NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize().background(home)) {

        var context = LocalContext.current
        var productRepository = GasViewModel(navController, context)


        val emptyProductState = remember { mutableStateOf(Gas("","","","","","")) }
        var emptyProductsListState = remember { mutableStateListOf<Gas>() }

        var products = productRepository.allProducts(emptyProductState, emptyProductsListState)


        var selected by remember { mutableIntStateOf(0) }
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Available Products",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        fontFamily = FontFamily.SansSerif) })

            },


            //Content Section
            content = @Composable{
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Our products",
                        fontSize = 30.sp,
                        fontFamily = FontFamily.Cursive,
                        color = Color.Red)

                    Spacer(modifier = Modifier.height(20.dp))

                    LazyColumn(){
                        items(products){
                            ProductItem1(
                                name = it.name,
                                quantity = it.quantity,
                                price = it.price,
                                phone = it.phone,
                                id = it.id,
                                navController = navController,
                                productRepository = productRepository,
                                productImage = it.imageUrl
                            )
                        }
                    }
                }

            }

        )
    }
}







@Composable
fun ProductItem1(name:String, quantity:String, price:String, phone:String, id:String,
                 navController: NavController,
                 productRepository:GasViewModel, productImage:String) {

    //1 item
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(15.dp)) {
        Card (modifier = Modifier
            .height(250.dp)
            .width(370.dp)
        ) {
            Box (modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center) {
                Image(
                    painter = rememberAsyncImagePainter(productImage),
                    contentDescription = "null",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )


                Row (modifier = Modifier.align(Alignment.BottomStart)) {
                    Column (modifier = Modifier
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black
                                )
                            )
                        )
                        .fillMaxWidth()
                        .padding(7.dp)) {
                        //details

                        Text(text = "Name : $name",
                            fontSize = 27.sp,
                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily.Default,
                            color = Color.White
                        )


                        Text(text = "Quantity : $quantity",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily.Default,
                            color = Color.White
                        )

                        Spacer(modifier = Modifier.height(5.dp))

                        Text(text = "Price : Ksh.$price",
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Default,
                            color = Color.White
                        )

                        val mContext = LocalContext.current

                        //button row
                        Row (
                            modifier = Modifier
                                .padding(bottom = 10.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                        ){
                            OutlinedButton(
                                onClick = {
                                    val callIntent= Intent(Intent.ACTION_DIAL)
                                    callIntent.data="tel:$phone".toUri()
                                    mContext.startActivity(callIntent)
                                },
                                shape = RoundedCornerShape(8.dp),

                                ) {
                                Row {
                                    Icon(
                                        imageVector = Icons.Default.Call,
                                        contentDescription = "")
                                    Spacer(modifier = Modifier.width(3.dp))
                                    Text(
                                        text = "Call"
                                    )
                                }
                            }


                        }
                        //end of button row


                        //end details

                    }
                }

            }
        }
        //end 1 item

    }
}

@Composable
@Preview(showBackground = true)
fun ViewGasScreenBuyerPreview(){

    ViewGasScreenBuyer(navController = rememberNavController())

}
