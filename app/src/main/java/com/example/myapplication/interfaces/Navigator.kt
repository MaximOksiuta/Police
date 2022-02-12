package com.example.myapplication.interfaces

import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.example.myapplication.model.LoginInputData
import com.example.myapplication.model.PhotoRobot

typealias ResultListener<T> = (T) -> Unit

fun Fragment.navigator(): Navigator{
    return requireActivity() as Navigator
}

interface Navigator {
    fun checkLogin() // проверить есть ли сохраненные данные о входе в аккаунт

    fun openCaptcha(loginData: LoginInputData) // открыть фрагмент с каптчей (fragment_captcha)

    fun login(loginData: LoginInputData) // опционально: сохранить данные в sharedPreferences; открыть основной фрагмент (fragment_main_guest/?)

    fun logout() // удалить данные из sharedPreferences; открыть фрагмент входа в аккаунт (fragment_sign_in)

    fun goBack() // открыть предыидущий фрагмент

    fun openPhotoRobot(photoRobot: PhotoRobot) // открыть фрагмент создания фото робот и загрузить в него выбранный фото робот для рпедактирования

    fun openCreatePhotoRobotScreen() // открыть фрагмент создания фото робота

    fun openAboutUsScreen() // открыть фрагмент с информациец о приложении

    fun openPhotoRobotsScreen() // открыть галерею фото роботов

    fun openPaintScreen() // открыть фрагмент рисовалку

    fun openDepartmentsScreen() // пока не используется

    fun openWantedScreen() // пока не используется

    fun <T: Parcelable> publishResult(result: T) // отправка результата фрагмента

    fun <T: Parcelable> listenResult(clazz: Class<T>, owner: LifecycleOwner, listener: ResultListener<T>) // прием результата другого фрагмента

    fun makeToast(text: String) // упрощение создания тостов
}