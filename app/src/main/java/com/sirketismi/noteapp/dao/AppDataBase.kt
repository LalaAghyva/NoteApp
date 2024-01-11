package com.sirketismi.noteapp.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sirketismi.noteapp.model.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase(){
    abstract fun noteDao() : NotesDao
}