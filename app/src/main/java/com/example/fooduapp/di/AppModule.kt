package com.example.fooduapp.di

import com.example.fooduapp.common.Constants
import com.example.fooduapp.data.remote.ApiInterface
import com.example.fooduapp.data.repository.MealRepositoryImpl
import com.example.fooduapp.domain.repository.MealRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMealApi(): ApiInterface {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun provideMealRepository(api: ApiInterface): MealRepository{
        return MealRepositoryImpl(api)
    }
}