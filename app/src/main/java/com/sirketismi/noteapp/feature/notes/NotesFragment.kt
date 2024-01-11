package com.sirketismi.noteapp.feature.notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sirketismi.noteapp.R
import com.sirketismi.noteapp.databinding.FragmentAddNoteBinding
import com.sirketismi.noteapp.databinding.FragmentNotesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesFragment : Fragment() {

    lateinit var binding: FragmentNotesBinding
    val viewModel: NotesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotesBinding.inflate(inflater)

        binding.btnSave.setOnClickListener {
            val action = NotesFragmentDirections.actionNotesToNewnote()
            findNavController().navigate(action)
        }
        return binding.root
    }

}