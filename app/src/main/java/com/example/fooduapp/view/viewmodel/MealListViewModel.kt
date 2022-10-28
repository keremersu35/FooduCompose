package com.example.fooduapp.view.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooduapp.common.Resource
import com.example.fooduapp.data.remote.dto.toMealListModel
import com.example.fooduapp.domain.model.CategoriesState
import com.example.fooduapp.domain.model.MealListState
import com.example.fooduapp.domain.model.RandomMealState
import com.example.fooduapp.domain.use_case.GetCategoriesUseCase
import com.example.fooduapp.domain.use_case.GetMealListUseCase
import com.example.fooduapp.domain.use_case.GetRandomMealUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MealListViewModel @Inject constructor(
    private val getMealListUseCase: GetMealListUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel(){

    private val _stateMealList = mutableStateOf(MealListState())
    val stateMealList: State<MealListState> = _stateMealList

    init {
        getMealList()
    }

    private fun getMealList(){
        getMealListUseCase().onEach { result ->
            when(result){
                is Resource.Success ->{
                    _stateMealList.value = MealListState(meal = result.data!!.toMealListModel())
                }
                is Resource.Error ->{
                    _stateMealList.value = MealListState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading ->{
                    _stateMealList.value = MealListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}