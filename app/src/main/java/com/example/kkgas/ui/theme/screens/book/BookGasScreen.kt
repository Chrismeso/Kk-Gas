package com.example.kkgas.ui.theme.screens.book

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkgas.R
import com.example.kkgas.data.BookViewModel
import com.example.kkgas.ui.theme.Brown
import com.example.kkgas.ui.theme.green
import java.util.Calendar


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BookGasScreen(navController:NavController){
    Column(
        modifier = Modifier
            .fillMaxSize().background(green).padding(top = 30.dp).verticalScroll(rememberScrollState())
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.bookingicon),
            contentDescription ="home",
            modifier = Modifier
                .size(90.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "Book your Gas here!",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif)






        var Name by remember { mutableStateOf("") }
        var gas by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var location by remember { mutableStateOf("") }
        val context = LocalContext.current



        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = Name,
            onValueChange = { Name = it },
            label = { Text(text = "Buyer Full name  ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            trailingIcon =  { Icon(imageVector = Icons.Default.Person, contentDescription = "person", tint = Brown) },
            shape = RoundedCornerShape(30.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))


        OutlinedTextField(
            value = gas,
            onValueChange = { gas = it },
            label = { Text(text = "Input gas ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            trailingIcon =  { Icon(imageVector = Icons.Default.Check, contentDescription = "", tint = Brown) },
            shape = RoundedCornerShape(30.dp),

        )



        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email Address ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            trailingIcon =  { Icon(imageVector = Icons.Default.Email, contentDescription = "person", tint = Brown) },
            shape = RoundedCornerShape(30.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = location,
            onValueChange = { location = it },
            label = { Text(text = "Address ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            trailingIcon =  { Icon(imageVector = Icons.Default.LocationOn, contentDescription = "person", tint = Brown) },
            shape = RoundedCornerShape(30.dp)
        )


        //DateField

        var selectedDate by remember { mutableStateOf<String?>(null) }
        var showDatePicker by remember { mutableStateOf(false) }



        Row(modifier = Modifier.padding(start = 20.dp, end = 20.dp)){

            Button(onClick = {
                val calendar = Calendar.getInstance()
                val year = calendar.get(Calendar.YEAR)
                val month = calendar.get(Calendar.MONTH)
                val day = calendar.get(Calendar.DAY_OF_MONTH)

                DatePickerDialog(

                    context,
                    { _, selectedYear, selectedMonth, selectedDay ->
                        selectedDate = "${selectedDay}/${selectedMonth + 1}/${selectedYear}"
                    },
                    year,
                    month,
                    day
                ).show()
            },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Color.Blue),
                modifier = Modifier
                    .height(65.dp)
                    .padding(top = 10.dp)) {
                Text(text = "Delivery date")
            }
            Spacer(modifier = Modifier.width(20.dp))

            OutlinedTextField(
                value = selectedDate ?: "",
                onValueChange = { /* No-op, as we handle value through date picker */ },
                label = { Text("Select Date") },
                readOnly = true,  // Makes the text field non-editable
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .width(250.dp),
                trailingIcon = {
                    Text(text = "📅")  // Icon to indicate date picker
                },
                singleLine = true
            )


        }

        //End of a datefield




        Spacer(modifier = Modifier.height(20.dp))




        //---------------------IMAGE PICKER START-----------------------------------//

        var modifier = Modifier
        ImagePicker(modifier,context, navController, Name.trim(),gas.trim(), email.trim())

        //---------------------IMAGE PICKER END-----------------------------------//






    }
}


@Composable
fun ImagePicker(modifier: Modifier = Modifier, context: Context, navController: NavController, name:String, title:String, email:String) {
    var hasImage by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            hasImage = uri != null
            imageUri = uri
        }
    )

    Column(modifier = modifier,) {
        if (hasImage && imageUri != null) {
            val bitmap = MediaStore.Images.Media.
            getBitmap(context.contentResolver,imageUri)
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                Image(bitmap = bitmap.asImageBitmap(),
                    contentDescription = "Selected image",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop)
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp), horizontalAlignment = Alignment.CenterHorizontally,) {
            Button(
                onClick = {
                    imagePicker.launch("image/*")
                },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(Color.Black)
            ) {
                Text(
                    text = "Upload Photo"
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                //-----------WRITE THE UPLOAD LOGIC HERE---------------//
                var accountRepository = BookViewModel(navController,context)
                accountRepository.addAccount(name, title, email,imageUri!!)


            },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(Color.Black)) {
                Text(text = "Book Gas")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun BookGasScreenPreview(){
    BookGasScreen(navController =  rememberNavController())

}