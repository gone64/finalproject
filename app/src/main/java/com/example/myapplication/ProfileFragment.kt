package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class ProfileFragment() : Fragment(R.layout.fragment_items) {
    private lateinit var mail : TextView

    private lateinit var auth: FirebaseAuth




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mail = view.findViewById(R.id.userMail)
        auth = Firebase.auth
        mail.text = FirebaseAuth.getInstance().currentUser?.email

    }
}


