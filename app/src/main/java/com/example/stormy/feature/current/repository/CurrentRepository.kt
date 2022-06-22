package com.example.stormy.feature.current.repository

import com.example.stormy.feature.current.model.CurrentParams
import com.example.stormy.feature.current.model.CurrentResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CurrentRepository @Inject constructor(private val dataSource: CurrentRemoteDataSource) {
    suspend fun getCurrent(currentParams: CurrentParams): Flow<CurrentResponse> =
        dataSource.getCurrent(currentParams = currentParams)
}