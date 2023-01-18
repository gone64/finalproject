package com.example.myapplication

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class MainActivity2 : AppCompatActivity() {
    lateinit var crt_mail : EditText
    lateinit var crt_rptmail : EditText
    lateinit var crt_pswr : EditText
    lateinit var crt_rptpswr : EditText
    lateinit var crt_sgnup : TextView
    lateinit var crt_name : EditText
    lateinit var dbRef : DatabaseReference
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        crt_mail = findViewById(R.id.crt_enteremail)
        crt_rptmail = findViewById(R.id.crt_rptemail)
        crt_pswr = findViewById(R.id.crt_enterpsw)
        crt_rptpswr = findViewById(R.id.crt_rptpswr)
        crt_sgnup = findViewById(R.id.crt_sgnup)
        auth = Firebase.auth
        crt_name = findViewById(R.id.crt_name)
        dbRef = FirebaseDatabase.getInstance().getReference("Users")
        FirebaseAuth.getInstance().currentUser?.displayName.apply { crt_name }


        crt_sgnup.setOnClickListener {
            signUpUser()

        }
    }
    private fun signUpUser(){
        val userMail = crt_mail.text.toString()
        val rptemail = crt_rptmail.text.toString()
        val userPass = crt_pswr.text.toString()
        val rptpass = crt_rptpswr.text.toString()
        val userName = crt_name.text.toString()

        if (userMail.isEmpty() || rptemail.isEmpty() || userPass.isEmpty() || rptpass.isEmpty() || userName.isEmpty() ){
            Toast.makeText(this, "Fill Fields", Toast.LENGTH_SHORT).show()
            return
        }
        if (userMail != rptemail){
            Toast.makeText(this, "Mails Do Not Match", Toast.LENGTH_SHORT).show()
            return
        }
        if (userPass != rptpass){
            Toast.makeText(this, "Passwords Do Not Match", Toast.LENGTH_SHORT).show()
            return
        }

        if (userMail.contains("@") && userMail.isNotEmpty() ) {
            auth.createUserWithEmailAndPassword(userMail, userPass,).addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Successfully Signed Up", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this, "Signed Up Failed!", Toast.LENGTH_SHORT).show()
                }
            }

        }else{
            Toast.makeText(this, "Check Mail Field", Toast.LENGTH_SHORT).show()
        }
        val userId = dbRef.push().key!!
        val user = UserModel(userId, userMail,userPass,userName)
        dbRef.child(userId).setValue(user).addOnCompleteListener {
            crt_name.text.clear()
            crt_pswr.text.clear()
            crt_mail.text.clear()
            crt_rptpswr.text.clear()
            crt_rptmail.text.clear()
        }.addOnFailureListener {

        }


    }
}