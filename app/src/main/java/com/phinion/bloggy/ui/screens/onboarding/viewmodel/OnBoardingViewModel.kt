package com.phinion.bloggy.ui.screens.onboarding.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.phinion.bloggy.data.repository.Repository
import com.phinion.bloggy.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {
    fun saveOnBoardingState(completed: Boolean){
        viewModelScope.launch(Dispatchers.IO) {
            useCases.saveOnBoardingUseCase.invoke(completed)
        }
    }
}