package com.example.kkgas.ui.theme.screens.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkgas.R
import com.example.kkgas.data.AuthViewModel
import com.example.kkgas.navigation.ROUT_LOGIN
import com.example.kkgas.ui.theme.lightblue


@Composable

fun SignupScreen(navController: NavController){
    Column (modifier = Modifier
        .fillMaxSize()
        .background(lightblue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ){

        Spacer(modifier = Modifier.height(40.dp))

        Image(
            painter = painterResource(id = R.drawable.loginsignupicon),
            contentDescription ="home",
            modifier = Modifier
                .size(100.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(10.dp))

       Card (modifier = Modifier
           .fillMaxWidth()
           .height(700.dp)
           .width(500.dp)
           .padding(40.dp),
           colors = CardDefaults.cardColors(Color.White)){
           Text(
               text = "Welcome to Kk Gas",
               fontSize = 40.sp,
               fontFamily = FontFamily.Cursive,
               color = Color.Black

           )
           var name by remember { mutableStateOf("") }
           var email by remember { mutableStateOf("") }
           var password by remember { mutableStateOf("") }
           var confpassword by remember { mutableStateOf("") }

           Spacer(modifier = Modifier.height(10.dp))


           OutlinedTextField(
               value = name,
               onValueChange ={ name = it},
               label = { Text(text = "Fullname :", fontWeight = FontWeight.Bold, color = Color.Black)},
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(start = 20.dp, end = 20.dp),
               leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "person", tint = Color.Black)},
               keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
           )
           Spacer(modifier = Modifier.height(10.dp))

           OutlinedTextField(
               value = email,
               onValueChange ={ email = it},
               label = { Text(text = "Email Address :", fontWeight = FontWeight.Bold, color = Color.Black)},
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(start = 20.dp, end = 20.dp),
               leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "person", tint = Color.Black)},
               keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
           )
           Spacer(modifier = Modifier.height(10.dp))

           var passwordVisible by remember { mutableStateOf(false) }
           // Function to determine visual transformation based on visibility
           val visualTransformation: VisualTransformation =
               if (passwordVisible) VisualTransformation.None
               else PasswordVisualTransformation()
           // Function to switch the password visibility
           fun togglePasswordVisibility() {
               passwordVisible = !passwordVisible
           }

           OutlinedTextField(
               value = password,
               onValueChange = {password = it},
               label = { Text(text = "Password", fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold)},
               keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
               leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "", tint = Color.Black) },
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(start = 20.dp, end = 20.dp),
               shape = RoundedCornerShape(5.dp),
               visualTransformation = visualTransformation,
               trailingIcon = {
                   val icon = if (passwordVisible) {
                       //Download a password show icon
                       painterResource(id = R.drawable.visibility)
                   } else {
                       //Download a password hide icon
                       painterResource(id = R.drawable.visibility)
                   }
                   IconButton(onClick = { togglePasswordVisibility() }) {
                       Icon(painter = icon, contentDescription = null)
                   }
               }

           )
           Spacer(modifier = Modifier.height(30.dp))


           OutlinedTextField(
               value = confpassword,
               onValueChange ={ confpassword = it},
               label = { Text(text = "Confirm password :", fontWeight = FontWeight.Bold, color = Color.Black)},
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(start = 20.dp, end = 20.dp),
               leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "person", tint = Color.Black)},
               keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
               visualTransformation = visualTransformation,
                       trailingIcon = {
                   val icon = if (passwordVisible) {
                       //Download a password show icon
                       painterResource(id = R.drawable.visibility)
                   } else {
                       //Download a password hide icon
                       painterResource(id = R.drawable.visibility)
                   }
                   IconButton(onClick = { togglePasswordVisibility() }) {
                       Icon(painter = icon, contentDescription = null)
                   }
               }
           )
           val context = LocalContext.current
           val authViewModel = AuthViewModel(navController, context)


           Spacer(modifier = Modifier.height(30.dp))

           Button(
               onClick = {
                   authViewModel.signup(name, email, password,confpassword)
               },
               modifier = Modifier
                   .fillMaxWidth()
                   .height(40.dp)
                   .padding(start = 20.dp, end = 20.dp),
               colors = ButtonDefaults.buttonColors(Color.Black),
               shape = RoundedCornerShape(10.dp)
           ) {
               Text(text = "Sign up")

           }
           Spacer(modifier = Modifier.height(30.dp))

           Button(
               onClick = {
                   navController.navigate(ROUT_LOGIN)
               },
               modifier = Modifier
                   .fillMaxWidth()
                   .height(40.dp)
                   .padding(start = 20.dp, end = 20.dp),
               colors = ButtonDefaults.buttonColors(Color.Black),
               shape = RoundedCornerShape(10.dp)
           ) {
               Text(text = "Login")
           }
           Spacer(modifier = Modifier.height(80.dp))








       }






    }


}




@Composable
@Preview(showBackground = true)
fun SignupScreenPreview(){
    SignupScreen(rememberNavController())


}