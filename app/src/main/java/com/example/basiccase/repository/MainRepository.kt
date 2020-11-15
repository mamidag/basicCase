package com.example.basiccase.repository

import android.util.Log
import com.example.basiccase.Resource
import com.example.basiccase.api.CaseApi
import com.example.basiccase.api.model.CaseData
import com.example.basiccase.api.model.CaseDataItem
import com.example.basiccase.api.model.categories.Category
import com.example.basiccase.api.model.products.Products
import com.github.ajalt.timberkt.Timber.e
import com.github.ajalt.timberkt.Timber.i
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import javax.inject.Inject


@ExperimentalCoroutinesApi
class MainRepository @Inject constructor(
    private val caseApi: CaseApi
) {

    fun getCaseDatas(): Flow<Resource<List<CaseDataItem>>> {
        return flow {
           // emit(Resource.loading(null))
            val caseData = caseApi.doAuth(
                url = "https://www.vitrinova.com/api/v2/discover/"
            )
            e { "$caseData" }
            emit(Resource.success(caseData))
        }.retryWhen { cause, attempt ->
            i { "attempt count -> $attempt" }
            Log.e("Data", cause.toString())
            (cause is Exception).also { if (it) delay(10_000) }
        }.catch {
            emit(Resource.error(it.localizedMessage, null, it))
        }.flowOn(Dispatchers.IO)
    }
    fun getProductDatas(): Flow<Resource<List<Products>>> {
        return flow {
           // emit(Resource.loading(null))
            val caseData = caseApi.doAuth(
                url = "https://www.vitrinova.com/api/v2/discover/"
            )
            e { "${caseData[1].products}" }
            emit(Resource.success(caseData[1].products))
        }.retryWhen { cause, attempt ->
            i { "attempt count -> $attempt" }
            Log.e("Data", cause.toString())
            (cause is Exception).also { if (it) delay(10_000) }
        }.catch {
            emit(Resource.error(it.localizedMessage, null, it))
        }.flowOn(Dispatchers.IO)
    }
   fun getCategoryDatas(): Flow<Resource<List<Category>>> {
        return flow {
           // emit(Resource.loading(null))
            val caseData = caseApi.doAuth(
                url = "https://www.vitrinova.com/api/v2/discover/"
            )
            Log.e("inViewModel",caseData.toString())
            e { "${caseData[2].categories}" }
            emit(Resource.success(caseData[2].categories))
        }.retryWhen { cause, attempt ->
            i { "attempt count -> $attempt" }
            Log.e("Data", cause.toString())
            (cause is Exception).also { if (it) delay(10_000) }
        }.catch {
            emit(Resource.error(it.localizedMessage, null, it))
        }.flowOn(Dispatchers.IO)
    }


}
