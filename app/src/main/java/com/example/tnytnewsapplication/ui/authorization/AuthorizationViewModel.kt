package com.example.tnytnewsapplication.ui.authorization

import android.app.Activity
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthorizationViewModel constructor(private val auth: FirebaseAuth) : ViewModel() {

    var user: FirebaseUser? = null

    lateinit var toast: (isSuc: Boolean) -> Unit


    fun registration(email: String, password: String, activity: Activity) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    user = auth.currentUser
                    toast(true)
                } else {
                    toast(false)

                }
            }
    }

    fun signIn(email: String, password: String, activity: Activity) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    user = auth.currentUser
                    toast(true)
                } else {
                    toast(false)

                }
            }
    }

    fun validateEmail(email: String): Boolean {
        if (email.isEmpty()) {
            return false
        } else {
            if (email.matches(
                    Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")
                )
            ) {
                return true
            }
        }
        return false
    }

    fun validatePassowrd(password: String, passwordConfirmation: String): Boolean =
        password.isNotEmpty() && passwordConfirmation.isNotEmpty() &&
                password.matches(Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=])(?=\\\\S+\$).{4,}\$")) && password == passwordConfirmation && password.length >= 8
}


