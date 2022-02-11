package com.example.myapplication.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginInputData(var login: String, var password: String, var remember: Boolean, var guestMode: Boolean): Parcelable
