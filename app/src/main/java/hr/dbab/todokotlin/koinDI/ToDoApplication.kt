package hr.dbab.todokotlin.koinDI

import android.app.Application
import hr.dbab.todokotlin.koinDI.appModule
import hr.dbab.todokotlin.koinDI.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ToDoApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ToDoApplication)
            modules(listOf(
                appModule,
                viewModelModule
            ))
        }
    }
}