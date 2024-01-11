package com.sirketismi.noteapp.feature.notes

import androidx.lifecycle.ViewModel
import com.sirketismi.noteapp.R
import com.sirketismi.noteapp.repository.NotesRepository
import com.sirketismi.noteapp.repository.ResourceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class NotesViewModel @Inject constructor(private val repository: NotesRepository, val resourceRepository: ResourceRepository): ViewModel() {
    fun method() {
        val str = resourceRepository.toString(R.string.btn_save_title)
    }

    fun getAll() {
        firebaseRepository.getNoteList {

        }
    }
}