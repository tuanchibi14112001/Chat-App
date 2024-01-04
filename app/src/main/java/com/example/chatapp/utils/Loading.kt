package com.example.chatapp.utils

import android.app.Dialog
import android.content.Context
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.Window
import androidx.core.content.ContextCompat
import com.example.chatapp.R
import com.example.chatapp.databinding.CustomLoadingViewBinding


class Loading(context: Context, themeResId: Int) : Dialog(context, themeResId) {
    private lateinit var binding: CustomLoadingViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CustomLoadingViewBinding.inflate(layoutInflater)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.custom_loading_view)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setCancelable(false)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q)
            binding.progressBar.indeterminateDrawable.colorFilter = BlendModeColorFilter(
                ContextCompat.getColor(context, R.color.white),
                BlendMode.SRC_ATOP
            )
        else binding.progressBar.indeterminateDrawable.setColorFilter(
            ContextCompat.getColor(
                context,
                android.R.color.white
            ), PorterDuff.Mode.SRC_ATOP
        )
    }
}