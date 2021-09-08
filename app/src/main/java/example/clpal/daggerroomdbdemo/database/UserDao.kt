package example.clpal.daggerroomdbdemo.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import example.clpal.daggerroomdbdemo.UserEntity

@Dao
interface UserDao {
    @Query("SELECT*FROM user_entity ORDER BY id DESC")
    fun getAllRecordsfromDB(): List<UserEntity>?

    @Insert
    fun insertRecord(userEntity: UserEntity)
}