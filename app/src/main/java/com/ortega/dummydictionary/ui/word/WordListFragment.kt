package com.ortega.dummydictionary.ui.word

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.ortega.dummydictionary.DummyDictionaryApplication
import com.ortega.dummydictionary.R
import com.ortega.dummydictionary.databinding.FragmentWordListBinding
import com.ortega.dummydictionary.data.model.Word
import com.ortega.dummydictionary.repository.DictionaryRepository

class WordListFragment : Fragment() {
    private lateinit var binding: FragmentWordListBinding

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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_word_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val wordListRecyclerView = binding.wordListRecyclerView
        val wordAdapter = WordAdapter()
        wordListRecyclerView.apply {
            adapter = wordAdapter
        }

        viewModel.words.observe(viewLifecycleOwner) { data ->
            wordAdapter.setData(data)
        }

        binding.actionAddWord.setOnClickListener{
            it.findNavController().navigate(R.id.action_wordListFragment_to_addWordFragment)
        }






    }


}


