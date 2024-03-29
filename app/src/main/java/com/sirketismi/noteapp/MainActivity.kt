package com.sirketismi.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Firebase.firestore

        var note = hashMapOf(
            "name" to "2323",
            "title" to "2323",
            "detail" to "3434",
        )

        val noteCollection = db.collection("NoteApp")
            noteCollection.add(note)
            .addOnSuccessListener {

            }
            .addOnFailureListener{

            }
        noteCollection
            .get()
            .addOnSuccessListener {

            }
            .addOnFailureListener{

            }
    }
}