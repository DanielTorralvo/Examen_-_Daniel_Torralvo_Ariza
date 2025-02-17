package es.iesjm.dam.mvvm_cientificas.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(MujerStemEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun mujerStemDao(): MujerStemDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(context, AppDatabase::class.java, "app_database")

                    .createFromAsset("database/cientificas_database.db")
                    // Limpia y reconstruye en lugar de migrar si no hay un objeto de migración.
                    // La migración no forma parte de este codelab.
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {
                        INSTANCE = it
                    }
            }
        }
    }
}