package com.example.mvvmpattern.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmpattern.models.QuoteList
import com.example.mvvmpattern.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: QuoteRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getQuotes(1)
        }
    }

    val quotes : LiveData<QuoteList>
    get() = repository.quotes
}