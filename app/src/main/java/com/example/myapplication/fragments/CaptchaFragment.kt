package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentCaptchaBinding
import com.example.myapplication.interfaces.navigator
import com.example.myapplication.model.LoginInputData

class CaptchaFragment: Fragment(R.layout.fragment_captcha) {

    private lateinit var binding: FragmentCaptchaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getParcelable<LoginInputData>(ARG_LOGIN_DATA)?.let { updateUI(it) }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCaptchaBinding.inflate(inflater, container, false)
        with(binding) {
            btnConfirmCaptcha.setOnClickListener { _ ->
                if (etCaptcha.text.toString() == "ic8") {
                    navigator().login(
                        LoginInputData(
                            etLogin.text.toString(),
                            etPassword.text.toString(),
                            cbRemember.isChecked,
                            true
                        )
                    )
                } else {
                    navigator().makeToast("Каптча заполнена неверно")
                }
            }
        }
        return binding.root
    }

    private fun updateUI(data: LoginInputData){
        binding.etLogin.setText(data.login)
        binding.etPassword.setText(data.password)
        binding.cbRemember.isChecked = data.remember
    }

    companion object{

        private val ARG_LOGIN_DATA = "ARG_LOGIN_DATA"

        fun createArgs(data: LoginInputData) = bundleOf(ARG_LOGIN_DATA to data)
    }
}