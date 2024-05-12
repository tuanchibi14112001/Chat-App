package com.example.chatapp.ui.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.chatapp.R
import com.example.chatapp.databinding.FragmentLoginBinding
import com.example.chatapp.ui.base.BaseFragment
import com.example.chatapp.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    private val viewModel: LoginFragmentViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLoginBinding.inflate(inflater, container, false)


    /**
     * prepareView : xuwr lys
     * savedInstanceState : jshdfj
     */
    override fun prepareView(savedInstanceState: Bundle?) {
        // xuwr lys click
        binding.btnSignup.setOnClickListener {
//            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)

        }
        checkEnableSubmitBtn()
        observeModel()
    }

    private fun checkEnableSubmitBtn() {
        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                checkEnableRequire()
            }

            override fun afterTextChanged(s: Editable?) {
            }
        }
        binding.editMailInput.addTextChangedListener(textWatcher)
        binding.editPw.addTextChangedListener(textWatcher)
    }

    private fun checkEnableRequire() {
        val email = binding.editMailInput.text.toString().trim()
        val pwd = binding.editPw.text.toString().trim()
        if (email.isNotEmpty() && pwd.isNotEmpty()) {
            binding.btnLoginSubmit.isEnabled = true
            binding.btnLoginSubmit.setBackgroundColor(resources.getColor(R.color.enable_btn))
            binding.btnLoginSubmit.setOnClickListener {
                viewModel.loginUser(email, pwd)
            }
        }
        else{
            binding.btnLoginSubmit.isEnabled = false
            binding.btnLoginSubmit.setBackgroundColor(resources.getColor(R.color.disable_btn))
            binding.btnLoginSubmit.setTextColor(resources.getColor(R.color.white))
        }

    }

    private fun observeModel() {
        viewModel.loginFlow.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
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