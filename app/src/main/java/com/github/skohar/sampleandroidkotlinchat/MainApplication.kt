package com.github.skohar.sampleandroidkotlinchat

import android.app.Application
import android.util.Log
import com.squareup.leakcanary.LeakCanary
import hugo.weaving.DebugLog
import timber.log.Timber

class MainApplication : Application() {

    @DebugLog override fun onCreate() {
        super.onCreate()
        LeakCanary.install(this)
        //        if (BuildConfig.DEBUG) {
        //            Timber.plant(Timber.DebugTree());
        //        } else {
        // debuglogが見えない
        //        Timber.plant(CrashReportingTree());
        //        Timber.e("", Exception())
        //        }

    }

    /** A tree which logs important information for crash reporting. */
    private class CrashReportingTree : Timber.Tree () {
        override fun log(priority: Int, tag: String, message: String, t: Throwable) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return
            } else {
                FakeCrashLibrary.log(priority, tag, message)
                t.let { t ->
                    if (priority == Log.ERROR) {
                        FakeCrashLibrary.logError(t)
                    } else if (priority == Log.WARN) {
                        FakeCrashLibrary.logWarning(t)
                    }
                }
            }
        }
    }
}
