package tech.ericwathome.modularizationpractice2.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import tech.ericwathome.modularizationpractice2.BuildConfig
import timber.log.Timber

@HiltAndroidApp
class ModularizePractice2App : Application() {
    override fun onCreate() {
        super.onCreate()

        initTimber()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}