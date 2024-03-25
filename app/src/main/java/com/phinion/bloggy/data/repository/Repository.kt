package com.phinion.bloggy.data.repository

import com.phinion.bloggy.data.remote.BlogApi
import com.phinion.bloggy.domain.models.BlogItem
import com.phinion.bloggy.domain.models.BlogResponse
import com.phinion.bloggy.domain.repository.PreferenceManager
import com.phinion.bloggy.utils.Resource
import kotlinx.coroutines.flow.Flow
import java.lang.Exception
import javax.inject.Inject

class Repository @Inject constructor(
    private val preferenceManager: PreferenceManager,
    private val blogApi: BlogApi
) {

    suspend fun getBlogList(offset: Int): Resource<List<BlogItem>>{
        val response = try {
            blogApi.getBlogList(offset)
        }catch (e: Exception){
            return Resource.Error(e.message)
        }
        return Resource.Success(response)
    }


    suspend fun saveOnBoardingState(completed: Boolean){
        preferenceManager.saveOnBoardingState(completed = completed)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return preferenceManager.readOnBoardingState()
    }

}