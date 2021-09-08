package example.clpal.daggerroomdbdemo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import example.clpal.daggerroomdbdemo.database.UserDao
import javax.inject.Inject

class MainActivityViewModel(application: Application):AndroidViewModel(application) {
    @Inject
    lateinit var  userDao: UserDao
    lateinit var allUserList:MutableLiveData<List<UserEntity>>
    init {
        // will call back here after creating the  application class
        (application as MyApp).getAppComponent().inject(this)
        allUserList= MutableLiveData()
        getAllRecords()
    }
    fun getRecordsObserver():MutableLiveData<List<UserEntity>>{
        return allUserList
    }
    fun getAllRecords(){
       val list=userDao.getAllRecordsfromDB()
       allUserList.postValue (list)
    }
    fun insertRecord(userEntity: UserEntity){
        userDao.insertRecord(userEntity)
        getAllRecords()
    }
}