package example.clpal.daggerroomdbdemo.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import example.clpal.daggerroomdbdemo.database.AppDatabase
import example.clpal.daggerroomdbdemo.database.UserDao
import javax.inject.Singleton

@Module
class AppModule(val application: Application) {

    @Singleton
    @Provides
    fun getUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.getUserDao()
    }

    @Singleton
    @Provides
    fun getRoomDbInstance(): AppDatabase {
        return AppDatabase.getAppDatabaseInstance(provideAppContext())
    }

    @Singleton
    @Provides
    fun provideAppContext(): Context {
        return application.applicationContext
    }
}