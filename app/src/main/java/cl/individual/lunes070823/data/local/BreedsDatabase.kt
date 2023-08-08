package cl.individual.lunes070823.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DogBreedEntity::class], version =1)
abstract class BreedsDatabase : RoomDatabase() {

    abstract fun getBreedsDao(): BreedsDao

    companion object {
        @Volatile
        private var INSTANCE: BreedsDatabase? = null

        fun getDatabase(context: Context): BreedsDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BreedsDatabase::class.java,
                    "breeds_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}