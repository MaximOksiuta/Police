package com.example.myapplication.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class SharedPrefs (context: Context){

    companion object{
        private const val LOGIN_DATA_PREFS_KEY = "LOGIN_DATA_PREFS_KEY"
        private const val LOGIN_STATUS_PREF_KEY = "LOGIN_STATUS_PREF_KEY"
        private const val LOGIN_PREF_KEY = "LOGIN_PREF_KEY"
        private const val PASSWORD_PREF_KEY = "PASSWORD_PREF_KEY"
    }

    private val loginSharedPreferences: SharedPreferences = context.getSharedPreferences(LOGIN_DATA_PREFS_KEY, Context.MODE_PRIVATE)

    var loginStatus: Int // 0 - нет входа в аккаунт, 1 - гостевой вход, 2 - вход в аккаунт
        get() = loginSharedPreferences.getInt(LOGIN_STATUS_PREF_KEY, 0)?: 0
        set(value) = loginSharedPreferences.edit { putInt(LOGIN_STATUS_PREF_KEY, value) }
    var login: String
        get() = loginSharedPreferences.getString(LOGIN_PREF_KEY, "")?: ""
        set(value) = loginSharedPreferences.edit { putString(LOGIN_PREF_KEY, value) }
    var password: String
        get() = loginSharedPreferences.getString(PASSWORD_PREF_KEY, "")?: ""
        set(value) = loginSharedPreferences.edit { putString(PASSWORD_PREF_KEY, value) }

}