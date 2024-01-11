package com.sirketismi.noteapp.feature.newnote

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sirketismi.noteapp.model.NoteEntity
import com.sirketismi.noteapp.repository.FirebaseRepository
import com.sirketismi.noteapp.repository.NotesRepository
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class AddNewNoteViewModel @Inject constructor(val repository: NotesRepository, val firebaseRepository: FirebaseRepository): ViewModel() {
    var noteTitle = MutableLiveData<String>()
    var noteDetail = MutableLiveData<String>()

    var onSaveCompleted = MutableLiveData<Boolean>(false)

    fun onAddButtonClick() {
        if(isValid()) {
            insertNote()
            onSaveCompleted.postValue(true)
        }
    }

    private fun isValid() : Boolean {
        return !(noteTitle.value.isNullOrEmpty() || noteDetail.value.isNullOrEmpty())
    }

    private fun insertNote() {
        val note = NoteEntity(title = noteTitle.value, detail = noteDetail.value)

        viewModelScope.launch {
            repository.insert(note)
        }

        firebaseRepository.addNote(note) {

        }
    }
}

private operator fun <T> MutableLiveData<T>.invoke(b: Boolean) {
}
