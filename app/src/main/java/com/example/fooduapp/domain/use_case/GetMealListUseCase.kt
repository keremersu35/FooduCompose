package com.example.fooduapp.domain.use_case

import com.example.fooduapp.common.Resource
import com.example.fooduapp.data.remote.dto.CategoryRoot
import com.example.fooduapp.data.remote.dto.MealListDto
import com.example.fooduapp.domain.repository.MealRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMealListUseCase @Inject constructor(
    private val repository: MealRepository
){
    operator fun invoke(): Flow<Resource<MealListDto>> = flow{
        try {
            emit(Resource.Loading<MealListDto>())
            var meals = repository.getMealList()
            emit(Resource.Success<MealListDto>(meals))

        }catch (e: HttpException){
            emit(Resource.Error<MealListDto>(e.localizedMessage ?: "An unexpected error occured"))
        }catch (e: IOException){
            emit(Resource.Error<MealListDto>("Couldn't reach server."))
        }
    }
}