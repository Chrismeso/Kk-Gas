package com.example.kkgas.ui.theme.screens.book

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.kkgas.data.BookViewModel
import com.example.kkgas.models.Book
import com.example.kkgas.ui.theme.home

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ViewBookedGascreen(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize().background(home),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var accountRepository = BookViewModel(navController, context)


        val emptyAccountState = remember { mutableStateOf(Book("","","","","")) }
        var emptyAccountsListState = remember { mutableStateListOf<Book>() }

        var buyer = accountRepository.ViewBookedGas(emptyAccountState, emptyAccountsListState)



        Spacer(modifier = Modifier.height(50.dp))


        Text(
            text = "Booked Gas",
            fontSize = 25.sp,
            fontFamily = FontFamily.Serif
        )


        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(){
            items(buyer){
                Bookings(
                    name = it.name,
                    gas = it. gas,
                    email = it.email,
                    id = it.id,
                    navController = navController,
                    accountRepository = accountRepository,
                    accountImage = it.imageUrl
                )
            }
        }

    }
}







@Composable
fun Bookings(name:String, gas:String, email:String, id:String,
                navController:NavController,
                accountRepository:BookViewModel, accountImage:String) {

    //1 item

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(15.dp)) {
        Card (modifier = Modifier
            .height(200.dp)
            .width(370.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = rememberAsyncImagePainter(accountImage),
                    contentDescription = "null",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

            }
        }
        Text(text ="Account Name : $name",
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Default,
            color = Color.Black
        )


        Text(text = "Input gas : $gas",
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.Default,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(text = "Email : $email",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Default,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(5.dp))

        Row {

            Button(onClick = { accountRepository.updateAccount(id)},
                shape = RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp),
                colors = ButtonDefaults.buttonColors(Color.Green),) {
                Row {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "", tint = Color.White)
                    Spacer(modifier = Modifier.height(5.dp))

                    Text(text = "Update")

                }
            }


            Spacer(modifier = Modifier.width(5.dp))

            Button(onClick = { accountRepository.deleteAccount(id)},
                shape = RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp),
                colors = ButtonDefaults.buttonColors(Color.Red),) {
                Row {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "", tint = Color.White)
                    Spacer(modifier = Modifier.height(5.dp))

                    Text(text = "Delete")

                }
            }


        }
        Spacer(modifier = Modifier.height(5.dp))


        Divider()








        //end 1 item

    }





}



@Composable
@Preview(showBackground = true)
fun ViewAccountScreenPreview(){

    ViewBookedGascreen(navController = rememberNavController())

}