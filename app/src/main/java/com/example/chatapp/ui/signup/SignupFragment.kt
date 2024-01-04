package com.example.chatapp.ui.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chatapp.R
import com.example.chatapp.databinding.FragmentSignupBinding
import com.example.chatapp.ui.base.BaseFragment


class SignupFragment : BaseFragment<FragmentSignupBinding>() {
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentSignupBinding.inflate(inflater, container, false)

    override fun prepareView(savedInstanceState: Bundle?) {
    }

}