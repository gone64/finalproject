package com.example.myapplication

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import com.bumptech.glide.disklrucache.DiskLruCache.Value
import com.example.myapplication.databinding.ActivityMain3Binding
import com.example.myapplication.databinding.ActivityMain5Binding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserInfo
import com.google.firebase.database.*
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.fragment_items.*


class ItemsFragment() : Fragment(R.layout.fragment_items) {
    private lateinit var mail : TextView




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mail = view.findViewById(R.id.userMail)
        mail.text = FirebaseAuth.getInstance().currentUser?.email
    }
}


