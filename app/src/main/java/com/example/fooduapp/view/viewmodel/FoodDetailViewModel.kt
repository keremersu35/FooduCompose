package com.example.fooduapp.view.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooduapp.common.Resource
import com.example.fooduapp.domain.model.FoodDetailState
import com.example.fooduapp.domain.use_case.GetFoodDetailUseCase
import com.example.fooduapp.view.FoodDetailScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FoodDetailViewModel @Inject constructor(
    private val getFoodDetailUseCase: GetFoodDetailUseCase,
    savedStateHandle: SavedStateHandle,
): ViewModel(){

    private val _state = mutableStateOf(FoodDetailState())
    val state: State<FoodDetailState> = _state

    init {
        val argument = savedStateHandle.get<Int>("id")
        if(argument != null) getFoodDetail(argument);
    }

     fun getFoodDetail(id: Int){
        getFoodDetailUseCase(id).onEach { result ->
            when(result){
                is Resource.Success ->{
                    _state.value = FoodDetailState(meal = result.data)
                    println(result.data)
                }
                is Resource.Error ->{
                    _state.value = FoodDetailState(error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading ->{
                    _state.value = FoodDetailState(isLoading = true)
                    println("Loading")
                }
            }
        }.launchIn(viewModelScope)
    }
}