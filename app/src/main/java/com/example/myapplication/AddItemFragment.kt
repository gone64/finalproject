package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage
import com.squareup.picasso.Picasso

class AddItemFragment : Fragment(R.layout.fragment_add_item) {
    private lateinit var additem: TextView
    private lateinit var price: EditText
    private lateinit var namee: EditText
    private lateinit var desc: EditText
    private lateinit var location: EditText
    private lateinit var dbRef: DatabaseReference
    private lateinit var number : EditText
    private lateinit var url : EditText
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        price = view.findViewById(R.id.productprice)
        location = view.findViewById(R.id.productlocation)
        namee = view.findViewById(R.id.productname)
        additem = view.findViewById(R.id.additem)
        desc = view.findViewById(R.id.productdesc)
        number = view.findViewById(R.id.productcondition)

        url = view.findViewById(R.id.add_url)


        dbRef = FirebaseDatabase.getInstance().getReference("Products")


        val button = view.findViewById<TextView>(R.id.button)
        button.setOnClickListener {
            startActivity(Intent(this.context, MainActivity5::class.java))

        }
        additem.setOnClickListener{
            saveItemdata()
        }


    }






    private fun saveItemdata() {
        val proPrice = price.text.toString()
        val proLoc = location.text.toString()
        val proName = namee.text.toString()
        val proDesc = desc.text.toString()
        val numberr = number.text.toString()
        val proUrl = url.text.toString()






        if (proName.isEmpty()) {
            namee.error = "Please Enter Name"
        }
        if (proPrice.isEmpty()) {
            price.error = "Please Enter Price"
        }
        if (proLoc.isEmpty()) {
            location.error = "Please Enter Location"
        }

        if (proDesc.isEmpty()) {
            desc.error = "Please Enter Description"
        }
        if (numberr.isEmpty()) {
            number.error = "Please Enter Condition"
        }
        if (proUrl.isEmpty() ) {
            url.error = "Please Enter Image Link"
        }










        val proId = dbRef.push().key!!
        val product = ProductModel(proId, proName, proPrice, proLoc,  proDesc,numberr,proUrl)

        if (proName.isNotEmpty() && numberr.isNotEmpty() && proDesc.isNotEmpty() && proPrice.isNotEmpty() && proLoc.isNotEmpty() && proUrl.isNotEmpty() && numberr.length == 9 && numberr.startsWith("5") ){dbRef.child(proId).setValue(product).addOnCompleteListener {
            price.text.clear()
            location.text.clear()
            desc.text.clear()
            namee.text.clear()
            number.text.clear()
            url.text.clear()
        }.addOnFailureListener {

        }}else if((numberr.startsWith('5') == false)){
            number.error = "Number Must Start With Number 5"
        }else if(numberr.length!=9){
            number.error = "Number Length Must Be 9 Symbol"
        }else{
            Toast.makeText(context, "Fill All Fields", Toast.LENGTH_SHORT).show()
        }


    }
}


