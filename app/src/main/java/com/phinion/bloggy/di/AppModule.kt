package com.phinion.bloggy.di

import android.content.Context
import com.phinion.bloggy.data.remote.BlogApi
import com.phinion.bloggy.data.repository.PreferenceManagerImpl
import com.phinion.bloggy.data.repository.Repository
import com.phinion.bloggy.domain.repository.PreferenceManager
import com.phinion.bloggy.domain.use_cases.UseCases
import com.phinion.bloggy.domain.use_cases.blog_list.GetBlogListUseCase
import com.phinion.bloggy.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.phinion.bloggy.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import com.phinion.bloggy.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePreferenceManager(@ApplicationContext context: Context): PreferenceManager {
        return PreferenceManagerImpl(context)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository),
            getBlogListUseCase = GetBlogListUseCase(repository)
        )
    }

    @Provides
    @Singleton
    fun provideBlogApi(): BlogApi {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(BlogApi::class.java)
    }

}