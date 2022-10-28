package com.example.fooduapp.view.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooduapp.common.Resource
import com.example.fooduapp.domain.model.SearchResultState
import com.example.fooduapp.domain.use_case.GetSearchResultUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    private val getSearchResultModel: GetSearchResultUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel(){

    private val _stateSearchList = mutableStateOf(SearchResultState())
    val stateSearchList: State<SearchResultState> = _stateSearchList

    fun getSearchList(query: String){
        getSearchResultModel(searchQuery = query).onEach { result ->
            when(result){
                is Resource.Success ->{
                    _stateSearchList.value = SearchResultState(meal = result.data!!)
                    print(result.data)
                }
                is Resource.Error ->{
                    _stateSearchList.value = SearchResultState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading ->{
                    _stateSearchList.value = SearchResultState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}