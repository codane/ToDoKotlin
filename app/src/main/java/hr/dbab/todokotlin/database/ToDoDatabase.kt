package hr.dbab.todokotlin.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// abstract database holder class, abstract because the Room creates the implementation for us
@Database(entities = [ToDoItem::class], version = 1, exportSchema = false)
abstract class ToDoDatabase : RoomDatabase(){

    // declaring an abstract value which returns our ToDoDao -> because database needs to know about our ToDoDao
    abstract val toDoDao: ToDoDao

    // defining companion object -> we can access the methods of this class without actually instantiating it
    // there is no need to instantiate it because the only purpose of this class is to provide a database

    companion object{

        /* private nullable variable which holds the reference to our database after we create one
        @Volatile means this variable will never be cached, and all writes and reads will be done to
        and from the main memory -> the value of this variable is always up-to-date and it is the
        same for all the threads (changes made by one thread to instance are immediately visible to all threads)
         */
        @Volatile
        private var INSTANCE: ToDoDatabase? = null


        // method will return a reference to ToDoDatabase
        // Context parameter required for the database builder
        fun getInstance(context: Context): ToDoDatabase {

            /* synchronized block is to make sure that only one thread of execution at a time can
            enter this block of code -> that means we are sure that the database gets initialized
            only once
             */
            synchronized(this){
                // we copy the current value of INSTANCE into instance local variable
                var instance =
                    INSTANCE

                // checking if the instance is null
                if (instance == null){
                    // if null -> we use (invoke) database builder to create a database
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ToDoDatabase::class.java,
                        "todo_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    // assigning INSTANCE to instance
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}