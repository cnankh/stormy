package com.example.stormy.feature.current.repository

import com.example.stormy.core.base.BaseRemoteDataSource
import com.example.stormy.core.di.IoDispatcher
import com.example.stormy.feature.current.model.CurrentParams
import com.example.stormy.feature.current.model.CurrentResponse
import com.example.stormy.feature.current.model.CurrentRoutes
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CurrentRemoteDataSource @Inject constructor(@IoDispatcher val dispatcher: CoroutineDispatcher) :
    BaseRemoteDataSource() {

    /**
     * Pass US Zipcode, UK Postcode, Canada PostalCode, IP address, Latitude/Longitude (decimal degree) or city name
     * @param currentParams
     * @return Flow<CurrentResponse>
     */
    suspend fun getCurrent(currentParams: CurrentParams): Flow<CurrentResponse> = flow {
        val endpoint = CurrentRoutes.remote().route
        val response: CurrentResponse = client.get {
            url(endpoint)

            parameter("key", api.key)
            parameter("q", currentParams.q)

        }.body()

        emit(response)
    }.flowOn(dispatcher)
}