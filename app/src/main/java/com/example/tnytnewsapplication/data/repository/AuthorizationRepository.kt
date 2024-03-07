package com.example.tnytnewsapplication.data.repository

import android.app.Activity
import com.google.firebase.auth.FirebaseAuth

class AuthorizationRepository constructor(val auth: FirebaseAuth) {
    fun registration(password: String, email: String, context: Activity) : Boolean{
        var tf = false
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(context) { task ->
                if (task.isSuccessful) {
                    tf = true
                } else {
                    tf = false
                }
            }
        return tf
    }
}