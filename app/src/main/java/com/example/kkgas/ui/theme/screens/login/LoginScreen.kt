package com.example.kkgas.ui.theme.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkgas.R
import com.example.kkgas.data.AuthViewModel
import com.example.kkgas.navigation.ROUT_SIGNUP
import com.example.kkgas.ui.theme.lightgreen

@Composable

fun LoginScreen(navController: NavController){
    Column (
        modifier = Modifier.fillMaxSize()
            .paint(painterResource(id = R.drawable.greenbackground), contentScale = ContentScale.FillBounds),
        horizontalAlignment = Alignment.CenterHorizontally){

        Spacer(modifier = Modifier.height(10.dp))

        Image(
            painter = painterResource(id = R.drawable.gasicon2),
            contentDescription ="home",
            modifier = Modifier
                .size(200.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Welcome Back",
            fontSize = 40.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Cyan
        )

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "You already have an account please enter your credentials",
            fontSize = 18.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Green,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center

        )
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = email,
            onValueChange ={ email = it},
            label = { Text(text = "Email Address :", fontWeight = FontWeight.Bold, color = Color.White) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "person", tint = lightgreen) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            shape = RoundedCornerShape(20.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = password,
            onValueChange ={ password = it},
            label = { Text(text = "Password :", fontWeight = FontWeight.Bold, color = Color.White) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "person", tint = lightgreen) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            shape = RoundedCornerShape(20.dp),
        )
        val context = LocalContext.current
        val authViewModel = AuthViewModel(navController, context)
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { authViewModel.login(email, password) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 20.dp, end = 20.dp),
            colors = ButtonDefaults.buttonColors(lightgreen),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "Login as buyer")

        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Do not have an account ? Register",
            fontSize = 18.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Cyan,
            modifier = Modifier.fillMaxWidth().clickable {navController.navigate(ROUT_SIGNUP) },
            textAlign = TextAlign.Center

        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { authViewModel.adminlogin(email, password) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 20.dp, end = 20.dp),
            colors = ButtonDefaults.buttonColors(lightgreen),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "Login as an admin")

        }



    }

}




@Composable
@Preview(showBackground = true)
fun LoginScreenPreview(){
    LoginScreen(rememberNavController())


}