package com.sirketismi.noteapp.repository

import androidx.lifecycle.LiveData
import com.sirketismi.noteapp.dao.NotesDao
import com.sirketismi.noteapp.model.NoteEntity
import javax.inject.Inject


interface NoteRepositoryInterface {
    suspend fun insert(note : NoteEntity)
    fun getAll() : LiveData<List<NoteEntity>>
}

class NotesRepository @Inject constructor(private val notesDao: NotesDao) : NoteRepositoryInterface{
    override suspend fun insert(note: NoteEntity) {
        notesDao.insert(note)
    }

    override fun getAll(): LiveData<List<NoteEntity>> {
        return notesDao.getAll()
    }

}