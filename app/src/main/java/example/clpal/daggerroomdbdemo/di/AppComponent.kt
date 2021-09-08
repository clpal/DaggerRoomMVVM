package example.clpal.daggerroomdbdemo.di

import dagger.Component
import example.clpal.daggerroomdbdemo.MainActivityViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(mainActivityView: MainActivityViewModel)
}