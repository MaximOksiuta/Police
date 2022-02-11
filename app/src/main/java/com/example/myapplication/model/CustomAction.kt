package com.example.myapplication.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CustomAction(
@DrawableRes val iconRes: Int, @StringRes val description: Int, val onCustomAction: Runnable)
