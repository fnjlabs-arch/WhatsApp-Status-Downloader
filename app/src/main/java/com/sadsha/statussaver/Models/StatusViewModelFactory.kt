package com.sadsha.statussaver.Models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sadsha.statussaver.Data.StatusRepo

class StatusViewModelFactory(private val repo: StatusRepo):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return StatusViewModel(repo) as T
    }
}