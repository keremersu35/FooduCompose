package com.example.fooduapp.domain.use_case

import com.example.fooduapp.common.Resource
import com.example.fooduapp.data.remote.dto.CategoryRoot
import com.example.fooduapp.domain.repository.MealRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val repository: MealRepository
){
    operator fun invoke(): Flow<Resource<CategoryRoot>> = flow{
        try {
            emit(Resource.Loading<CategoryRoot>())
            var meals = repository.getCategories()
            emit(Resource.Success<CategoryRoot>(meals))

        }catch (e: HttpException){
            emit(Resource.Error<CategoryRoot>(e.localizedMessage ?: "An unexpected error occured"))
        }catch (e: IOException){
            emit(Resource.Error<CategoryRoot>("Couldn't reach server."))
        }
    }
}