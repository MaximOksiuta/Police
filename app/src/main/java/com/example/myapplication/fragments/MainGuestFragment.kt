package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentMainGuestBinding
import com.example.myapplication.interfaces.HasActionBar
import com.example.myapplication.interfaces.HasLogoutOnBackPressed

class MainGuestFragment: Fragment(R.layout.fragment_main_guest), HasActionBar, HasLogoutOnBackPressed {
    override fun getTitleRes(): Int = R.string.main_guest_fragment_title

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMainGuestBinding.inflate(inflater, container, false).root
}