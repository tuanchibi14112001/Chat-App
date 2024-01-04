package com.example.chatapp.ui.base

import android.os.Bundle
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding
import com.example.chatapp.R
import com.example.chatapp.utils.Loading


/**
 * Base class for activity instances
 */
abstract class BaseActivity<BD: ViewBinding>: AppCompatActivity() {

    //region vars
    private lateinit  var _binding: BD
    protected val binding: BD get() = _binding

    private lateinit var mLoading: Loading

    //endregion

    /**
     * Set layout id
     */
    abstract fun getViewBinding(): BD

    /**
     * Prepare UI Components
     */
    abstract fun prepareView(savedInstanceState: Bundle?)

    /**
     * Override onCreate method
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Set layout
        _binding = getViewBinding()
        setContentView(binding.root)
        //Set custom loading dialog
        mLoading = Loading(this, R.style.StyleLoading)
        //Set view
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        prepareView(savedInstanceState)
    }

    //region Custom Loading Dialog's methods
    /**
     * Show loading
     */
    fun showLoading() {
        try {
            if (!mLoading.isShowing && !isFinishing)
                mLoading.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * Hide loading
     */
    fun hideLoading() {
        try {
            if (mLoading.isShowing)
                mLoading.dismiss()
        } catch (e: Exception) {
            e.printStackTrace()
        }
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

    override fun onDestroy() {
        super.onDestroy()

    }
    //endregion
}