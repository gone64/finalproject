package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var r_email : EditText
    private lateinit var r_reset : TextView
    private lateinit var auth : FirebaseAuth
    private lateinit var r_bck : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset)
        r_email = findViewById(R.id.r_mail)
        r_reset = findViewById(R.id.r_reset)
        r_bck = findViewById(R.id.r_bck)
        r_reset.setOnClickListener {
            val mail = r_email.text.toString()
            auth = Firebase.auth
            if (mail.isEmpty() ){
                return@setOnClickListener
            }
            auth.sendPasswordResetEmail(mail).addOnCompleteListener {
                if(it.isSuccessful){
                    r_email.text.clear()
                    Toast.makeText(this, "Check Your Email", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }

            }

        }
        r_bck.setOnClickListener {
            startActivity(Intent(this,SignInActivity::class.java))
        }


    }

}