package com.sirketismi.noteapp.repository

import android.content.Context
import com.sirketismi.noteapp.model.NoteEntity
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ResourceRepository @Inject constructor(@ApplicationContext val appContext: Context) {
    fun toString(resourceID:Int): String {
        return appContext.getString(resourceID)


    }
}