package example.clpal.daggerroomdbdemo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import example.clpal.daggerroomdbdemo.UserEntity

@Database(entities = [UserEntity::class],version = 1)
abstract class AppDatabase :RoomDatabase() {
    abstract fun getUserDao():UserDao
    companion object{
        private var db_instance:AppDatabase?=null // note this
        fun getAppDatabaseInstance(context:Context):AppDatabase{
            if (db_instance==null){
                db_instance=Room.databaseBuilder<AppDatabase>(
                    context.applicationContext,AppDatabase::class.java,"app_db"
                ).allowMainThreadQueries().build()
                }
                return db_instance!!
            }
        }

}