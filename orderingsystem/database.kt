package com.example.orderingsystem

import androidx.room.*

@Entity
data class employeer(
    @PrimaryKey val username: String,
    val passwd: String,

    )
@Dao
interface empDao{
    @Insert
    fun insert(vararg oemp:employeer)
    @Delete
    fun delete(vararg oemp:employeer)
    @Update
    fun update(oemp:employeer)
    @Query("SELECT * FROM employeer WHERE username=(:username) AND passwd=(:passwd)")
    fun logon(username: String,passwd: String) :employeer

}


//@Entity
//data class menus(
//    @PrimaryKey val uid:Int,
//    @ColumnInfo(name ="name") val name:String,
//    @ColumnInfo(name="price") val price:String,
//
//)
//@Dao
//interface menuDao{
//    @Insert
//    fun insert(vararg omenu:menus)
//    @Delete
//    fun delete(vararg  omenu:menus)
//    @Update
//    fun update(omenu:menus)
//
//    @Query("SELECT * FROM menus")
//    fun getAll():List<menus>
//
//}
//@Database(entities = [employeer::class] , version = 1)
//abstract class empbase:RoomDatabase(){
//    abstract fun empDao():empDao
//}
@Database(entities = [employeer::class], version = 1)
abstract class database:RoomDatabase(){
    abstract fun empDao():empDao
}