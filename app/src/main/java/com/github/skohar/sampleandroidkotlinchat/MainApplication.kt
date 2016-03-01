package com.github.skohar.sampleandroidkotlinchat

import android.app.Application
import com.squareup.leakcanary.LeakCanary

class MainApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        LeakCanary.install(this)
    }
}
