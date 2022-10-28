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
class HomepageViewModel @Inject constructor(
    private val getRandomMealUseCase: GetRandomMealUseCase,
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getMealListUseCase: GetMealListUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel(){

    private val _stateRandom = mutableStateOf(RandomMealState())
    val stateRandom: State<RandomMealState> = _stateRandom

    private val _stateCategory = mutableStateOf(CategoriesState())
    val stateCategory: State<CategoriesState> = _stateCategory

    private val _stateMealList = mutableStateOf(MealListState())
    val stateMealList: State<MealListState> = _stateMealList

    init {
        getRandomMeal()
        //getCategories()
        getMealList()
    }

    private fun getRandomMeal(){
        getRandomMealUseCase().onEach { result ->
            when(result){
                is Resource.Success ->{
                    _stateRandom.value = RandomMealState(meal = result.data)
                }
                is Resource.Error ->{
                    _stateRandom.value = RandomMealState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading ->{
                    _stateRandom.value = RandomMealState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    /*private fun getCategories(){
        getCategoriesUseCase().onEach { result ->
            when(result){
                is Resource.Success ->{
                    _stateCategory.value = CategoriesState(meal = result.data)
                }
                is Resource.Error ->{
                    _stateCategory.value = CategoriesState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading ->{
                    _stateCategory.value = CategoriesState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }*/

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