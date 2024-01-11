package com.sirketismi.noteapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.sirketismi.noteapp.dao.AppDataBase
import com.sirketismi.noteapp.dao.NotesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNotesDao(appDataBase: AppDataBase) : NotesDao {
        return appDataBase.noteDao()
    }

    @Singleton
    @Provides
    fun provideFireStore() : FirebaseFirestore {
        return Firebase.firestore
    }

    @Singleton
    @Provides
    fun provideAppdatabase(@ApplicationContext appContext: Context) : AppDataBase {
        val instance = Room.databaseBuilder(
            appContext.applicationContext,
            AppDataBase::class.java,
            "notedb"
        ).build()
        return instance
    }
}