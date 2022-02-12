package com.example.myapplication.interfaces

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

interface HasActionBar {
    @StringRes
    fun getTitleRes(): Int
}