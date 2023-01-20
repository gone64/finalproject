package com.example.myapplication

import android.content.Intent
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

class SignInActivity : AppCompatActivity() {


    lateinit var sgn_mail : EditText
    lateinit var sgn_pswr : EditText
    lateinit var sgn_sgnin : TextView
    lateinit var sgn_sgnup : TextView
    lateinit var sgn_frgtpswr : TextView
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        val firebase : DatabaseReference = FirebaseDatabase.getInstance().getReference()
        sgn_mail = findViewById(R.id.sgn_enteremail)


        sgn_pswr = findViewById(R.id.sgn_enterpswr)
        sgn_sgnin = findViewById(R.id.sgn_sgnin)
        sgn_sgnup = findViewById(R.id.sgn_sgnup)
        sgn_frgtpswr = findViewById(R.id.sgn_frgtpswr)
        auth = Firebase.auth



        sgn_sgnup.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))

        }
        sgn_sgnin.setOnClickListener {
            login()
        }
        sgn_frgtpswr.setOnClickListener {
            startActivity(Intent(this,ForgotPasswordActivity::class.java))
        }


    }
    private fun login(){
        val email = sgn_mail.text.toString()
        val pass = sgn_pswr.text.toString()

        if (email.isEmpty() || pass.isEmpty()){
            Toast.makeText(this, "Fill All Fields", Toast.LENGTH_SHORT).show()
        }else{
        auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {
            if (it.isSuccessful){
                val intent = Intent(this, FragmentActivity::class.java)
                intent.putExtra("str",email)
                intent.putExtra("rtr",pass)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "login Failed", Toast.LENGTH_SHORT).show()
            }
        }
        }
    }

}