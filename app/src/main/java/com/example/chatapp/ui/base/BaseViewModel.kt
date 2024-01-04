package com.example.chatapp.ui.base

import androidx.lifecycle.ViewModel

/**
 * Base class for ViewModel
 */
abstract class BaseViewModel : ViewModel() {
    override fun onCleared() {
        super.onCleared()
    }
}