package com.example.chatapp.ui.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.chatapp.data.repository.AuthRepository
import com.example.chatapp.ui.base.BaseViewModel
import com.example.chatapp.utils.Resource
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupFragmentViewModel @Inject constructor(private val repository: AuthRepository) :
    BaseViewModel() {

    private val _signupFlow = MutableLiveData<Resource<FirebaseUser>>()
    val signupFlow : LiveData<Resource<FirebaseUser>> = _signupFlow

    fun signupUser(name: String , email: String, pwd: String) = viewModelScope.launch {
        _signupFlow.value = Resource.loading()
        val result = repository.signup(name, email,pwd)
        _signupFlow.value = result
    }
}