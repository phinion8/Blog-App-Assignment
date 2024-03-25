package com.phinion.bloggy.domain.use_cases.blog_list

import com.phinion.bloggy.data.repository.Repository
import com.phinion.bloggy.domain.models.BlogItem
import com.phinion.bloggy.domain.models.BlogResponse
import com.phinion.bloggy.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBlogListUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend operator fun invoke(offset: Int): Resource<List<BlogItem>>{
        return repository.getBlogList(offset)
    }

}