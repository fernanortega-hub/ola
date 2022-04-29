package com.ortega.dummydictionary.ui.word

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.ortega.dummydictionary.DummyDictionaryApplication
import com.ortega.dummydictionary.R
import com.ortega.dummydictionary.data.model.Word
import com.ortega.dummydictionary.databinding.FragmentAddWordBinding

class AddWordFragment : Fragment() {
    private lateinit var binding: FragmentAddWordBinding

    private val viewModelFactory by lazy {
        val application = requireActivity().application as DummyDictionaryApplication
        WordViewModelFactory(application.getDictionaryRepository())
    }

    private val viewModel: WordViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_word, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newDefinition = binding.AddDefinitionTxt.text.toString()
        val newTerm = binding.addWordTxt.text.toString()

        val completeWord = Word(newTerm, newDefinition, true)

        binding.addWordBtn.setOnClickListener {
            viewModel.addWord(completeWord)
            it.findNavController().navigate(R.id.action_addWordFragment_to_wordListFragment)
        }
    }

}