package com.example.chatapp.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * Base class for Fragment instances
 */
abstract class BaseFragment<BD : ViewBinding> : Fragment() {

    private lateinit var _binding: BD
    protected val binding: BD get() = _binding


    // Get Fragment ViewBinding

    abstract fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): BD

    /**
     * Prepare UI Components
     */
    abstract fun prepareView(savedInstanceState: Bundle?)


    /**
     * Override onViewCreated method
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getViewBinding(inflater,container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareView(savedInstanceState)
    }

    //region Custom Loading Dialog's methods
    /**
     * Show loading
     */
    fun showLoading() {
        val activity = activity as BaseActivity<*>
        activity.showLoading()
    }

    /**
     * Hide loading
     */
    fun hideLoading() {
        val activity = activity as BaseActivity<*>
        activity.hideLoading()
    }
    //endregion

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }
    //endregion
}