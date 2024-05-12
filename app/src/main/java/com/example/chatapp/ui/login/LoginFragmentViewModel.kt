package com.example.chatapp.ui.login

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
class LoginFragmentViewModel @Inject constructor(private val repository: AuthRepository) : BaseViewModel() {

    private val _loginFlow =  MutableLiveData<Resource<FirebaseUser>>()
    val loginFlow : LiveData<Resource<FirebaseUser>> = _loginFlow

    fun loginUser(email: String, pwd: String) = viewModelScope.launch {
        _loginFlow.value = Resource.loading()
        val result = repository.login(email,pwd)
        _loginFlow.value = result
    }

}