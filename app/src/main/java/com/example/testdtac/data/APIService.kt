package com.example.testdtac.data

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.*


interface APIService {

    @GET("/api/?results=")
    fun getSearchResult(): Observable<SearchResponse>

}

