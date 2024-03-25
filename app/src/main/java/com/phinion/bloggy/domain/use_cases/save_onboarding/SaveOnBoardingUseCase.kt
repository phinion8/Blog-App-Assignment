package com.phinion.bloggy.domain.use_cases.save_onboarding

import com.phinion.bloggy.data.repository.Repository


class SaveOnBoardingUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(completed: Boolean){
        repository.saveOnBoardingState(completed = completed)
    }

}