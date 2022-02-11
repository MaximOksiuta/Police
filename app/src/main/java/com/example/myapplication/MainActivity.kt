package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.view.WindowId
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.fragments.CaptchaFragment
import com.example.myapplication.interfaces.HasActionBar
import com.example.myapplication.interfaces.Navigator
import com.example.myapplication.interfaces.ResultListener
import com.example.myapplication.model.LoginInputData
import com.example.myapplication.model.PhotoRobot

class MainActivity : AppCompatActivity(), Navigator {
    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    private var currentFragment: Fragment? = null

    private var fragmentListener = object: FragmentManager.FragmentLifecycleCallbacks(){
        override fun onFragmentViewCreated(
            fm: FragmentManager,
            f: Fragment,
            v: View,
            savedInstanceState: Bundle?
        ) {
            super.onFragmentViewCreated(fm, f, v, savedInstanceState)
            if (f is NavHostFragment) return
            currentFragment = f
            updateUI()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        setSupportActionBar(binding.toolbar)
        val navHost = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHost.navController
        supportFragmentManager.registerFragmentLifecycleCallbacks(fragmentListener, true)
    }

    override fun onSupportNavigateUp() = navController.navigateUp() || super.onSupportNavigateUp()

    private fun updateUI(){
        val fragment = currentFragment

        if (fragment is HasActionBar){
            binding.toolbar.visibility = View.VISIBLE
            binding.toolbar.setTitle(fragment.getTitleRes())
        } else{
            binding.toolbar.visibility = View.GONE
        }
    }

    private fun launchDestination(destinationId: Int, args: Bundle? = null){
        navController.navigate(destinationId, args)
    }
    override fun openCaptcha(loginData: LoginInputData) {
        launchDestination(R.layout.fragment_captcha, CaptchaFragment.createArgs(loginData))
    }

    override fun login(loginData: LoginInputData) {
        TODO("Not yet implemented")
    }

    override fun logout() {
        TODO("Not yet implemented")
    }

    override fun goBack() {
        TODO("Not yet implemented")
    }

    override fun openPhotoRobot(photoRobot: PhotoRobot) {
        TODO("Not yet implemented")
    }

    override fun openCreatePhotoRobotScreen() {
        TODO("Not yet implemented")
    }

    override fun openAboutUsScreen() {
        TODO("Not yet implemented")
    }

    override fun openPhotoRobotsScreen() {
        TODO("Not yet implemented")
    }

    override fun openPaintScreen() {
        TODO("Not yet implemented")
    }

    override fun openDepartmentsScreen() {
        TODO("Not yet implemented")
    }

    override fun openWantedScreen() {
        TODO("Not yet implemented")
    }

    override fun <T : Parcelable> publishResult(result: T) {
        TODO("Not yet implemented")
    }

    override fun <T : Parcelable> listenResult(
        clazz: Class<T>,
        owner: LifecycleOwner,
        listener: ResultListener<T>
    ) {

    }

    override fun makeToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        supportFragmentManager.unregisterFragmentLifecycleCallbacks(fragmentListener)
    }
}