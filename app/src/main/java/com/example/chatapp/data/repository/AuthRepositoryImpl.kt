package com.example.chatapp.data.repository

import com.example.chatapp.utils.Resource
import com.example.chatapp.utils.await
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : AuthRepository {

    override val currentUser: FirebaseUser?
        get() = firebaseAuth.currentUser

    override suspend fun login(email: String, pwd: String): Resource<FirebaseUser> {
        return try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, pwd).await()
            Resource.success(result.user)
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.error(e.toString())
        }
    }

    override suspend fun signup(name: String, email: String, pwd: String): Resource<FirebaseUser> {
        return try {
            val result = firebaseAuth.createUserWithEmailAndPassword(email, pwd).await()
            result?.user?.updateProfile(UserProfileChangeRequest.Builder().setDisplayName(name).build())?.await()
            Resource.success(result.user)
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.error(e.toString())
        }
    }

    override fun logout() {
        firebaseAuth.signOut()
    }
}