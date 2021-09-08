package example.clpal.daggerroomdbdemo

import android.app.Application
import example.clpal.daggerroomdbdemo.di.AppComponent
import example.clpal.daggerroomdbdemo.di.AppModule
import example.clpal.daggerroomdbdemo.di.DaggerAppComponent

class MyApp:Application() {
    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
   appComponent= DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    fun getAppComponent():AppComponent{
        return appComponent
    }
}