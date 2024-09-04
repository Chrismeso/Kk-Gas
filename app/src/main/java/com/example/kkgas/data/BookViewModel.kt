package com.example.kkgas.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavController
import com.example.kkgas.models.Book
import com.example.kkgas.navigation.ROUT_BOOKGAS
import com.example.kkgas.navigation.ROUT_LOGIN
import com.example.kkgas.navigation.ROUT_VIEWBOOKEDGAS
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage


class BookViewModel(var navController: NavController, var context: Context) {
    var authViewModel:AuthViewModel
    var progress: ProgressDialog
    init {
        authViewModel = AuthViewModel(navController, context)
        if (!authViewModel.isLoggedIn()){
            navController.navigate(ROUT_LOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }

    fun addAccount(name:String, email:String, gas:String, filePath: Uri){
        val accountId = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
            .child("Books/$accountId")
        progress.show()
        storageRef.putFile(filePath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()
                    var account = Book(name,gas,email,imageUrl,accountId)
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Books/$accountId")
                    databaseRef.setValue(account).addOnCompleteListener {
                        if (it.isSuccessful){
                            navController.navigate(ROUT_BOOKGAS)
                            Toast.makeText(this.context, "Successfully created an account", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }else{
                Toast.makeText(this.context, "Upload error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun ViewBookedGas(account: MutableState<Book>, accounts: SnapshotStateList<Book>):SnapshotStateList<Book>{
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Books")
        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                accounts.clear()
                for (snap in snapshot.children){
                    var retrievedAccount = snap.getValue(Book::class.java)
                    account.value = retrievedAccount!!
                    accounts.add(retrievedAccount)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return accounts
    }

    fun updateAccount(accountId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Account/$accountId")
        ref.removeValue()
        navController.navigate(ROUT_BOOKGAS)
    }


    fun deleteAccount(accountId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Accounts/$accountId")
        ref.removeValue()
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }
}