package com.example.e_kengash.main.activity.myAppeals.viewModel

import MyAppealsBEntity
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MyViewModelB():ViewModel() {

    private  val blokDb = FirebaseDatabase.getInstance().getReference("BLOK")

    private val _Location = MutableLiveData<List<MyAppealsBEntity>>()
    val blok: LiveData<List<MyAppealsBEntity>>
        get() = _Location

    fun insertLocation(blok: MyAppealsBEntity) {

        blokDb.child("blok").setValue(blok)
            .addOnCompleteListener {
                if(it.isSuccessful)
                {
                    Log.d("sardor", "qo`shildi")
                }else
                {
                    Log.d("sardor", "nimadir bo`ldiii ${it.exception!!.message}")
                }
            }
    }

    fun readLocation(){
        blokDb.addValueEventListener(object : ValueEventListener
        {
            override fun onDataChange(p0: DataSnapshot) {
                if(p0.exists())
                {
                    val items= mutableListOf<MyAppealsBEntity>()
                    p0.children.forEach {
                        val item=it.getValue(MyAppealsBEntity::class.java)
                        item?.let { items.add(it) }
                    }
                    _Location.value = items
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }
}