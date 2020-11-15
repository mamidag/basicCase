package com.example.basiccase.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basiccase.Resource
import com.example.basiccase.Status
import com.example.basiccase.api.model.CaseData
import com.example.basiccase.api.model.CaseDataItem
import com.example.basiccase.repository.MainRepository
import com.github.ajalt.timberkt.e
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect


@ExperimentalCoroutinesApi
class CaseViewModel @ViewModelInject constructor(
    private val repo: MainRepository,
) : ViewModel() {


    val datas: MutableLiveData<Resource<List<CaseDataItem>>> = MutableLiveData()

    fun getCaseDatas(): LiveData<Resource<List<CaseDataItem>>> {
        return if (datas.value?.data == null) {
            viewModelScope.launch {
                repo.getCaseDatas().collect {
                    e { "$it" }
                    if (it.status == Status.SUCCESS) {
                        datas.postValue(it)
                    }
                }
            }
            datas
        } else {
            datas
        }
    }

}

