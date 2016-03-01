package com.github.skohar.sampleandroidkotlinchat

import android.app.Application
import com.squareup.leakcanary.LeakCanary
import hugo.weaving.DebugLog

class MainApplication : Application() {

    @DebugLog override fun onCreate() {
        super.onCreate()
        LeakCanary.install(this)
    }
}
