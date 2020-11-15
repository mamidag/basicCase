package com.example.basiccase.api

import com.example.basiccase.api.model.CaseData
import com.example.basiccase.api.model.CaseDataItem
import retrofit2.http.GET
import retrofit2.http.Url

interface CaseApi {
    @GET()
    suspend  fun doAuth(@Url url:String
    ): List<CaseDataItem>
}