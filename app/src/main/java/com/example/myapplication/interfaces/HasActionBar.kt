package com.example.myapplication.interfaces

import androidx.annotation.StringRes

interface HasActionBar {
    @StringRes
    fun getTitleRes(): Int
}