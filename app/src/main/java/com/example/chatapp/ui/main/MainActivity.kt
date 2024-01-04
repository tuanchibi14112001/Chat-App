package com.example.chatapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import com.example.chatapp.R
import com.example.chatapp.databinding.ActivityMainBinding
import com.example.chatapp.ui.base.BaseActivity


class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getViewBinding() =  ActivityMainBinding.inflate(layoutInflater)
    override fun prepareView(savedInstanceState: Bundle?) {
    }

}