package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSignInBinding
import com.example.myapplication.interfaces.navigator
import com.example.myapplication.model.LoginInputData

class SignInFragment : Fragment(R.layout.fragment_sign_in){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentSignInBinding.inflate(inflater, container, false).also {
        it.btnSignIn.setOnClickListener(){
            navigator().makeToast(getString(R.string.develop_function))
        }
        it.btnGuest.setOnClickListener(){ _ ->
            navigator().openCaptcha(LoginInputData(it.etLogin.text.toString(), it.etPassword.text.toString(), it.cbRemember.isChecked, true))
        }
    }.root
}