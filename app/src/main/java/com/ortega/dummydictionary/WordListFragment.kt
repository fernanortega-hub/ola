package com.ortega.dummydictionary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import com.ortega.dummydictionary.databinding.FragmentWordListBinding

class WordListFragment : Fragment() {
    private lateinit var binding: FragmentWordListBinding

    private val viewModelFactory by lazy {
        val repository = DictionaryRepository()
        WordViewModelFactory(repository)
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

        val newWord = Word("Computadora", "dispositivo electronico que se usa para programar y ver videos")

        binding.button.setOnClickListener {
            viewModel.addWordVM(newWord)
        }


    }


}

