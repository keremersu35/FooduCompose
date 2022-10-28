package com.example.fooduapp.domain.use_case

import com.example.fooduapp.common.Resource
import com.example.fooduapp.data.remote.dto.toSearchResultModel
import com.example.fooduapp.domain.model.SearchResultModel
import com.example.fooduapp.domain.repository.MealRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetSearchResultUseCase @Inject constructor(
    private val repository: MealRepository
){
    operator fun invoke(searchQuery: String): Flow<Resource<SearchResultModel>> = flow{
        try {
            emit(Resource.Loading<SearchResultModel>())
            val query = repository.getSearchResults(searchQuery)
            emit(Resource.Success<SearchResultModel>(query.toSearchResultModel()))
        }catch (e: HttpException){
            emit(Resource.Error<SearchResultModel>(e.localizedMessage ?: "An unexpected error occured"))
        }catch (e: IOException){
            emit(Resource.Error<SearchResultModel>("Couldn't reach server."))
        }
    }
}