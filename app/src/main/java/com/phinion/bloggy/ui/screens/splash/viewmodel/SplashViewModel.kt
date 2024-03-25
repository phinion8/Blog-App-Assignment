package com.phinion.bloggy.ui.screens.splash.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.phinion.bloggy.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {
    private val _onBoardingState: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val onBoardingState = _onBoardingState.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _onBoardingState.value = useCases.readOnBoardingUseCase().stateIn(this@launch).value
        }
    }
}