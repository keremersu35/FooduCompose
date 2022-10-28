package com.example.fooduapp.domain.use_case

import com.example.fooduapp.common.Resource
import com.example.fooduapp.data.remote.dto.toFoodDetailModel
import com.example.fooduapp.domain.model.FoodDetailModel
import com.example.fooduapp.domain.repository.MealRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetFoodDetailUseCase @Inject constructor(
    private val repository: MealRepository
){
    operator fun invoke(foodId: Int): Flow<Resource<FoodDetailModel>> = flow{
        try {
            emit(Resource.Loading<FoodDetailModel>())
            val meal = repository.getFoodDetail(foodId)?.toFoodDetailModel()
            emit(Resource.Success<FoodDetailModel>(meal))
        }catch (e: HttpException){
            emit(Resource.Error<FoodDetailModel>(e.localizedMessage ?: "An unexpected error occured"))
        }catch (e: IOException){
            emit(Resource.Error<FoodDetailModel>("Couldn't reach server."))
        }
    }
}