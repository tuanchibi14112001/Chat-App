package com.example.chatapp.data.repository

import com.example.chatapp.utils.Resource
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase

interface AuthRepository {

    val currentUser: FirebaseUser?
    suspend fun login(email: String, pwd: String) : Resource<FirebaseUser>
    suspend fun signup(name: String, email: String, pwd: String) : Resource<FirebaseUser>
    fun logout()
}