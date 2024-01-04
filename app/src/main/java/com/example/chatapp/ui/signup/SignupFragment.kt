package com.example.chatapp.ui.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.chatapp.R
import com.example.chatapp.databinding.FragmentSignupBinding
import com.example.chatapp.ui.base.BaseFragment
import com.example.chatapp.ui.login.LoginFragmentViewModel
import com.example.chatapp.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignupFragment : BaseFragment<FragmentSignupBinding>() {

    private val viewModel: SignupFragmentViewModel by viewModels()
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentSignupBinding.inflate(inflater, container, false)

    override fun prepareView(savedInstanceState: Bundle?) {
        binding.btnSignupSubmit.setOnClickListener{
            val name = binding.editNameInput.text.toString().trim()
            val email = binding.editMailInput.text.toString().trim()
            val pwd = binding.editPw.text.toString().trim()
            viewModel.signupUser(name,email,pwd)
        }
        observeModel()
    }

    private fun observeModel() {
        viewModel.signupFlow.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
                    hideLoading()
                }
                Status.ERROR -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                    hideLoading()
                }
                Status.LOADING -> {
                    showLoading()
                }
            }
        }
    }

}