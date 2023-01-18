package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.databinding.ActivityMain5Binding
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main5.*

class MainActivity5 : AppCompatActivity() {
    private lateinit var binding: ActivityMain5Binding
    private lateinit var dataList: ArrayList<DataClass>
    private lateinit var adapter: MyAdapter
    var databaseReference: DatabaseReference? = null
    var eventListener:ValueEventListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val gridLayoutManager = GridLayoutManager(this@MainActivity5,1)
        binding.recycler1.layoutManager = gridLayoutManager

        dataList = ArrayList()
        adapter = MyAdapter(this@MainActivity5,dataList)
        binding.recycler1.adapter = adapter
        recycler1.setHasFixedSize(true)
        databaseReference = FirebaseDatabase.getInstance().getReference("Products")

        eventListener = databaseReference!!.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                dataList.clear()
                for (itemSnapshot in snapshot.children){
                    val dataClass = itemSnapshot.getValue(DataClass::class.java)
                    if (dataClass != null){
                        dataList.add(dataClass)
                    }

                }
                adapter.notifyDataSetChanged()

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}