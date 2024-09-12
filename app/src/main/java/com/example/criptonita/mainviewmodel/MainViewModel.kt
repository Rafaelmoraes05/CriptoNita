package com.example.criptonita.mainviewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.criptonita.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainViewModel : ViewModel() {

    private val _user = mutableStateOf (User("", ""))
    val user : User
        get() = _user.value

    private var _loggedIn = mutableStateOf(false)
    val loggedIn : Boolean
        get() = _loggedIn.value
    private val listener = FirebaseAuth.AuthStateListener {
            firebaseAuth ->
        _loggedIn.value = firebaseAuth.currentUser != null
    }
    init {
        listener.onAuthStateChanged(Firebase.auth)
        Firebase.auth.addAuthStateListener(listener)
    }
    override fun onCleared() {
        Firebase.auth.removeAuthStateListener(listener)
    }
}