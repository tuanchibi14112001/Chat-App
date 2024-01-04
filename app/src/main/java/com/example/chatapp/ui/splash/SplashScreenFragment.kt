package com.example.chatapp.ui.splash

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.chatapp.R
import com.example.chatapp.databinding.FragmentSplashScreenBinding
import com.example.chatapp.ui.base.BaseFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SplashScreenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : BaseFragment<FragmentSplashScreenBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ) = FragmentSplashScreenBinding.inflate(inflater, container, false)

    override fun prepareView(savedInstanceState: Bundle?) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        GlobalScope.launch(Dispatchers.Main) {
            delay(1000)
            test()
        }
    }

    suspend fun test() {
        findNavController().navigate(R.id.action_splashScreenFragment_to_loginFragment)
    }


}