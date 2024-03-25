package com.phinion.bloggy.domain.use_cases

import com.phinion.bloggy.domain.use_cases.blog_list.GetBlogListUseCase
import com.phinion.bloggy.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.phinion.bloggy.domain.use_cases.save_onboarding.SaveOnBoardingUseCase

data class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase,
    val getBlogListUseCase: GetBlogListUseCase
)