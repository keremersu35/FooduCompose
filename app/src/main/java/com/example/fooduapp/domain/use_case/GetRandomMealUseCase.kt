package com.example.fooduapp.domain.use_case

import com.example.fooduapp.common.Resource
import com.example.fooduapp.data.remote.dto.toRandomMeal
import com.example.fooduapp.domain.model.RandomMealModel
import com.example.fooduapp.domain.repository.MealRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetRandomMealUseCase @Inject constructor(
    private val repository: MealRepository
){
    operator fun invoke(): Flow<Resource<RandomMealModel>> = flow{
        try {
            emit(Resource.Loading<RandomMealModel>())
            val meal = repository.getRandomMeal().toRandomMeal()
            emit(Resource.Success<RandomMealModel>(meal))
        }catch (e: HttpException){
            emit(Resource.Error<RandomMealModel>(e.localizedMessage ?: "An unexpected error occured"))
        }catch (e: IOException){
            emit(Resource.Error<RandomMealModel>("Couldn't reach server."))
        }
    }
}